module RegAluDatapath(clk, reset, DestCtrl, SrcCtrl, operation, immEn, immediate, flagsEn, AddressA, AddressB, RWA, RWB, AorB, AluOrMem, Flags, AluBus);

input clk, reset, immEn, flagsEn;
input [7:0] immediate;
input [3:0] DestCtrl, SrcCtrl, operation;
input [9:0] AddressA, AddressB;
input RWA, RWB, AorB, AluOrMem;
output [15:0] AluBus;
output [4:0] Flags;
wire [4:0] FlagsIn;
wire [15:0] r0, r1, r2, r3, r4, r5, r6, r7, r8 , r9 , r10, r11, r12, r13, r14, r15, Dest, Src, RegEns;
wire [3:0] Operation;
wire carry;
reg [15:0] OutA, OutB, RegIns;


reg [9:0] AddressA, AddressB

Decoder_4bit decoder (.ctrl(DestCtrl), .enbSignals(RegEns));
RegBank registers (.ALUBus(RegIns), .regEnable(RegEns), .clk(clk), .reset(reset), .r0(r0), .r1(r1), .r2(r2), .r3(r3), .r4(r4), .r5(r5), .r6(r6), .r7(r7), .r8(r8), .r9(r9), .r10(r10), .r11(r11), .r12(r12), .r13(r13), .r14(r14), .r15(r15));
Mux_4bit destMux (.r0(r0), .r1(r1), .r2(r2), .r3(r3), .r4(r4), .r5(r5), .r6(r6), .r7(r7), .r8(r8), .r9(r9), .r10(r10), .r11(r11), .r12(r12), .r13(r13), .r14(r14), .r15(r15), .ctrl(DestCtrl), .r(Dest));
Mux_4bit srcMux (.r0(r0), .r1(r1), .r2(r2), .r3(r3), .r4(r4), .r5(r5), .r6(r6), .r7(r7), .r8(r8), .r9(r9), .r10(r10), .r11(r11), .r12(r12), .r13(r13), .r14(r14), .r15(r15), .ctrl(SrcCtrl), .r(Src));
ALU alu (.Immediate(immediate), .Operation(operation), .Dest(Dest), .Src(Src), .CarryIn(carry), .ImmEn(immEn), .Out(AluBus), .FlagOuts(FlagsIn));
FlagsReg flagRegister (.D_in(FlagsIn), .wEnable(flagsEn), .reset(reset), .clk(clk), .flags(Flags), .carry(carry));
BRAM ram (.InA(Dest), .InB(Dest), .AddressA(AddressA), .AddressB(AddressB), .RWA(RWA), .RWB(RWB), .clk(clk), .OutA(OutA), .OutB(OutB));

always @(OutA, OutB, ALUBus, AorB, AluOrMem)
begin
	if (AluOrMem)
	begin
		Regins = AluBus;
	end
	else
	begin
		if (AorB)
		begin
			Regins = OutA;
		end
		else
		begin
			Regins = OutB;
		end
	end
end
endmodule
