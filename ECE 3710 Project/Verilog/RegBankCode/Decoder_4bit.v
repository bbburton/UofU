`timescale 1ns / 1ps

module Decoder_4bit(ctrl, writeEnb, enbSignals);
input writeEnb;
input [3: 0] ctrl;
output reg [15:0] enbSignals;
	 
 always @(*)
	begin	
			if (writeEnb == 0)
			begin
				enbSignals <= 16'b0000000000000000;
			end
			else
			begin
				case (ctrl)
					4'b0000:// 0
					begin
						enbSignals <= 16'b0000000000000001;
					end
				
					4'b0001: // 1
					begin
						enbSignals <= 16'b0000000000000010;
					end
				
					4'b0010:// 2
					begin
						enbSignals <= 16'b0000000000000100;
					end
				
					4'b0011: // 3
					begin
						enbSignals <= 16'b0000000000001000;
					end				

					4'b0100:// 4
					begin
						enbSignals <= 16'b0000000000010000;
					end
				
					4'b0101: // 5
					begin
						enbSignals <= 16'b0000000000100000;
					end			
			
					4'b0110: // 6
					begin
						enbSignals <= 16'b0000000001000000;
					end
				
					4'b0111: // 7
					begin
						enbSignals <= 16'b0000000010000000;
					end
	
					4'b1000: // 8
					begin
						enbSignals <= 16'b0000000100000000;
					end
				
					4'b1001: // 9
					begin
						enbSignals <= 16'b0000001000000000;
					end
			
					4'b1010:// 10
					begin
						enbSignals <= 16'b0000010000000000;
					end
				
					4'b1011: // 11
					begin
						enbSignals <= 16'b0000100000000000;
					end
	
					4'b1100:// 12
					begin
						enbSignals <= 16'b0001000000000000;
					end
			
					4'b1101: // 13
					begin
						enbSignals <= 16'b0010000000000000;
					end
				
					4'b1110: // 14
					begin
						enbSignals <= 16'b0100000000000000;
					end			

					4'b1111: // 15
					begin
						enbSignals <= 16'b1000000000000000;
					end
				endcase
			end
	end
endmodule