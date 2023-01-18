`timescale 1ns / 1ps

module DemoFibonacciRegisters(Button, Reset, SevenSeg1, SevenSeg2, SevenSeg3, SevenSeg4, Flags);

input Button;
input Reset;
output wire [0:6] SevenSeg1, SevenSeg2, SevenSeg3, SevenSeg4;
output wire [4:0] Flags;
wire [3:0] Operation, DestSelector, SrcSelector, DecoderCtrl;
wire ImmEnb, FlagsEnb, WriteEnb;
wire[7:0] Immediate;
wire[15:0] Output;

Fibonnacci_FSM FSM (.clk(Button), .Reset(Reset), .Operation(Operation), .ImmEn(ImmEnb), .DestSelector(DestSelector), .SrcSelector(SrcSelector), .DecoderCtrl(DecoderCtrl), .FlagsEnb(FlagsEnb), .Immediate(Immediate), .WriteEnb(WriteEnb));
RegAluDatapath datapath (.clk(Button), .reset(Reset), .decoderCtrl(DecoderCtrl), .mux1Ctrl(DestSelector), .mux2Ctrl(SrcSelector), .operation(Operation), .immEnb(ImmEnb), .immediate(Immediate), .flagsEnb(FlagsEnb), .writeEnb(WriteEnb), .Flags(Flags), .AluBus(Output));
bcd_to_seven_seg converter0 (.bcd(Output[3:0]), .seven_seg(SevenSeg1));
bcd_to_seven_seg converter1 (.bcd(Output[7:4]), .seven_seg(SevenSeg2));
bcd_to_seven_seg converter2 (.bcd(Output[11:8]), .seven_seg(SevenSeg3));
bcd_to_seven_seg converter3 (.bcd(Output[15:12]), .seven_seg(SevenSeg4));

endmodule