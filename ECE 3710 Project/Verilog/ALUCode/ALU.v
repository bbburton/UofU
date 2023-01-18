module ALU( Immediate, Operation, Dest, Src, CarryIn, ImmEn, Out, FlagOuts );
input [15:0] Dest, Src;
input CarryIn;
input [7:0] Immediate;
input [3:0] Operation;
input ImmEn;

output reg [15:0] Out;

//CLFZN
output reg [4:0] FlagOuts;
parameter CARRY = 4;
parameter ULOW = 3;
parameter OVERFLOW = 2;
parameter ZERO = 1;
parameter NEGATIVE = 0;

reg [15:0] SrcOrImm;

parameter Reg = 4'b0000;
parameter Shift = 4'b1000;

parameter AND = 4'b0001;
parameter OR = 4'b0010;
parameter XOR = 4'b0011;
parameter ADD = 4'b0101;
parameter ADDU = 4'b0110;
parameter ADDC = 4'b0111;
parameter SUB = 4'b1001;
parameter SUBC = 4'b1010;
parameter CMP = 4'b1011;
parameter MOV = 4'b1101;
parameter NOT = 4'b0100;
parameter LU = 4'b1111;

parameter LSHI = 3'b000;
parameter LSH = 3'b010;
parameter ASHUI = 3'b001;
parameter ASHU = 3'b011;

parameter EXZEROS = 8'b00000000;
parameter EXONES = 8'b11111111;

