/* Used to take information from memory and transform it, then display it on the screen */
module vga 
#(parameter SYS_DATA_WIDTH=16, SYS_ADDR_WIDTH=16,
				GLYPH_DATA_WIDTH=2, GLYPH_ADDR_WIDTH=8)
(
	input clk, reset,
	input [(SYS_DATA_WIDTH-1):0] sys_data,
	output vga_clk, vga_blank_n, vga_vs, vga_hs,
	output [7:0] r, g, b,
	output [(SYS_ADDR_WIDTH-1):0] sys_addr
);
	
localparam LOG2_DISPLAY_WIDTH  = 10;
localparam LOG2_DISPLAY_HEIGHT = 10;

/***************************************************************************/
/* 		NETS																					*/
/***************************************************************************/

// Determines the x and y position of the pixel currently being drawn
wire [(LOG2_DISPLAY_WIDTH-1):0]  hcount;
wire [(LOG2_DISPLAY_HEIGHT-1):0] vcount;

// Flags that says whether the current address being sent to bram is the flag address, used so that a pixel isn't 
// drawn to screen during this cycle
wire flag;
	
// The address to pull from memory, delayed one cycle to ensure the correct value is drawn
wire [2:0] celladdr;
	
/***************************************************************************/
/* 		VGA CONTROL																			*/
/***************************************************************************/

defparam ctrl.LOG2_DISPLAY_WIDTH = LOG2_DISPLAY_WIDTH;
defparam ctrl.LOG2_DISPLAY_HEIGHT = LOG2_DISPLAY_HEIGHT;

vga_control ctrl (
	clk, reset,			
	vga_hs, vga_vs,
	vga_blank_n, vga_clk,
	hcount,	
	vcount
);

/***************************************************************************/
/* 		BITGEN																				*/
/***************************************************************************/

bitgen bitgen (
	clk, vga_blank_n, reset, vga_hs, vga_vs, flag,
	sys_data,
	celladdr,
	r,g,b
);

/***************************************************************************/
/* 		ADDRESS GENERATOR																			*/
/***************************************************************************/

addr_gen address_generator (
	clk, reset, vga_vs, sys_data,
	vga_blank_n,
	hcount, vcount,
	sys_addr,
	flag,
	celladdr
);

endmodule