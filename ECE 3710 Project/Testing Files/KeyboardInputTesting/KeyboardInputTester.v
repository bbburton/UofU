`timescale 1ns / 1ps

module KeyboardInputTester(sysClk, clk, data, keysPressed);

input clk, data, sysClk;
output wire [8:0] keysPressed;
wire [7:0] prevKeycode;

KeyboardInputReader InputReader (.sysClk(sysClk), .PS2clk(clk), .PS2data(data), .keysPressed(keysPressed));

endmodule