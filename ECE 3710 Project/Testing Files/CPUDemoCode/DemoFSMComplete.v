`timescale 1ns / 1ps

module DemoFSMComplete(clk, Reset, SevenSeg1, SevenSeg2, SevenSeg3, SevenSeg4);

input clk;
input Reset;
output wire [0:6] SevenSeg1, SevenSeg2, SevenSeg3, SevenSeg4;
wire [15:0] Output;


CompleteDatapath datapath (.clk(clk), .reset(Reset), .Bus(Output));
bcd_to_seven_seg converter0 (.bcd(Output[3:0]), .seven_seg(SevenSeg1));
bcd_to_seven_seg converter1 (.bcd(Output[7:4]), .seven_seg(SevenSeg2));
bcd_to_seven_seg converter2 (.bcd(Output[11:8]), .seven_seg(SevenSeg3));
bcd_to_seven_seg converter3 (.bcd(Output[15:12]), .seven_seg(SevenSeg4));

endmodule
