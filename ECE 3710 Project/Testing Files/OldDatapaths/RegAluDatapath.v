`timescale 1ns / 1ps

module RegAluDatapath(clk, reset, decoderCtrl, mux1Ctrl, mux2Ctrl, operation, immEnb, immediate, flagsEnb, Flags, AluBus);

input clk, reset, immEnb, flagsEnb;
input [7:0] immediate;
input [3:0] mux1Ctrl, mux2Ctrl, operation, decoderCtrl;
output wire [15:0] AluBus;
output wire [4:0] Flags;
wire [4:0] FlagsIn;
wire [15:0] r0, r1, r2, r3, r4, r5, r6, r7, r8 , r9 , r10, r11, r12, r13, r14, r15, Dest, Src, regWriteEnb;
wire [3:0] Operation;
wire carry;

Decoder_4bit decoder (.ctrl(decoderCtrl), .enbSignals(regWriteEnb));
RegBank registers (.ALUBus(AluBus), .regEnable(regWriteEnb), .clk(clk), .reset(reset), .r0(r0), .r1(r1), .r2(r2), .r3(r3), .r4(r4), .r5(r5), .r6(r6), .r7(r7), .r8(r8), .r9(r9), .r10(r10), .r11(r11), .r12(r12), .r13(r13), .r14(r14), .r15(r15));
Mux_4bit destMux (.r0(r0), .r1(r1), .r2(r2), .r3(r3), .r4(r4), .r5(r5), .r6(r6), .r7(r7), .r8(r8), .r9(r9), .r10(r10), .r11(r11), .r12(r12), .r13(r13), .r14(r14), .r15(r15), .ctrl(mux1Ctrl), .r(Dest));
Mux_4bit srcMux (.r0(r0), .r1(r1), .r2(r2), .r3(r3), .r4(r4), .r5(r5), .r6(r6), .r7(r7), .r8(r8), .r9(r9), .r10(r10), .r11(r11), .r12(r12), .r13(r13), .r14(r14), .r15(r15), .ctrl(mux2Ctrl), .r(Src));
ALU alu (.Immediate(immediate), .Operation(operation), .Dest(Dest), .Src(Src), .CarryIn(carry), .ImmEn(immEnb), .Out(AluBus), .FlagOuts(FlagsIn));
FlagsReg flagRegister (.D_in(FlagsIn), .wEnable(flagsEnb), .reset(reset), .clk(clk), .flags(Flags), .carry(carry));

endmodule 