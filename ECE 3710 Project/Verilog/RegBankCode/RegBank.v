`timescale 1ns / 1ps

module RegBank(Bus, regEnable, clk, reset, r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15);
	input clk, reset;
	input [15:0] Bus;
	input [15:0] regEnable;
	output [15:0] r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15;

	
Register Inst0(
	.D_in(Bus),
	.wEnable(regEnable[0]),
	.reset(reset), 
	.clk(clk),
	.r(r0));
Register Inst1(Bus, regEnable[1], reset, clk, r1);
Register Inst2(Bus, regEnable[2], reset, clk, r2);
Register Inst3(Bus, regEnable[3], reset, clk, r3);
Register Inst4(Bus, regEnable[4], reset, clk, r4);
Register Inst5(Bus, regEnable[5], reset, clk, r5);
Register Inst6(Bus, regEnable[6], reset, clk, r6);
Register Inst7(Bus, regEnable[7], reset, clk, r7);
Register Inst8(Bus, regEnable[8], reset, clk, r8);
Register Inst9(Bus, regEnable[9], reset, clk, r9);
Register Inst10(Bus, regEnable[10], reset, clk, r10);
Register Inst11(Bus, regEnable[11], reset, clk, r11);
Register Inst12(Bus, regEnable[12], reset, clk, r12);
Register Inst13(Bus, regEnable[13], reset, clk, r13);
Register Inst14(Bus, regEnable[14], reset, clk, r14);
Register Inst15(Bus, regEnable[15], reset, clk, r15); 

endmodule