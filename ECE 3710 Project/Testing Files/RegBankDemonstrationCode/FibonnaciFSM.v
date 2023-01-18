module Fibonnacci_FSM(clk, Reset, Operation, ImmEn, DestSelector, SrcSelector, DecoderCtrl, FlagsEnb, Immediate, WriteEnb);
input clk, Reset;
output reg [3:0] Operation;
output reg ImmEn, FlagsEnb, WriteEnb;
output reg [3:0] DestSelector, SrcSelector, DecoderCtrl;
output reg [7:0] Immediate;

reg[5:0] clkCounter;

parameter ADD = 4'b0101;

always @(negedge clk, posedge Reset)
begin
	if (Reset == 1)
	begin
	   clkCounter <= 0;
	end
	
	else if(clk == 0)
	begin
		clkCounter <= clkCounter + 1;
	end
	
	else
		clkCounter <= clkCounter;
end
	
always@(clkCounter)
begin
	case(clkCounter)
		1:// Put 1 in r0
		begin 
			Operation <= ADD; Immediate <= 8'b00000001; ImmEn <= 1; DestSelector <= 4'b0000; SrcSelector = 4'b0000; DecoderCtrl = 4'b0000; WriteEnb <= 1; FlagsEnb = 1; 
		end
		2:// Put 1 in r1
		begin
			Operation <= ADD; Immediate <= 8'b00000001; ImmEn <= 1; DestSelector <= 4'b0001; SrcSelector = 4'b0000; DecoderCtrl = 4'b0001; WriteEnb <= 1; FlagsEnb = 1; 
		end
		3:// Put r0 + r1 in r2
		begin
			Operation <= ADD; Immediate <= 8'b00000000; ImmEn <= 0; DestSelector <= 4'b0000; SrcSelector = 4'b0001; DecoderCtrl = 4'b0010; WriteEnb <= 1; FlagsEnb = 1; 
		end
		4:// Put r1 + r2 in r3
		begin
			Operation <= ADD; Immediate <= 8'b00000000; ImmEn <= 0; DestSelector <= 4'b0001; SrcSelector = 4'b0010; DecoderCtrl = 4'b0011; WriteEnb <= 1; FlagsEnb = 1; 
		end
		5: // Put r2 + r3 in r4
		begin
			Operation <= ADD; Immediate <= 8'b00000000; ImmEn <= 0; DestSelector <= 4'b0010; SrcSelector = 4'b0011; DecoderCtrl = 4'b0100; WriteEnb <= 1; FlagsEnb = 1; 
		end	
		6: // Put r3 + r4 in r5
		begin
			Operation <= ADD; Immediate <= 8'b00000000; ImmEn <= 0; DestSelector <= 4'b0011; SrcSelector = 4'b0100; DecoderCtrl = 4'b0101; WriteEnb <= 1; FlagsEnb = 1; 
		end
		7: // Put r4 + r5 in r6
		begin
			Operation <= ADD; Immediate <= 8'b00000000; ImmEn <= 0; DestSelector <= 4'b0100; SrcSelector = 4'b0101; DecoderCtrl = 4'b0110; WriteEnb <= 1; FlagsEnb = 1; 
		end
		8: // Put r5 + r6 in r7
		begin
			Operation <= ADD; Immediate <= 8'b00000000; ImmEn <= 0; DestSelector <= 4'b0101; SrcSelector = 4'b0110; DecoderCtrl = 4'b0111; WriteEnb <= 1; FlagsEnb = 1; 
		end
		9: // Put r6 + r7 in r8
		begin
			Operation <= ADD; Immediate <= 8'b00000000; ImmEn <= 0; DestSelector <= 4'b0110; SrcSelector = 4'b0111; DecoderCtrl = 4'b1000; WriteEnb <= 1; FlagsEnb = 1; 
		end
		10: // Put r7 + r8 in r9
		begin
			Operation <= ADD; Immediate <= 8'b00000000; ImmEn <= 0; DestSelector <= 4'b0111; SrcSelector = 4'b1000; DecoderCtrl = 4'b1001; WriteEnb <= 1; FlagsEnb = 1; 
		end
		11: // Put r8 + r9 in r10
		begin
			Operation <= ADD; Immediate <= 8'b00000000; ImmEn <= 0; DestSelector <= 4'b1000; SrcSelector = 4'b1001; DecoderCtrl = 4'b1010; WriteEnb <= 1; FlagsEnb = 1; 
		end
		12: // Put r9 + r10 in r11
		begin
			Operation <= ADD; Immediate <= 8'b00000000; ImmEn <= 0; DestSelector <= 4'b1001; SrcSelector = 4'b1010; DecoderCtrl = 4'b1011; WriteEnb <= 1; FlagsEnb = 1; 
		end
		13: // Put r10 + r11 in r12
		begin
			Operation <= ADD; Immediate <= 8'b00000000; ImmEn <= 0; DestSelector <= 4'b1010; SrcSelector = 4'b1011; DecoderCtrl = 4'b1100; WriteEnb <= 1; FlagsEnb = 1; 
		end
		14: // Put r11 + r12 in r13
		begin
			Operation <= ADD; Immediate <= 8'b00000000; ImmEn <= 0; DestSelector <= 4'b1011; SrcSelector = 4'b1100; DecoderCtrl = 4'b1101; WriteEnb <= 1; FlagsEnb = 1; 
		end
		15: // Put r12 + r13 in r14
		begin
			Operation <= ADD; Immediate <= 8'b00000000; ImmEn <= 0; DestSelector <= 4'b1100; SrcSelector = 4'b1101; DecoderCtrl = 4'b1110; WriteEnb <= 1; FlagsEnb = 1; 
		end
		16: // Put r13 + r14 in r15
		begin
			Operation <= ADD; Immediate <= 8'b00000000; ImmEn <= 0; DestSelector <= 4'b1101; SrcSelector = 4'b1110; DecoderCtrl = 4'b1111; WriteEnb <= 1; FlagsEnb = 1; 
		end
		17: // Display r0 by doing r0 + 0
		begin 
			Operation <= ADD; Immediate <= 8'b00000000; ImmEn <= 1; DestSelector <= 4'b0000; SrcSelector = 4'b0000; DecoderCtrl = 4'b0000; WriteEnb <= 0; FlagsEnb = 1; 
		end
		18: // Display r1 by doing r1 + 0
		begin 
			Operation <= ADD; Immediate <= 8'b00000000; ImmEn <= 1; DestSelector <= 4'b0001; SrcSelector = 4'b0000; DecoderCtrl = 4'b0000; WriteEnb <= 0; FlagsEnb = 1; 
		end
		19: // Display r2 by doing r2 + 0
		begin 
			Operation <= ADD; Immediate <= 8'b00000000; ImmEn <= 1; DestSelector <= 4'b0010; SrcSelector = 4'b0000; DecoderCtrl = 4'b0000; WriteEnb <= 0; FlagsEnb = 1; 
		end
		20: // Display r3 by doing r3 + 0
		begin 
			Operation <= ADD; Immediate <= 8'b00000000; ImmEn <= 1; DestSelector <= 4'b0011; SrcSelector = 4'b0000; DecoderCtrl = 4'b0000; WriteEnb <= 0; FlagsEnb = 1; 
		end
		21: // Display r4 by doing r4 + 0
		begin 
			Operation <= ADD; Immediate <= 8'b00000000; ImmEn <= 1; DestSelector <= 4'b0100; SrcSelector = 4'b0000; DecoderCtrl = 4'b0000; WriteEnb <= 0; FlagsEnb = 1; 
		end
		22: // Display r5 by doing r5 + 0
		begin 
			Operation <= ADD; Immediate <= 8'b00000000; ImmEn <= 1; DestSelector <= 4'b0101; SrcSelector = 4'b0000; DecoderCtrl = 4'b0000; WriteEnb <= 0; FlagsEnb = 1; 
		end
		23: // Display r6 by doing r6 + 0
		begin 
			Operation <= ADD; Immediate <= 8'b00000000; ImmEn <= 1; DestSelector <= 4'b0110; SrcSelector = 4'b0000; DecoderCtrl = 4'b0000; WriteEnb <= 0; FlagsEnb = 1; 
		end
		24: // Display r7 by doing r7 + 0
		begin 
			Operation <= ADD; Immediate <= 8'b00000000; ImmEn <= 1; DestSelector <= 4'b0111; SrcSelector = 4'b0000; DecoderCtrl = 4'b0000; WriteEnb <= 0; FlagsEnb = 1; 
		end
		25: // Display r8 by doing r8 + 0
		begin 
			Operation <= ADD; Immediate <= 8'b00000000; ImmEn <= 1; DestSelector <= 4'b1000; SrcSelector = 4'b0000; DecoderCtrl = 4'b0000; WriteEnb <= 0; FlagsEnb = 1; 
		end
		26: // Display r9 by doing r9 + 0
		begin 
			Operation <= ADD; Immediate <= 8'b00000000; ImmEn <= 1; DestSelector <= 4'b1001; SrcSelector = 4'b0000; DecoderCtrl = 4'b0000; WriteEnb <= 0; FlagsEnb = 1; 
		end
		27: // Display r10 by doing r10 + 0
		begin 
			Operation <= ADD; Immediate <= 8'b00000000; ImmEn <= 1; DestSelector <= 4'b1010; SrcSelector = 4'b0000; DecoderCtrl = 4'b0000; WriteEnb <= 0; FlagsEnb = 1; 
		end		
		28: // Display r11 by doing r11 + 0
		begin 
			Operation <= ADD; Immediate <= 8'b00000000; ImmEn <= 1; DestSelector <= 4'b1011; SrcSelector = 4'b0000; DecoderCtrl = 4'b0000; WriteEnb <= 0; FlagsEnb = 1; 
		end
		29: // Display r12 by doing r12 + 0
		begin 
			Operation <= ADD; Immediate <= 8'b00000000; ImmEn <= 1; DestSelector <= 4'b1100; SrcSelector = 4'b0000; DecoderCtrl = 4'b0000; WriteEnb <= 0; FlagsEnb = 1; 
		end
		30: // Display r13 by doing r13 + 0
		begin 
			Operation <= ADD; Immediate <= 8'b00000000; ImmEn <= 1; DestSelector <= 4'b1101; SrcSelector = 4'b0000; DecoderCtrl = 4'b0000; WriteEnb <= 0; FlagsEnb = 1; 
		end
		31: // Display r14 by doing r14 + 0
		begin 
			Operation <= ADD; Immediate <= 8'b00000000; ImmEn <= 1; DestSelector <= 4'b1110; SrcSelector = 4'b0000; DecoderCtrl = 4'b0000; WriteEnb <= 0; FlagsEnb = 1; 
		end
		32: // Display r15 by doing r15 + 0
		begin 
			Operation <= ADD; Immediate <= 8'b00000000; ImmEn <= 1; DestSelector <= 4'b1111; SrcSelector = 4'b0000; DecoderCtrl = 4'b0000; WriteEnb <= 0; FlagsEnb = 1; 
		end
		default: // Displays r0 + 0 and doesn't change anything
		begin 
			Operation <= ADD; Immediate <= 8'b00000000; ImmEn <= 1; DestSelector <= 4'b0000; SrcSelector = 4'b0000; DecoderCtrl = 4'b0000; WriteEnb <= 0; FlagsEnb = 1; 
		end	
	endcase
	end
endmodule