module SimpleAddrFlagMux(A1, A2, B1, B2, AB, O1, O2);
input[15:0] A1, B1;
input A2, B2, AB;
output [15:0] O1;
output O2;
assign O1 = AB ? A1: B1;
assign O2 = AB ? A2: B2;
endmodule
