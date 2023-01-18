/* Generates the addresses to be retrieved from memory that hold the pixel information for
 * the three different screens */
module addr_gen
(
	input clk, reset, vsync,
	input [15:0] data,
	input bright,
	input [9:0] hcount, vcount,
	output reg [15:0] addr,
	output reg flag,
	output reg [2:0] celladdr
);

integer x_pos, y_pos;
	
/* Defaults the memory address offset to be the main game screen address */
integer OFFSET = 57344;

/* States for the state machine
 * FLAGS is used to pull from the flags memory address, which tells the VGA whether to draw
 * the menu screens or the game screen
 * DRAW is used to send the address to memory to retrieve the pixel information to be drawn to screen */
localparam FLAGS = 8'h00, DRAW = 8'h01;

reg [7:0] PS, NS;
wire lastFlag;
wire lastOffset;
wire lastAddr;
reg [15:0] calcaddr;
/* Resets to the FLAGS state if reset is hit, if the current column being drawn changes, or if we're not able to draw to screen */
always @(negedge clk) begin
	if (reset) begin
		PS <= FLAGS;
	end
	else if (!bright || !vsync) begin
		PS <= FLAGS;
	end
	else 
		PS <= DRAW;
end

/* Main always block, updates pixel being drawn when hcount or vcount changes */
always@(hcount, vcount, PS) begin
	/* Translates x and y position so that a 4x4 pixel square is assigned a color instead of
	 * one individual pixel */
	x_pos = (hcount - 10'd158) >> 2;
	y_pos = vcount >> 2;
	
	/* Calculates the address in the position matrix we need to pull data from */
	calcaddr = (y_pos * 160) + x_pos;
	celladdr = calcaddr[2:0];
	
	case(PS)
		/* Check the data in the flag memory address to determine which screen to draw */
		FLAGS: begin
			flag = 1;
			OFFSET = 0;
			addr = 45056;
		end
		
		/* Sends appropriate address to bram to retrieve pixel information */
		DRAW: begin
				/* If the current data is from the flag memory address, check the data to see which screen to draw and set flag to 0 */
				if (flag) begin
					/* 01 corresponds to Player 1 Win screen, 49152 is the address where the pixel information
					 * for that screen is stored */
					if (data[1:0] == 2'b01) begin
						OFFSET = 49152;
						flag = 0;
					end
					/* 10 corresponds to Player 2 Win screen, 53248 is the address where the pixel information
					 * for that screen is stored */
					else if (data[1:0] == 2'b10) begin
						OFFSET = 53248;
						flag = 0;
					end
					/* 00 corresponds to the main game screen, 57344 is the address where the pixel information
					 * for that screen is stored */
					else if (data[1:0] == 2'b00) begin
						OFFSET = 57344;
						flag = 0;
					end
				end
				else begin
					flag = 0;
					OFFSET = OFFSET;
				end
				addr = (calcaddr >> 3) + OFFSET;
		end
	endcase
end
endmodule