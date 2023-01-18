`timescale 1ns / 1ps

//Random Tester for ALU+Regfile
module tb_RegAluDatapath;

	// Inputs
	reg clk; 
	reg reset;
	reg immEn;
	reg flagsEn;
	reg writeEnb;
	reg [7:0] immediate;
	reg [3:0] destctl;
	reg [3:0] srcctl;
	reg [3:0] operation;
	
	// Outputs
	wire [15:0] AluBus;
	wire [4:0] Flags;
	
	integer i;
	
	parameter Shift = 4'b1000;

parameter AND = 4'b0001;
parameter OR = 4'b0010;
parameter XOR = 4'b0011;
parameter ADD = 4'b0101;
parameter ADDU = 4'b0110;
parameter ADDC = 4'b0111;
parameter SUB = 4'b1001;
parameter SUBC = 4'b1010;
parameter CMP = 4'b1011;
parameter NOT = 4'b1111;

parameter LSHI = 3'b000;
parameter LSH = 3'b010;
parameter ASHUI = 3'b001;
parameter ASHU = 3'b011;
	
	// Instantiate the Unit Under Test (UUT)
	RegAluDatapath uut(
		.clk(clk), 
		.reset(reset),
		.decoderCtrl(destctl),
		.mux1Ctrl(destctl), 
		.mux2Ctrl(srcctl), 
		.operation(operation), 
		.immEnb(immEn), 
		.immediate(immediate), 
		.flagsEnb(flagsEn), 
		.writeEnb(writeEnb),
		.Flags(Flags), 
		.AluBus(AluBus)
	);
	


initial begin

	$display("Simulation Begins...");
	clk = 0;
	reset = 1;
	clk = 1;

	immEn = 0;
	flagsEn = 1;
	immediate = 0;
	destctl = 0;
	srcctl = 0;
	operation = 0;
	writeEnb = 1;
	
	#100;
	//First, lets load some random values
	reset = 0;
	operation = OR;
	immEn = 1;
	
	for( i = 0; i < 16; i = i + 1)
		begin
			clk = 0;
			destctl = i;
			
			immediate = $random % 256;
			
			#10;
			clk = 1;
			#10;
			$display("Loaded %0d to Register %0d", AluBus, i);
		end
		
		
	//Next, Sequential Computations on same register

	for( i = 0; i < 16; i = i + 1)
		begin
			clk = 0;
			destctl = i;
			srcctl = (i + 1) % 16;
			immediate = 0;
			operation = OR;
			#10;
			clk = 1;
			#10;
			$display("Register %0d contains %0d", i, AluBus);
			
			$display("Subtracting 84 from Register %0d", i);
			clk = 0;
			operation = SUB;
			immediate = 84;
			#10;
			clk = 1;
			#10;
			$display("Result on ALUOut: %0d", i);
			
			$display("Left Shift -5 on Register %0d", i);
			clk = 0;
			operation = Shift;
			immediate = {LSH, 5'b11011};
			#10;
			clk = 1;
			#10;
			$display("Result on ALUOut: %0d", i);
			
			$display("Adding Register %0d to Register %0d", i, srcctl);
			clk = 0;
			immEn = 0;
			operation = ADD;
			#10;
			clk = 1;
			#10;
			$display("Result on ALUOut: %0d", AluBus);
			
			clk = 0;
			immediate = 0;
			immEn = 1;
			operation = OR;
			#10;
			clk = 1;
			#10;
			$display("Register %0d contains %0d", i, AluBus);
		end
		
	//Finally, operations on all registers in order
	operation = XOR;
	immediate = 58;
	for( i = 0; i < 16; i = i + 1)
		begin
			$display("XOR with 0x3A from Register %0d", i);
			clk = 0;
			destctl = i;
			#10;
			clk = 1;
			#10;
			$display("Result on ALUOut: %0d", AluBus, i);
		end
	
	operation = AND;
	immEn = 0;
	for( i = 0; i < 16; i = i + 1)
		begin
			srcctl = (i+1)%16;
			destctl = i;
			$display("AND with Register %0d on Register %0d", srcctl, i);
			clk = 0;
			#10;
			clk = 1;
			#10;
			$display("Result on ALUOut: %0d", AluBus, i);
		end
	$finish(2);
	
	operation = OR;
	immEn = 1;
	immediate = 0;
	for( i = 0; i < 16; i = i + 1)
		begin
			clk = 0;
			destctl = i;
			#10;
			clk = 1;
			#10;
			$display("Register %0d contains %0d", i, AluBus);
		end
	

end
      
endmodule 