`timescale 1ns / 1ps

module FlagsReg(D_in, wEnable, reset, clk, flags, carry);
	 input [4:0] D_in;
	 input clk, wEnable, reset;
	 output reg [4:0] flags;
	 output reg carry;
	 
 always @( posedge clk )
	begin
	if (reset) 
		begin
			flags <= 5'b00000; carry <= 0;
		end
	else
		begin			
			if (wEnable)
				begin
					flags <= D_in; carry <= D_in[4];
				end
			else
				begin
					flags <= flags; carry <= flags[4];
				end
		end
	end
endmodule