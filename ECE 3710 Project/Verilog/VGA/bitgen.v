/* Uses the bits retrieved from memory to output the corresponding rgb values on the screen */
module bitgen 
#(parameter DATA_WIDTH=2)
(
	input clk, bright, reset, hsync, vsync,
	input flag,
	input [15:0] data,
	input [2:0] celladdr,
	output reg [7:0] r, g, b
);

/* State machine states corresponding to each of the 8 2-bit values in each word in memory */
localparam PIX1 = 3'b000, PIX2 = 3'b001, PIX3 = 3'b010, PIX4 = 3'b011, PIX5 = 3'b100, PIX6 = 3'b101, PIX7 = 3'b110, PIX8 = 3'b111;
	
/* Used to hold each 2-bit value */
reg [1:0] pix1, pix2, pix3, pix4, pix5, pix6, pix7, pix8;

/* Used to delay the drawing of the pixel one clock cycle to ensure the correct values are being drawn */
reg [2:0] storedcelladdr;

always @(negedge clk) begin
	storedcelladdr = celladdr;
end

/* Main always block */
always @* begin
	/* Splits each word into its 8 2-bit values */
	pix1 = data[1:0];
	pix2 = data[3:2];
	pix3 = data[5:4];
	pix4 = data[7:6];
	pix5 = data[9:8];
	pix6 = data[11:10];
	pix7 = data[13:12];
	pix8 = data[15:14];

		/* If a pixel is able to be drawn */
		if (bright) begin
			/* Ensures the data retrieved is not data from the flag memory address */
			if (!flag) begin
				/* Draws each pixel from memory onto the screen */
				case(storedcelladdr)
					PIX1: begin
						/* Draw a grey pixel if the 2-bit value is 00 */
						if (pix1 == 2'b00) begin
							r = 8'd50;
							g = 8'd50;
							b = 8'd50;
						end
					
						/* Draw a red pixel if the 2-bit value is 01 */
						else if (pix1 == 2'b01) begin
							r = 8'd255;
							g = 8'd0;
							b = 8'd0;
						end
					
						/* Draw a green pixel if the 2-bit value is 10 */
						else if (pix1 == 2'b10) begin
							r = 8'd0;
							g = 8'd255;
							b = 8'd0;
						end
					
						/* Defaults to white (used for menus) */
						else begin
							r = 8'd255;
							g = 8'd255;
							b = 8'd255;
						end
					end
					PIX2: begin
						/* Draw a grey pixel if the 2-bit value is 00 */
						if (pix2 == 2'b00) begin
							r = 8'd50;
							g = 8'd50;
							b = 8'd50;
						end
					
						/* Draw a red pixel if the 2-bit value is 01 */
						else if (pix2 == 2'b01) begin
							r = 8'd255;
							g = 8'd0;
							b = 8'd0;
						end
					
						/* Draw a green pixel if the 2-bit value is 10 */
						else if (pix2 == 2'b10) begin
							r = 8'd0;
							g = 8'd255;
							b = 8'd0;
						end
						
						/* Defaults to white (used for menus) */
						else begin
							r = 8'd255;
							g = 8'd255;
							b = 8'd255;
						end
					end
					PIX3: begin
						/* Draw a grey pixel if the 2-bit value is 00 */
						if (pix3 == 2'b00) begin
							r = 8'd50;
							g = 8'd50;
							b = 8'd50;
						end
						
						/* Draw a red pixel if the 2-bit value is 01 */
						else if (pix3 == 2'b01) begin
							r = 8'd255;
							g = 8'd0;
							b = 8'd0;
						end
					
						/* Draw a green pixel if the 2-bit value is 10 */
						else if (pix3 == 2'b10) begin
							r = 8'd0;
							g = 8'd255;
							b = 8'd0;
						end
						
						/* Defaults to white (used for menus) */
						else begin
							r = 8'd255;
							g = 8'd255;
							b = 8'd255;
						end
					end
					PIX4: begin
						/* Draw a grey pixel if the 2-bit value is 00 */
						if (pix4 == 2'b00) begin
							r = 8'd50;
							g = 8'd50;
							b = 8'd50;
						end
					
						/* Draw a red pixel if the 2-bit value is 01 */
						else if (pix4 == 2'b01) begin
							r = 8'd255;
							g = 8'd0;
							b = 8'd0;
						end
					
						/* Draw a green pixel if the 2-bit value is 10 */
						else if (pix4 == 2'b10) begin
							r = 8'd0;
							g = 8'd255;
							b = 8'd0;
						end
					
						/* Defaults to white (used for menus) */
						else begin
							r = 8'd255;
							g = 8'd255;
							b = 8'd255;
						end
					end
					PIX5: begin
						/* Draw a grey pixel if the 2-bit value is 00 */
						if (pix5 == 2'b00) begin
							r = 8'd50;
							g = 8'd50;
							b = 8'd50;
						end
					
						/* Draw a red pixel if the 2-bit value is 01 */
						else if (pix5 == 2'b01) begin
							r = 8'd255;
							g = 8'd0;
							b = 8'd0;
						end
					
						/* Draw a green pixel if the 2-bit value is 10 */
						else if (pix5 == 2'b10) begin
							r = 8'd0;
							g = 8'd255;
							b = 8'd0;
						end
					
						/* Defaults to white (used for menus) */
						else begin
							r = 8'd255;
							g = 8'd255;
							b = 8'd255;
						end
					end
					PIX6: begin
						/* Draw a grey pixel if the 2-bit value is 00 */
						if (pix6 == 2'b00) begin
							r = 8'd50;
							g = 8'd50;
							b = 8'd50;
						end
					
						/* Draw a red pixel if the 2-bit value is 01 */
						else if (pix6 == 2'b01) begin
							r = 8'd255;
							g = 8'd0;
							b = 8'd0;
						end
					
						/* Draw a green pixel if the 2-bit value is 10 */
						else if (pix6 == 2'b10) begin
							r = 8'd0;
							g = 8'd255;
							b = 8'd0;
						end
					
						/* Defaults to white (used for menus) */
						else begin
							r = 8'd255;
							g = 8'd255;
							b = 8'd255;
						end
					end
					PIX7: begin
						/* Draw a grey pixel if the 2-bit value is 00 */
						if (pix7 == 2'b00) begin
							r = 8'd50;
							g = 8'd50;
							b = 8'd50;
						end
					
						/* Draw a red pixel if the 2-bit value is 01 */
						else if (pix7 == 2'b01) begin
							r = 8'd255;
							g = 8'd0;
							b = 8'd0;
						end
					
						/* Draw a green pixel if the 2-bit value is 10 */
						else if (pix7 == 2'b10) begin
							r = 8'd0;
							g = 8'd255;
							b = 8'd0;
						end
					
						/* Defaults to white (used for menus) */
						else begin
							r = 8'd255;
							g = 8'd255;
							b = 8'd255;
						end
					end
					PIX8: begin
						/* Draw a grey pixel if the 2-bit value is 00 */
						if (pix8 == 2'b00) begin
							r = 8'd50;
							g = 8'd50;
							b = 8'd50;
						end
					
						/* Draw a red pixel if the 2-bit value is 01 */
						else if (pix8 == 2'b01) begin
							r = 8'd255;
							g = 8'd0;
							b = 8'd0;
						end
					
						/* Draw a green pixel if the 2-bit value is 10 */
						else if (pix8 == 2'b10) begin
							r = 8'd0;
							g = 8'd255;
							b = 8'd0;
						end
					
						/* Defaults to white (used for menus) */
						else begin
							r = 8'd255;
							g = 8'd255;
							b = 8'd255;
						end
					end
				endcase
			end
			/* If the data is from the flag memory address, draw grey */
			else begin
				r = 8'd50;
				g = 8'd50;
				b = 8'd50;
			end
		end
		
		/* Nothing can be drawn.*/
		else begin
			r = 8'd50;
			g = 8'd50;
			b = 8'd50;
		end
end
endmodule