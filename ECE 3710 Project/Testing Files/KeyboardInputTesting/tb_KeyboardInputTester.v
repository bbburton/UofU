`timescale 1ns / 1ps

module tb_KeyboardInputTesterNoSevenSeg;

	reg clk, data;
	wire[8:0] keysPressed;
	wire [7:0] bits;
	
	KeyboardInputTesterNoSevenSeg UUT(.clk(clk), .data(data), .keysPressed(keysPressed), .shiftRegBits(bits));
	
	initial begin
	
	$monitor("keysPressed: %b, bits: %x, time: %0d", keysPressed, bits, $time);	
	
	// Sending A key - 1C

	data = 1'b0;	
	clk = 1'b0;
	#5;
	data = 1'b0;
	#5;
	#5;
	data = 1'b0;
	#5;
	#5;
	data = 1'b1;
	#5;
	#5;
	data = 1'b1;
	#5;
	#5;
	data = 1'b1;
	#5;
	#5;
	data = 1'b0;
	#5;
	#5;
	data = 1'b0;
	#5;
	#5;
	data = 1'b0;
	#5;
	#5;
	data = 1'b0;
	#5;
	#5;
	data = 1'b1;
	#5;
	
	// Sending Down Arrow E0 then 72
	
	// E0 send
	#5;
	data = 1'b0;
	#5;
	#5;
	data = 1'b0;
	#5;
	#5;
	data = 1'b0;
	#5;
	#5;
	data = 1'b0;
	#5;
	#5;
	data = 1'b0;
	#5;
	#5;
	data = 1'b0;
	#5;
	#5;
	data = 1'b1;
	#5;
	#5;
	data = 1'b1;
	#5;
	#5;
	data = 1'b1;
	#5;
	#5;
	data = 1'b1;
	#5;
	#5;
	data = 1'b1;
	#5;
	
	// 72 Send
	#5;
	data = 1'b0;
	#5;
	#5;
	data = 1'b0;
	#5;
	#5;
	data = 1'b1;
	#5;
	#5;
	data = 1'b0;
	#5;
	#5;
	data = 1'b0;
	#5;
	#5;
	data = 1'b1;
	#5;
	#5;
	data = 1'b1;
	#5;
	#5;
	data = 1'b1;
	#5;
	#5;
	data = 1'b0;
	#5;
	#5;
	data = 1'b0;
	#5;
	#5;
	data = 1'b1;
	#5;
		
	#100;
	$finish;
	
	end
	
	always
		#5 clk = !clk;
		
endmodule