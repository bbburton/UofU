module bram(InA, InB, AddressA, AddressB, RWA, RWB, clk1, clk2, OutA, OutB);

	parameter AddressSize = 16;
	
	input [15:0] InA, InB, AddressA, AddressB;
	input RWA, RWB, clk1, clk2;
	
	output reg [15:0] OutA, OutB;

	(* ramstyle = "M10K" *) reg [15:0] ram[2**AddressSize-1:0];
	
	initial
	begin
			$readmemh("SoftwareMemory.hex", ram);
	end

	always @ (negedge clk1)
	begin
		if (RWA) 
		begin
			ram[AddressA] <= InA;
		end
		else 
		begin
			OutA <= ram[AddressA];
		end 
	end 

	always @ (negedge clk2)
	begin
		if (RWB) 
		begin
			ram[AddressB] <= InB;
		end
		else 
		begin
			OutB <= ram[AddressB];
		end 
	end 

endmodule
/*
C:\\Users\\brady\\Downloads\\output.txt
	always @ (negedge clk1)
	begin
		if (RWA) 
		begin
			ram[AddressA] <= InA;
		end
		else 
		begin
			OutA <= ram[AddressA];
		end 
	end 

	always @ (negedge clk1)
	begin
		if (RWB) 
		begin
			ram[AddressB] <= InB;
		end
		else 
		begin
			OutB <= ram[AddressB];
		end 
	end 

endmodule*/
























/** Supported Memory Block Configurations for Cyclone V Devices
  *
  * 397 M10K blocks available
  *
  * Each block can be configured as:
  *		Depth (bits)	| 	Programmable Width
  *			256			|		x40 or x32
  *			512			|		x20 or x16
  *			 1k			|		x10 or x8
  *			 2k			|		 x5 or x4
  *			 4k			|			 x2
  *			 8k			|			 x1
  *
  * Setting ADDR_WIDTH to 16, could move up to 512 if needed
  */
/*module bram
#(parameter DATA_WIDTH=16, parameter ADDR_WIDTH=16)
(
	input [(DATA_WIDTH-1):0] data_a, data_b,
	input [(ADDR_WIDTH-1):0] addr_a, addr_b,
	input we_a, we_b, clk,
	output reg [(DATA_WIDTH-1):0] q_a, q_b
);

	parameter AddressSize = 16;


	// Declare the RAM variable
	(* ramstyle = "M10K" *) reg [15:0] ram[2**AddressSize-1:0];
	
	initial
		begin
			$readmemb("C:\\Users\\brady\\Downloads\\test3.txt", ram);
		end

//always @(posedge clk)
	//q <= rom[addr];
	
	//initial
	//begin
		// Assuming data memory starts at 16'h1000
		//ram[16'h100] = 16'd100;	// mario x_pos
		//ram[16'h101] = 16'd350;	// mario y_pos
		//ram[16'h102] = 16'd0;		// mario movement position (21 positions)
	//end

	// Port A 
	always @ (negedge clk)
	begin
		if (we_a) 
		begin
			ram[addr_a] <= data_a;
			q_a <= data_a;
		end
		else 
		begin
			q_a <= ram[addr_a];
		end 
	end 

	// Port B 
	always @ (posedge clk)
	begin
		if (we_b) 
		begin
			ram[addr_b] <= data_b;
			q_b <= data_b;
		end
		else 
		begin
			q_b <= ram[addr_b];
		end 
	end

endmodule


*/

/*module bram
#(parameter DATA_WIDTH=16, parameter ADDR_WIDTH=16)
(InA, InB, AddressA, AddressB, RWA, RWB, clk1, clk2, OutA, OutB);

	parameter AddressSize = 16;
	
	input [15:0] InA, InB, AddressA, AddressB;
	input RWA, RWB, clk1, clk2;
	
	output reg [15:0] OutA, OutB;

	(* ramstyle = "M10K" *) reg [15:0] ram[2**AddressSize-1:0];
	
	initial
	//begin
		//	$readmemh("ProgramTester.txt", ram);
	//end

	always @ (posedge clk1)
	begin
		if (RWA) 
		begin
			ram[AddressA] <= InA;
		end
		else 
		begin
			OutA <= ram[AddressA];
		end 
	end 

	always @ (posedge clk2)
	begin
		if (RWB) 
		begin
			ram[AddressB] <= InB;
		end
		else 
		begin
			OutB <= ram[AddressB];
		end 
	end 

endmodule*/
