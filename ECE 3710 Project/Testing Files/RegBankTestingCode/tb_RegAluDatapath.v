`timescale 1ns / 1ps

//Tester for RegAluDatapath
module tb_RegAluDatapath;

	// Inputs
	reg t_clk; 
	reg t_reset;
	reg t_immEnb;
	reg t_flagsEnb;
	reg [7:0] t_immediate;
	reg [3:0] t_mux1Ctrl;
	reg [3:0] t_mux2Ctrl;
	reg [3:0] t_operation;
	reg [3:0] t_decoderCtrl;
	
	// Outputs
	wire [15:0] t_AluBus;
	wire [4:0] t_Flags;
	
	integer i;
	
	// Instantiate the Unit Under Test (UUT)
	RegAluDatapath uut(
		.clk(t_clk), 
		.reset(t_reset),
		.decoderCtrl(t_decoderCtrl),
		.mux1Ctrl(t_mux1Ctrl), 
		.mux2Ctrl(t_mux2Ctrl), 
		.operation(t_operation), 
		.immEnb(t_immEnb), 
		.immediate(t_immediate), 
		.flagsEnb(t_flagsEnb), 
		.Flags(t_Flags), 
		.AluBus(t_AluBus)
	);


initial begin

	$display("Simulation Begins...");
	
	

	$finish(2);

end
      
endmodule 