module CPUControl(Clk, Reset, Data, RSrcIn, Flags, ImmEnb, WriteRegs, WriteFlags, RegStoreClk, RegStoreCtrl, Operation, RDestCtrl, RSrcCtrl, Immediate, PC, MemWrEn, RegAddrEn);
input Clk;
input Reset;
input [15:0]Data, RSrcIn;
input [4:0]Flags;

output reg ImmEnb, WriteFlags, WriteRegs, RegStoreClk, MemWrEn, RegAddrEn;
output reg [1:0] RegStoreCtrl;
output reg [3:0] Operation, RDestCtrl, RSrcCtrl;
output reg [7:0] Immediate;
output reg [15:0] PC;

reg[1:0] State;
reg[3:0] Condition;
reg Load, Store, RelEn, AbsEn, JmpEn, BrSrc;
reg[15:0] Instruction;
reg PCEn;

parameter FETCH = 2'h0;
parameter DECODE = 2'h1;
parameter MEMRW = 2'h2;
parameter DONE = 2'h3;

parameter ADDU = 4'b0110;
parameter CMP = 4'b1011;
parameter WAIT = 4'b0000;
parameter MOV = 4'b1101;
parameter LU = 4'b1111;

parameter CARRY = 4;
parameter ULOW = 3;
parameter OVERFLOW = 2;
parameter ZERO = 1;
parameter NEGATIVE = 0;

parameter EQ = 4'h0;
parameter NE = 4'h1;
parameter CS = 4'h2;
parameter CC = 4'h3;
parameter HI = 4'h4;
parameter LS = 4'h5;
parameter GT = 4'h6;
parameter LE = 4'h7;
parameter FS = 4'hC;
parameter FC = 4'hD;
parameter LO = 4'hA;
parameter HS = 4'hB;
parameter LT = 4'h8;
parameter GE = 4'h9;
parameter UC = 4'hE;
parameter NO = 4'hF;

parameter ALU = 2'b00;
parameter MEM = 2'b01;
parameter STPC = 2'b10;
parameter KEY = 2'b11;

parameter EXZEROS = 8'b00000000;
parameter EXONES = 8'b11111111;

