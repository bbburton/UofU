//`timescale 1ns / 1ps

module CPUControlDatapath(clk, vgaclk, reset, PS2Clk, PS2Data, vga_blank_n, vga_clk, vga_vs, vga_hs, r, g, b, SevenSeg1, SevenSeg2, SevenSeg3, SevenSeg4);

input clk, reset, PS2Clk, PS2Data, vgaclk;
output vga_blank_n, vga_vs, vga_hs, vga_clk;
output [7:0] r, g, b;
output [0:6] SevenSeg1, SevenSeg2, SevenSeg3, SevenSeg4;

wire ImmEnb, FlagsEnb, RegsEnb, Carry, RegClk, MemWrEn, RegAddrEn, AWrEn;
wire [1:0] RegStoreCtrl;
wire [4:0] Flags, FlagsIn; 
wire [15:0] PC, Bus, MemData, Src, Dest, AluBus, AAddr, AddrB, OutB, r0, r1, r2, r3, r4, r5, r6, ScoreReg, r8, r9, r10, r11, r12, r13, r14, r15, RegWriteEnbs, keysPressed;
wire [3:0] Operation, RDestCtrl, RSrcCtrl;
wire [7:0] Immediate;
wire ZERO = 0;
wire [3:0] ONE = 1;
wire [3:0] TWO = 2;

CPUControl control (.Clk(clk), .Reset(reset), .Data(MemData), .RSrcIn(Src), .Flags(Flags), .ImmEnb(ImmEnb), .WriteRegs(RegsEnb), .WriteFlags(FlagsEnb), 
		.RegStoreClk(RegClk), .RegStoreCtrl(RegStoreCtrl), .Operation(Operation), .RDestCtrl(RDestCtrl), .RSrcCtrl(RSrcCtrl), .Immediate(Immediate), .PC(PC), .MemWrEn(MemWrEn), .RegAddrEn(RegAddrEn));

Decoder_4bit decoder (.ctrl(RDestCtrl), .writeEnb(RegsEnb), .enbSignals(RegWriteEnbs));

RegBank registers (.Bus(Bus), .regEnable(RegWriteEnbs), .clk(RegClk), .reset(reset), .r0(r0), .r1(r1), .r2(r2), .r3(r3), .r4(r4), .r5(r5), .r6(r6), .r7(ScoreReg), 
						.r8(r8), .r9(r9), .r10(r10), .r11(r11), .r12(r12), .r13(r13), .r14(r14), .r15(r15));
						
Mux_4bit destMux (.r0(r0), .r1(r1), .r2(r2), .r3(r3), .r4(r4), .r5(r5), .r6(r6), .r7(ScoreReg), .r8(r8), .r9(r9), .r10(r10), .r11(r11), .r12(r12), .r13(r13), 
						.r14(r14), .r15(r15), .ctrl(RDestCtrl), .r(Dest));
						
Mux_4bit srcMux (.r0(r0), .r1(r1), .r2(r2), .r3(r3), .r4(r4), .r5(r5), .r6(r6), .r7(ScoreReg), .r8(r8), .r9(r9), .r10(r10), .r11(r11), .r12(r12), .r13(r13), 
						.r14(r14), .r15(r15), .ctrl(RSrcCtrl), .r(Src));
						
ALU alu (.Immediate(Immediate), .Operation(Operation), .Dest(Dest), .Src(Src), .CarryIn(Carry), .ImmEn(ImmEnb), .Out(AluBus), .FlagOuts(FlagsIn));

FlagsReg flagRegister (.D_in(FlagsIn), .wEnable(FlagsEnb), .reset(reset), .clk(RegClk), .flags(Flags), .carry(Carry));

RegisterInputMux regInputMux (.ALUOutput(AluBus), .MemOutput(MemData), .PCOutput(PC), .KeyOutput(keysPressed), .Ctrl(RegStoreCtrl), .RegData(Bus));

vga vga(.clk(clk), .reset(reset), .sys_data(OutB), .vga_clk(vga_clk), .vga_blank_n(vga_blank_n), .vga_vs(vga_vs), .vga_hs(vga_hs), .r(r), .g(g), .b(b), .sys_addr(AddrB));

bram ram (.InA(Dest), .InB(ZERO), .AddressA(AAddr), .AddressB(AddrB), .RWA(AWrEn), .RWB(ZERO), .clk1(clk), .clk2(vgaclk), .OutA(MemData), .OutB(OutB));

SimpleAddrFlagMux memaddrmux(.A1(Src), .A2(MemWrEn), .B1(PC), .B2(ZERO), .AB(RegAddrEn), .O1(AAddr), .O2(AWrEn));

KeyboardInputReader keyinreader(.sysClk(clk), .PS2clk(PS2Clk), .PS2data(PS2Data), .keysPressed(keysPressed));

bcd_to_seven_seg converter0 (.bcd(ScoreReg[3:0]), .seven_seg(SevenSeg1));
bcd_to_seven_seg converter1 (.bcd(ONE), .seven_seg(SevenSeg2));
bcd_to_seven_seg converter2 (.bcd(ScoreReg[7:4]), .seven_seg(SevenSeg3));
bcd_to_seven_seg converter3 (.bcd(TWO), .seven_seg(SevenSeg4));

endmodule 
