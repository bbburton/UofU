`timescale 1ns / 1ps
// tester for ADD,ADDI,ADDU,ADDUI,ADDC,ADDCU,ADDCUI,ADDCI,SUB,SUBI,CMP,CMPI,CMPU/I

module tb_CPU;

	// Inputs
	reg clk, reset, PS2Clk, PS2Data;
	
	// Outputs
	wire vga_blank_n, vga_vs, vga_hs, vga_clk;
	wire [7:0] r, g, b;

	// Instantiate the Unit Under Test (UUT)	
	CPUControlDatapath UUT(clk, clk, reset, PS2Clk, PS2Data, vga_blank_n, vga_clk, vga_vs, vga_hs, r, g, b);

	initial begin
		clk = 0;
		reset = 1;
		PS2Clk = 1;
		PS2Data = 0;
		#100;
		reset = 0;
	end

	always begin
		clk = ~clk;
		#10;
	end
endmodule
	