always @(Immediate, Operation, ImmEn, Dest, Src, CarryIn)
begin
	SrcOrImm = Src;
		
	case(Operation)
		AND:
		begin
			if (ImmEn)
			begin
				SrcOrImm = {EXZEROS, Immediate};
			end
			Out = Dest & SrcOrImm;
			FlagOuts = 5'b00000;
			if (Out == 0)
				FlagOuts[ZERO] = 1'b1;
		end
		
		OR:
		begin
			if (ImmEn)
			begin
				SrcOrImm = {EXZEROS, Immediate};
			end
			Out = Dest | SrcOrImm;
			FlagOuts = 5'b00000;
			if (Out == 0)
				FlagOuts[ZERO] = 1'b1;
		end
		
		XOR:
		begin
			if (ImmEn)
			begin
				SrcOrImm = {EXZEROS, Immediate};
			end
			Out = Dest ^ SrcOrImm;
			FlagOuts = 5'b00000;
			if (Out == 0)
				FlagOuts[ZERO] = 1'b1;
		end
		
		NOT:
		begin
			Out = ~Dest;
			FlagOuts = 5'b00000;
		end
		
		ADD, ADDU, ADDC:
		begin
			FlagOuts = 5'b00000;
			if (ImmEn)
			begin
				if (Immediate[7] == 1'b1) // Sign Extend
				begin
					SrcOrImm = {EXONES, Immediate};
				end
				else
				begin
					SrcOrImm = {EXZEROS, Immediate};
				end
			end
			
			if (Operation == ADDC)
			begin
				{FlagOuts[CARRY], Out} = Dest + SrcOrImm + CarryIn;
			end
			else
			begin
				{FlagOuts[CARRY], Out} = Dest + SrcOrImm;
			end
			
			if ((~Dest[15] & ~SrcOrImm[15] & Out[15]) | (Dest[15] & SrcOrImm[15] & ~Out[15]))
				FlagOuts[OVERFLOW] = 1'b1;
			
			if (Out == 0)
				FlagOuts[ZERO] = 1'b1;
				
			FlagOuts[NEGATIVE] = Out[15] ^ FlagOuts[OVERFLOW]; // Correct even when overflow
		end
		
		SUB, SUBC, CMP:
		begin
			FlagOuts = 5'b00000;
			if (ImmEn)
			begin
				if (Immediate[7] == 1'b1) // Sign Extend
				begin
					SrcOrImm = {EXONES, Immediate};
				end
				else
				begin
					SrcOrImm = {EXZEROS, Immediate};
				end
				
				if(Dest < Immediate)
					FlagOuts[ULOW] = 1'b1;
			end
			
			if (Operation == SUBC)
			begin
				{FlagOuts[CARRY], Out} = Dest + ( ~SrcOrImm) + CarryIn;
			end
			else
			begin
				{FlagOuts[CARRY], Out} = Dest + ( ~SrcOrImm) + 1;
			end
			
			if(Dest < SrcOrImm)
				FlagOuts[ULOW] = 1'b1;
					
			if ((~Dest[15] & SrcOrImm[15] & Out[15]) | (Dest[15] & ~SrcOrImm[15] & ~Out[15]))
				FlagOuts[OVERFLOW] = 1'b1;
			
			if (Out == 0)
				FlagOuts[ZERO] = 1'b1;
				
			FlagOuts[NEGATIVE] = Out[15] ^ FlagOuts[OVERFLOW]; // Correct even when overflow
			
		end
		
		MOV:
		begin
			FlagOuts = 5'bXXXXX;
			if (ImmEn)
				SrcOrImm = {EXZEROS, Immediate};
			Out = SrcOrImm;
		end
		
		LU:
		begin
			FlagOuts = 5'bXXXXX;
			if (ImmEn)
				SrcOrImm = {EXZEROS, Immediate};
			Out = SrcOrImm << 8;
		end
		
		Shift: //Left hand side = variable to shift. Right hand side = number of shifts to perform.
		begin
			case(Immediate[7:5])
				LSHI:
				begin
					FlagOuts = 5'b00000;
					
					if (Immediate[4] == 1'b1)
					begin
						Out = Dest >> Immediate[3:0];
					end
					else
					begin
						Out = Dest << Immediate[3:0];
					end
					
					if (Out == 1'b0)
						FlagOuts[ZERO] = 1'b1;
				
					FlagOuts[NEGATIVE] = Out[15];
				end
				
				LSH:
				begin
					FlagOuts = 5'b00000;
					
					if (SrcOrImm[4] == 1'b1)
					begin
						Out = Dest >> SrcOrImm[3:0];
					end
					else
					begin
						Out = Dest << SrcOrImm[3:0];
					end
			
					if (Out == 1'b0)
						FlagOuts[ZERO] = 1'b1;
				
					FlagOuts[NEGATIVE] = Out[15];
				end

				ASHUI:
				begin
					FlagOuts = 5'b00000;
					
					if (Immediate[4] == 1'b1)
					begin
						SrcOrImm[3:0] = !Immediate[3:0] + 1;
						Out = $signed(Dest) >>> SrcOrImm[3:0];
					end
					else
					begin
						SrcOrImm[3:0] = Immediate[3:0];
						Out = $signed(Dest) <<< SrcOrImm[3:0];
					end
					
					if (Out == 1'b0)
						FlagOuts[ZERO] = 1'b1;
				
					FlagOuts[NEGATIVE] = Out[15];
				end
				
				ASHU:
				begin
					FlagOuts = 5'b00000;
					
					if (SrcOrImm[4] == 1'b1)
					begin
						SrcOrImm[3:0] = !SrcOrImm[3:0] + 1;
						Out = $signed(Dest) >>> SrcOrImm[3:0];
					end
					else
					begin
						Out = $signed(Dest) <<< SrcOrImm[3:0];
					end
			
					if (Out == 1'b0)
						FlagOuts[ZERO] = 1'b1;
				
					FlagOuts[NEGATIVE] = Out[15];
				end
				
				default:
				begin
					FlagOuts = 5'bXXXXX;
					Out = 16'bXXXXXXXXXXXXXXXX;
				end
			endcase
		end
		
		default:
		begin
			FlagOuts = 5'bXXXXX;
			Out = 16'bXXXXXXXXXXXXXXXX;
		end
	endcase
end
endmodule