// Occurs at clock to determine next State. Reads Current State, sets up the next State.
always @(posedge Clk, posedge Reset)
begin
	if (Reset)
		State <= FETCH;
	
	else 
	begin
	case (State)
		FETCH:
		begin
			if (PC == 16'hFFFF)
				State <= DONE;
			
			else
			begin
				Instruction <= Data;
				State <= DECODE;
			end
		end
	
		DECODE:
		begin
			if (Load == 1'b1 | Store == 1'b1)
				State <= MEMRW;
			else
				State <= FETCH;
		end
		
		MEMRW:
			State <= FETCH;
	
		DONE:
			State <= DONE;
		
		default:
			State <= FETCH;
			
	endcase
	end
end

//PC
always @(posedge Clk, posedge Reset)
begin
	if(Reset == 1'b1)
	begin
		PC <= 0;
	end
		
	else if (PCEn == 1'b0)
		PC <= PC;
		
	else if(JmpEn & RelEn & ~AbsEn)
	begin
		if (BrSrc)
			PC <= PC + RSrcIn;
		else if (Immediate[7] == 1'b1) // Sign Extend
			PC <= PC + {EXONES, Immediate};
		else
			PC <= PC + {EXZEROS, Immediate};
	end
		
	else if(JmpEn & AbsEn & ~RelEn)
	begin
		PC <= RSrcIn;
	end
	
	else
		PC <= PC + 1;
end

// From here down is the combinational bits of the circuit. It should all be blocking assignment (=) and there should be no latches on the output.
always @(Instruction, State, Flags)
begin
	Operation = Instruction[15:12];
	RDestCtrl = Instruction[11:8];
	Condition = Instruction [11:8];
	RSrcCtrl = Instruction[3:0];
	Immediate = Instruction[7:0];
	
	ImmEnb = 1'b0;
	WriteFlags = 1'b1;
	WriteRegs = 1'b1;
	Load = 1'b0;
	Store = 1'b0;
	RelEn = 1'b0;
	AbsEn = 1'b0;
	BrSrc = 1'b0;
	RegStoreCtrl = ALU;
	
	if(Operation == 4'b0000)
	begin
		Operation = Instruction[7:4];
		case(Instruction[7:4])
			WAIT:
			begin
				WriteFlags = 1'b0;
				WriteRegs = 1'b0;
			end
			CMP:
				WriteRegs = 1'b0;
			ADDU, MOV, LU:
				WriteFlags = 1'b0;
		endcase
	end
	
	else
	begin
		if(Operation == 4'b0100)
		begin
			WriteFlags = 1'b0;
			case (Instruction[7:4])
				4'b0000: //Load
				begin
					Load = 1'b1;
					RegStoreCtrl = MEM;
				end
				4'b0100: //Store
				begin
					Store = 1'b1;
					WriteRegs = 1'b0;
				end
				4'b1000: //JAL
				begin
					AbsEn = 1'b1;
					RegStoreCtrl = STPC;
					Condition = UC;
				end
				4'b1100: // Jcond
				begin
					AbsEn = 1'b1;
					WriteRegs = 1'b0;
				end
				4'b1110: // BRCond
				begin
					BrSrc = 1'b1;
					WriteRegs = 1'b0;
					RelEn = 1'b1;
				end
				4'b1111: // LDKEY
				begin
					RegStoreCtrl = KEY;
				end
				default:
					WriteRegs = 1'b0;
			endcase
		end
		else if(Instruction[15:12] == 4'b1100) // BCond
		begin
			RelEn = 1'b1;
			WriteRegs = 1'b0;
			WriteFlags = 1'b0;
		end
		else
		begin
			ImmEnb = 1;
			case(Operation)
				CMP:
					WriteRegs = 1'b0;
				ADDU, MOV, LU: // LI in this case is MOV
					WriteFlags = 1'b0;
			endcase
		end
	end
	
	case (Condition)
		EQ:
			JmpEn = Flags[ZERO];
		NE:
			JmpEn = ~Flags[ZERO];
		CS:
			JmpEn = Flags[CARRY];
		CC:
			JmpEn = ~Flags[CARRY];
		HI:
			JmpEn = ~Flags[ULOW] & ~Flags[ZERO];
		LS:
			JmpEn = Flags[ULOW] | Flags[ZERO];
		GT:
			JmpEn = ~Flags[NEGATIVE] & ~Flags[ZERO];
		LE:
			JmpEn = Flags[NEGATIVE] | Flags[ZERO];
		FS:
			JmpEn = Flags[OVERFLOW];
		FC:
			JmpEn = ~Flags[OVERFLOW];
		LO:
			JmpEn = Flags[ULOW];
		HS:
			JmpEn = ~Flags[ULOW];
		LT:
			JmpEn = Flags[NEGATIVE];
		GE:
			JmpEn = ~Flags[NEGATIVE];
		UC:
			JmpEn = 1'b1;
		NO:
			JmpEn = 1'b0;
	endcase
	
	//State dependent combinational
	
	case(State)
		DECODE:
		begin
			PCEn = 1'b1;
			RegStoreClk = 1'b0;
			MemWrEn = 1'b0;
			RegAddrEn = 1'b0;
		end
		MEMRW:
		begin
			PCEn = 1'b0;
			RegStoreClk = 1'b0;
			MemWrEn = Store;
			RegAddrEn = 1'b1;
		end
		default:
		begin
			PCEn = 1'b0;
			RegStoreClk = 1'b1;
			MemWrEn = 1'b0;
			RegAddrEn = 1'b0;
		end
	endcase
end


endmodule