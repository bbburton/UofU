module tb_vga;

reg clk, resetn;
wire vga_clk, vga_blank_n, vga_vs, vga_hs;
wire [7:0] r, g, b;
wire [1:0] pixel;
wire [15:0] addr_b;
wire [15:0] q_b;
wire [3:0] counter;
wire [15:0] i;
glyph_vga uut(
	clk, resetn,
	vga_clk, vga_blank_n, vga_vs, vga_hs,
	r, g, b,
	pixel,
	addr_b,
	q_b,
	counter,
	i
);


initial begin
	$monitor("r = %8d, g = %8d, b = %8d, pixel = %2b, addr_b = %d, q_b = %16b, counter = %4b, i = %16b", r, g, b, pixel, addr_b, q_b, counter, i);
	
	clk = 0; #10;
	resetn = 1; #5;
	resetn = 0; #5;
	resetn = 1; #5;
	clk = 1; #5;
	clk = 0; #5;
		clk = 1; #5;
	clk = 0; #5;
		clk = 1; #5;
	clk = 0; #5;
		clk = 1; #5;
	clk = 0; #5;
		clk = 1; #5;
	clk = 0; #5;
		clk = 1; #5;
	clk = 0; #5;

	//clk = 0; #10;
	//resetn = 1; #2;
	//resetn = 0; #10;
	//resetn = 1; #10;
end

	always begin
		#5 clk = ~clk;
	end
/*always begin

#5 clk = ~clk;
end*/
endmodule
