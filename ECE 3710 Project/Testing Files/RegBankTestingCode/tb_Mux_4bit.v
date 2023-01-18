`timescale 1ns / 1ps

//Tester for 16 to 1 Mux
module tb_Mux_4bit;

reg [0:15] t_reg;

reg t_ctrl;

wire t_r;

integer i;

Mux_4bit uut (
	.r0(t_reg[0]), 
	.r1(t_reg[1]), 
	.r2(t_reg[2]), 
	.r3(t_reg[3]), 
	.r4(t_reg[4]), 
	.r5(t_reg[5]), 
	.r6(t_reg[6]), 
	.r7(t_reg[7]), 
	.r8(t_reg[8]), 
	.r9(t_reg[9]), 
	.r10(t_reg[10]), 
	.r11(t_reg[11]), 
	.r12(t_reg[12]), 
	.r13(t_reg[13]), 
	.r14(t_reg[14]), 
	.r15(t_reg[15]), 
	.ctrl(t_ctrl), 
	.r(t_r)
);

initial begin

	// Initialize Inputs
	$display("Simulation Begins...");

	for (i = 0; i < 2048; i = i + 1)

	begin

		{t_reg, t_ctrl} = i;
		#100
	
		if ({t_reg[t_ctrl]} != (t_r))
		$display ("Error at 16 to 1 MUX: t_reg =%b t_ctrl =%b t_r =%b", t_reg, t_ctrl, t_r);
	end

	$display("...Simulation Ends");

end

endmodule
