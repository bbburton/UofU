`timescale 1ns / 1ps

module RegisterInputMux(ALUOutput, MemOutput, PCOutput, KeyOutput, Ctrl, RegData);

input[15:0] ALUOutput, MemOutput, PCOutput, KeyOutput;
input [1: 0] Ctrl;
output reg [15:0] RegData;
parameter ALU = 2'b00;
parameter MEM = 2'b01;
parameter PC = 2'b10;
parameter KEY = 2'b11;

parameter EXZEROS = 8'b00000000;
parameter EXONES = 8'b11111111;
	 
 always @(*)
	begin	
			begin
				case (Ctrl)
					ALU:
						RegData = ALUOutput;
					MEM:
						RegData = MemOutput;
					PC:
						RegData = PCOutput;
					KEY:
						RegData = KeyOutput;
					default:
						RegData = ALUOutput;
				endcase
			end
	end
endmodule