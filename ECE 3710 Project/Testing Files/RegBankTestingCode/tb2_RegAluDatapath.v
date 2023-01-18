`timescale 1ns / 1ps

module tb2_RegAluDatapath;

reg clk;
reg reset;
reg immEnb;
reg flagsEnb;
reg [7:0] immediate;
reg [3:0] destCtrl, srcCtrl, operation, decoderCtrl;
wire [15:0] AluBus;
wire [4:0] Flags;

integer i;

RegAluDatapath uut(
.clk(clk), 
.reset(reset), 
.decoderCtrl(decoderCtrl), 
.mux1Ctrl(destCtrl), 
.mux2Ctrl(srcCtrl), 
.operation(operation), 
.immEnb(immEnb), 
.immediate(immediate), 
.flagsEnb(flagsEnb), 
.Flags(Flags), 
.AluBus(AluBus));

initial begin
clk = 0;
reset = 1;
clk = 1;

immEnb = 0;
flagsEnb = 1;
immediate = 0;
destCtrl = 0;
srcCtrl = 0;
operation = 0;
	
#100;
reset = 0;
immEnb = 1;

// Initialize registers
for( i = 0; i < 16; i = i + 1)
		begin
			clk = 0;
			destCtrl = i;
			
			immediate = 0;
			
			#10;
			clk = 1;
			#10;
		end

$display("Putting 1 in R0");
reset = 0;
#10
clk = 1;
#10
operation = 4'b0101; 
immediate = 8'b00000001; 
immEnb = 1; 
destCtrl = 4'b0000; 
srcCtrl = 4'b0000; 
decoderCtrl = 4'b0000; 
flagsEnb = 1;

#10;
clk = 0;
$display("Register %d contains %d", destCtrl, AluBus);
#10;
$display("Putting 2 in R1");
reset = 0;
#10
clk = 1;
#10
operation = 4'b0101; 
immediate = 8'b00000010; 
immEnb = 1; 
destCtrl = 4'b0001; 
srcCtrl = 4'b0000; 
decoderCtrl = 4'b0001; 
flagsEnb = 1;

#10;
clk = 0;
$display("Register %d contains %d", destCtrl, AluBus);
#10;
$display("Putting R0 + R1 in R2");
reset = 0;
#10
clk = 1;
#10
operation = 4'b0101; 
immediate = 8'b00000000; 
immEnb = 0; 
destCtrl = 4'b0001; 
srcCtrl = 4'b0000; 
decoderCtrl = 4'b0010; 
flagsEnb = 1;

#10;
clk = 0;
$display("Register %d contains %d", decoderCtrl, AluBus);
#10;
$display("Putting R2 - R1 in R2");
reset = 0;
#10
clk = 1;
#10;
operation = 4'b1001;
immediate = 8'b00000000;
immEnb = 0;
destCtrl = 4'b0010;
srcCtrl = 4'b0001;
decoderCtrl = 4'b0010;
flagsEnb = 1;

#10;
clk = 0;
$display("Register %d contains %d", decoderCtrl, AluBus);
#10;
$display("Putting R0 OR 0010 in R0");
reset = 0;
#10;
clk = 1;
#10;
operation = 4'b0010;
immediate = 8'b00000010;
immEnb = 1;
destCtrl = 4'b0000;
srcCtrl = 4'b0000;
decoderCtrl = 4'b0000;
flagsEnb = 1;

#10;
clk = 0;
$display("Register %d contains %d", decoderCtrl, AluBus);
#10;
$display("Putting R1 << 1 in R1");
reset = 0;
#10;
clk = 1;
#10;
operation = 4'b1000;
immediate = 8'b00000001;
immEnb = 1;
destCtrl = 4'b0001;
srcCtrl = 4'b0000;
decoderCtrl = 4'b0001;
flagsEnb = 1;

#10;
clk = 0;
$display("Register %d contains %d", decoderCtrl, AluBus);
#10;




$display("Resetting Registers");
reset = 1;
#10;
clk = 1;
#10;
$display("Register 0 contains %d", AluBus);
clk = 0;
#10;
clk = 1;
#10;
$display("Register 1 contains %d", AluBus);
clk = 0;
#10;
clk = 1;
#10;
$display("Register 2 contains %d", AluBus);
end
endmodule
