//module CS3700_Lab5(NumSelector, Button, SevenSeg1, SevenSeg2, SevenSeg3, SevenSeg4);
//
//input [1:0] NumSelector; 
//input Button;
//output wire [0:6] SevenSeg1, SevenSeg2, SevenSeg3, SevenSeg4;
//reg [15:0] Src;
//reg [15:0] Dest;
//reg [3:0] Opcode;
//reg [7:0] Immediate;
//reg Carry;
//reg ImmEn;
//
//
//
//wire [15:0]  
//CPUFSM FSM (.Rst(Rst), .Clk(Clk), .R1Enb(R1Enb), .R2Enb(R2Enb), .RoutEnb(RoutEnb), .R2MuxSel(R2MuxSel), .DataBufEnb(DataBufEnb), .RoutBufEnb(RoutBufEnb), .OutputBufEnb(OutputBufEnb), .ALUSel(ALUSel));
//TriBuf4Bit DataBuf (.Y(Data), .Enb(DataBufEnb), .F(Bus));
//TriBuf4Bit RoutBuf (.Y(Rout), .Enb(RoutBufEnb), .F(Bus));
//R2Mux R2Muxer (.BusData(Bus), .Sel(R2MuxSel), .Out(R2Mux));
//Reg4Bit R1Reg (.R(Bus), .Clk(Clk), .Rst(Rst), .Enb(R1Enb), .Q(R1));
//Reg4Bit R2Reg (.R(R2Mux), .Clk(Clk), .Rst(Rst), .Enb(R2Enb), .Q(R2));
//ALU4Bit ALU (.A(R1), .B(R2), .Sel(ALUSel), .Result(ALUResult));
//Reg4Bit RoutReg (.R(ALUResult), .Clk(Clk), .Rst(Rst), .Enb(RoutEnb), .Q(Rout));
//TriBuf4Bit OutputBuf (.Y(Rout), .Enb(OutputBufEnb), .F(BCDOut));
//bcd_to_seven_seg converter (.bcd(BCDOut), .seven_seg(SevenSegOut));
//
//endmodule

module Demonstration(Button, SevenSeg1, SevenSeg2, SevenSeg3, SevenSeg4, Flags);

input Button;
output wire [0:6] SevenSeg1, SevenSeg2, SevenSeg3, SevenSeg4;
output wire [4:0] Flags;
wire[4:0] buttonCount;
wire[15:0] Dest = 16'b0110011011011111;
wire[15:0] Src = 16'b0100000101110111;
wire Carry = 1;
wire [15:0] Output;
wire[7:0] Immediate = 8'b11111110;


ButtonCounter FSM (.Button(Button), .Operation(Operation), .ImmEn(ImmEn));
ALU alu (.Immediate(Immediate), .Operation(Operation), .Dest(Dest), .Src(Src), .CarryIn(Carry), .ImmEn(ImmEn), .Out(Output), .FlagOuts(Flags));
bcd_to_seven_seg converter0 (.bcd(Output[3:0]), .seven_seg(SevenSegOut));
bcd_to_seven_seg converter1 (.bcd(Output[7:4]), .seven_seg(SevenSegOut));
bcd_to_seven_seg converter2 (.bcd(Output[11:8]), .seven_seg(SevenSegOut));
bcd_to_seven_seg converter3 (.bcd(Output[15:12]), .seven_seg(SevenSegOut));

endmodule
		

	

