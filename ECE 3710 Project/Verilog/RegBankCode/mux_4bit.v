`timescale 1ns / 1ps

module Mux_4bit(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, ctrl, r);
	 input [15:0] r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15;
	 input [3: 0] ctrl;
	 output reg [15:0] r;
	 
 always @(*)
	begin			
			case (ctrl)
				4'b0000:// 0
				begin
					r <= r0;
				end
				
				4'b0001: // 1
				begin
					r <= r1;
				end
				
				4'b0010:// 2
				begin
					r <= r2;
				end
				
				4'b0011: // 3
				begin
					r <= r3;
				end				

				4'b0100:// 4
				begin
					r <= r4;
				end
				
				4'b0101: // 5
				begin
					r <= r5;
				end			
			
				4'b0110: // 6
				begin
					r <= r6;
				end
				
				4'b0111: // 7
				begin
					r <= r7;
				end
	
				4'b1000: // 8
				begin
					r <= r8;
				end
				
				4'b1001: // 9
				begin
					r <= r9;
				end
			
				4'b1010:// 10
				begin
					r <= r10;
				end
				
				4'b1011: // 11
				begin
					r <= r11;
				end
	
				4'b1100:// 12
				begin
					r <= r12;
				end
			
				4'b1101: // 13
				begin
					r <= r13;
				end
				
				4'b1110: // 14
				begin
					r <= r14;
				end			

				4'b1111: // 15
				begin
					r <= r15;
				end
			endcase
	end
endmodule