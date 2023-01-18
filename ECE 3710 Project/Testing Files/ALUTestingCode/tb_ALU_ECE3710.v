`timescale 1ns / 1ps
// tester for ADD,ADDI,ADDU,ADDUI,ADDC,ADDCU,ADDCUI,ADDCI,SUB,SUBI,CMP,CMPI,CMPU/I

module tb_ALU_ECE3710;

	// Inputs
	reg [15:0] Src;
	reg [15:0] Dest;
	reg [3:0] Opcode;
	reg [7:0] Immediate;
	reg Carry;
	reg ImmEn;
	
	// Outputs
	wire [15:0] Out;
	wire [4:0] Flags;

	integer i;
	// Instantiate the Unit Under Test (UUT)	
	ALU uut (
		.Immediate(Immediate), 
		.Operation(Opcode), 
		.Dest(Dest),
		.Src(Src),
	   .CarryIn(Carry),
		.ImmEn(ImmEn),
		.Out(Out), 
		.FlagOuts(Flags)
	);

	initial begin
$monitor("Dest: %0d, Src: %0d, Immediate: %0d, Carry: %0d, Out: %0d, Flags[1:0]: %b, time:%0d", Dest, Src, Immediate, Carry, Out, Flags[4:0], $time);
//Instead of the $display stmt in the loop, you could use just this
//monitor statement which is executed everytime there is an event on any
//signal in the argument list.


//////////////////////////////////////
////				Add					 ////
//////////////////////////////////////


		// Initialize inputs for Add test
		$display("Add tests:");
		Src = 0;
		Dest = 0;
		Opcode = 4'b0101;
		Immediate = 8'b00010000;
		Carry = 0;

		// Wait 100 ns for global reset to finish

		// One vector-by-vector case simulation should cause overflow two positive numbers added results in a negative number
		#10000;
		Dest = 16'b0111111111111111; Src = 16'b0001000000000011;ImmEn = 0;
		#10;
		// Negative plus a positive number also ensures last 4 bits don't effect result nor does the carry
		Dest = 16'b1111111111111001; Src = 16'b0000111111111101; Immediate = Immediate | 8'b00000101; Carry = 1;ImmEn = 0;
		#10;
		
		// Case chould cause negative overflow
		Dest = 16'b1001111111111001; Src = 16'b1000111111111101; ImmEn = 0;
		#10;
		
		
		//Random simulation
		for( i = 0; i< 10; i = i+ 1)
		begin
			#10
			Dest = $random % 65536;
			Src = $random % 65536;
		end

//////////////////////////////////////
////				AddU					 ////
//////////////////////////////////////

		
		// Initialize inputs for Addu test
		$display("\n\nAddu tests:");
		Src = 0;
		Dest = 0;
		Opcode = 4'b0110;
		Immediate = 8'b01100000;
		Carry = 0;

		// Wait 100 ns for global reset to finish

		// One vector-by-vector case simulation no carry should be produced
		#10;
		Dest = 16'b0111111111111111; Src = 16'b0001000000000011;ImmEn = 0;
		#10;
		
		// Should cause a carry to be produced and overflow to occur
		Dest = 16'b1111111111111001; Src = 16'b1000111111111101; ImmEn = 0;
		#10;
		
		// Case that ensures last 4 bits of immediate and Carry have no effect on the result.
		Dest = 16'b1111111111111001; Src = 16'b1000111111111101; Immediate = Immediate | 8'b00000101; Carry = 1;ImmEn = 0;
		#10;
		
		
		//Random simulation
		for( i = 0; i< 10; i = i+ 1)
		begin
			#10
			Dest = $random % 65536;
			Src = $random % 65536;
		end
		
//////////////////////////////////////
////				AddC					 ////
//////////////////////////////////////


		
		// Initialize inputs for AddC test
		$display("\n\nAddC tests:");
		Src = 0;
		Dest = 0;
		Opcode = 4'b0111;
		Immediate = 8'b01110000;
		Carry = 0;

		// Wait 100 ns for global reset to finish

		// One vector-by-vector case simulation that should cause overflow
		#10;
		Dest = 16'b0111111111111111; Src = 16'b0000000000000000; Carry = 1;ImmEn = 0;
		#10;
		
		// Should cause overflow to occur
		Dest = 16'b1100000000000000; Src = 16'b1011111111111111; Carry = 0; ImmEn = 0;
		#10;
		
		// Should cause no overflow to occur
		Dest = 16'b1100000000000000; Src = 16'b1011111111111111; Carry = 1; ImmEn = 0;
		#10;
		
		// Case that ensures last 4 bits of immediate have no impact on the result
		Dest = 16'b0000000000000001; Src = 16'b0000111111111101; Immediate = Immediate | 8'b00000101; Carry = 1;ImmEn = 0;
		#10;
		
		
		//Random simulation
		for( i = 0; i< 10; i = i+ 1)
		begin
			#10
			Dest = $random % 65536;
			Src = $random % 65536;
			Carry = $random % 2;
		end
		
//////////////////////////////////////
////				AddCU					 ////
//////////////////////////////////////


		// Initialize inputs for AddCU tests has same condition code as addC since to the ALU it is the same
		$display("\n\nAddCU tests:");
		Src = 0;
		Dest = 0;
		Opcode = 4'b0111;
		Immediate = 8'b01110000;
		Carry = 0;

		// Wait 100 ns for global reset to finish

		// One vector-by-vector case simulation that shouldn't cause overflow
		#10;
		Dest = 16'b0111111111111111; Src = 16'b0111111111111111; Carry = 1;ImmEn = 0;
		#10;
		
		// Shouldn't cause overflow to occur
		Dest = 16'b1000000000000000; Src = 16'b0111111111111111; Carry = 0; ImmEn = 0;
		#10;
		
		// Should cause overflow to occur
		Dest = 16'b1000000000000000; Src = 16'b0111111111111111; Carry = 1; ImmEn = 0;
		#10;
		
		// Case that ensures last 4 bits of immediate have no impact on the result
		Dest = 16'b0000000000000001; Src = 16'b0000111111111101; Immediate = Immediate | 8'b00000101; Carry = 1;ImmEn = 0;
		#10;
		
		
		//Random simulation
		for( i = 0; i< 10; i = i+ 1)
		begin
			#10
			Dest = $random % 65536;
			Src = $random % 65536;
			Carry = $random % 2;
		end
		
//////////////////////////////////////
////				Sub					 ////
//////////////////////////////////////

		
		// Initialize inputs for Sub tests has same condition code as addC since to the ALU it is the same
		$display("\n\nSub tests:");
		Src = 0;
		Dest = 0;
		Opcode = 4'b1001;
		Immediate = 8'b10010000;
		Carry = 0;

		// Wait 100 ns for global reset to finish

		// case that shouldn't cause overflow positive minus negative
		#10;
		Dest = 16'b0111111111111110; Src = 16'b111111111111111;ImmEn = 0;
		#10;
		
		// Should cause overflow to occur Positive minus negative
		Dest = 16'b0111111111111110; Src = 16'b101111111001111;ImmEn = 0;
		#10;
		
		// Should result in a negative number positive minus positive
		Dest = 16'b0000111111111110; Src = 16'b001111111001111;ImmEn = 0;
		#10;
		
		// Should result in a positive number negative minus negative.
		Dest = 16'b1000111111111110; Src = 16'b100000000001111;ImmEn = 0;
		#10;
		
		// Shouldn't cause overflow to occur negative minus positive
		Dest = 16'b1001111111111111; Src = 16'b000000000000111; ImmEn = 0;
		#10;
		
		// Should cause overflow to occur negative minus positive
		Dest = 16'b1001111111111100; Src = 16'b010000000000111; ImmEn = 0;
		#10;
		
		// Case that ensures last 4 bits of immediate and Carry have no impact on the result
		Dest = 16'b1001111111111100; Src = 16'b010000000000111; Immediate = Immediate | 8'b00000101; Carry = 1;ImmEn = 0;
		#10;
		
		//Random simulation
		for( i = 0; i< 10; i = i+ 1)
		begin
			#10
			Dest = $random % 65536;
			Src = $random % 65536;
		end
		
//////////////////////////////////////
////				Cmp					 ////
//////////////////////////////////////

		
		// Initialize inputs for Cmp tests has same condition code as addC since to the ALU it is the same
		$display("\n\nCmp tests:");
		Src = 0;
		Dest = 0;
		Opcode = 4'b1011;
		Immediate = 8'b10110000;
		Carry = 0;

		// Wait 100 ns for global reset to finish

		// Case in which Dest > Src. Pos > Neg
		#10;
		Dest = 16'b011111111111110; Src = 16'b11111111111111;ImmEn = 0;
		#10;
		
		// Case in which Dest < Src. Neg < Pos
		Dest = 16'b110000111110000; Src = 16'b011111111001111;ImmEn = 0;
		#10;
		
		// Case in which Dest = Src. Positive Numbers
		Dest = 16'b001111111001111; Src = 16'b001111111001111;ImmEn = 0;
		#10;
		
		// Case in which Dest = Src. Negative Numbers
		Dest = 16'b100100010111010; Src = 16'b100100010111010;ImmEn = 0;
		#10;
		
		// Case in which Dest > Src. Positive Numbers
		Dest = 16'b000100111110011; Src = 16'b000000000000111; ImmEn = 0;
		#10;
		
		// Case in which Dest < Src. Positive Numbers
		Dest = 16'b000100111110011; Src = 16'b011000000000111; ImmEn = 0;
		#10;
		
		// Case in which Dest > Src. Negative Numbers
		Dest = 16'b110100111110011; Src = 16'b110000000000111; ImmEn = 0;
		#10;
		
		// Case in which Dest < Src. Negative Numbers
		Dest = 16'b110100111110011; Src = 16'b111000000000111; ImmEn = 0;
		#10;
		
		// Case that ensures last 4 bits of immediate and Carry have no impact on the result
		Dest = 16'b110100111110011; Src = 16'b111000000000111; Immediate = Immediate | 8'b00000101; Carry = 1;ImmEn = 0;
		#10;
		
		//Random simulation
		for( i = 0; i< 10; i = i+ 1)
		begin
			#10
			Dest = $random % 65536;
			Src = $random % 65536;
			Carry = $random % 2;
		end
		
//////////////////////////////////////
////				Cmpu					 ////
//////////////////////////////////////

		
		// Initialize inputs for Cmp tests has same condition code as addC since to the ALU it is the same (this may not be correct).
		$display("\n\nCmpu tests:");
		Src = 0;
		Dest = 0;
		Opcode = 4'b1011;
		Immediate = 8'b10110000;
		Carry = 0;

		// Wait 100 ns for global reset to finish

		// Case in which Dest < Src. 
		#10;
		Dest = 16'b011111111111110; Src = 16'b11111111111111;ImmEn = 0;
		#10;
		
		// Case in which Dest > Src.
		Dest = 16'b110000111110000; Src = 16'b011111111001111;ImmEn = 0;
		#10;
		
		// Case in which Dest = Src.
		Dest = 16'b001111111001111; Src = 16'b001111111001111;ImmEn = 0;
		#10;
			
		// Case in which Dest > Src.
		Dest = 16'b000100111110011; Src = 16'b000000000000111; ImmEn = 0;
		#10;
		
		// Case in which Dest < Src.
		Dest = 16'b000100111110011; Src = 16'b011000000000111; ImmEn = 0;
		#10;
		
		// Case in which Dest > Src.
		Dest = 16'b110100111110011; Src = 16'b110000000000111; ImmEn = 0;
		#10;
		
		// Case in which Dest < Src.
		Dest = 16'b110100111110011; Src = 16'b111000000000111; ImmEn = 0;
		#10;
		
		// Case that ensures last 4 bits of immediate and Carry have no impact on the result
		Dest = 16'b110100111110011; Src = 16'b111000000000111; Immediate = Immediate | 8'b00000101; Carry = 1; ImmEn = 0;
		#10;
		
		//Random simulation
		for( i = 0; i< 10; i = i+ 1)
		begin
			#10
			Dest = $random % 65536;
			Src = $random % 65536;
			Carry = $random % 2;
		end		
		
//////////////////////////////////////
////				Addi					 ////
//////////////////////////////////////

		
		// Initialize inputs for Addi test
		$display("\n\nAddi Tests:");
		Src = 0;
		Dest = 0;
		Opcode = 4'b0101;
		Immediate = 8'b00000000;
		Carry = 0;

		// Wait 100 ns for global reset to finish

		// One vector-by-vector case simulation should cause overflow 
		#10;
		Dest = 16'b0111111111111111; Immediate = 8'b01110011;ImmEn = 1;
		
		#10;
		// Case that shouldn't cause overflow two negatives
		Dest = 16'b1111111111111001; Immediate = 8'b11111101;ImmEn = 1;
		#10;
		
		// Case that Ensures Src and Carry don't affect result
		Dest = 16'b1111111111111001; Immediate = 8'b11111101; Src = 16'b1000111111111101; Carry = 1;ImmEn = 1;
		#10;
		
		// Case that should cause overflow with two negatives
		Dest = 16'b1001111111111001; Immediate = 8'b10000011;ImmEn = 1;
		#10;
		
		//Random simulation
		for( i = 0; i< 10; i = i+ 1)
		begin
			#10
			Dest = $random % 65536;
			Immediate = $random % 256;
		end
				
//////////////////////////////////////
////				AddUi					 ////
//////////////////////////////////////

				
		// Initialize inputs for Addui test
		$display("\n\nAddui Tests:");
		Src = 0;
		Dest = 0;
		Opcode = 4'b0110;
		Immediate = 8'b00000000;
		Carry = 0;

		// Wait 100 ns for global reset to finish

		// One vector-by-vector case simulation shouldn't cause overflow 
		#10;
		Dest = 16'b0111111111111111; Immediate = 8'b01110011;ImmEn = 1;
		
		#10;
		// Case that should cause overflow two negatives
		Dest = 16'b1111111111111001; Immediate = 8'b10000001;ImmEn = 1;
		#10;
		
		// Case that Ensures Src and Carry don't affect result
		Dest = 16'b0000000000000001; Immediate = 8'b00000001; Src = 16'b1000111111111101; Carry = 1;ImmEn = 1;
		#10;
		
		//Random simulation
		for( i = 0; i< 10; i = i+ 1)
		begin
			#10
			Dest = $random % 65536;
			Immediate = $random % 256;
		end

//////////////////////////////////////
////				AddCi					 ////
//////////////////////////////////////

		
		// Initialize inputs for AddCi test
		$display("\n\nAddCi Tests:");
		Src = 0;
		Dest = 0;
		Opcode = 4'b0111;
		Immediate = 8'b00000000;
		Carry = 0;

		// Wait 100 ns for global reset to finish

		// One vector-by-vector case simulation should cause overflow 
		#10;
		Dest = 16'b0111111111111100; Immediate = 8'b00000011; Carry = 1;ImmEn = 1;
		
		#10;
		// Case that shouldn't cause overflow two negatives
		Dest = 16'b0111111111111100; Immediate = 8'b00000011; Carry = 0;ImmEn = 1;
		#10;
		
		// Case that Ensures Src doesn't affect result
		Dest = 16'b0000000000000001; Immediate = 8'b00000001; Src = 16'b1000111111111101; Carry = 1;ImmEn = 1;
		#10;
		
		// Case that causes negative overflow
		Dest = 16'b1000000000001111; Immediate = 8'b11110000; Carry = 0;ImmEn = 1;
		
		// Case that doesn't causes negative overflow
		Dest = 16'b1000000000001111; Immediate = 8'b11110000; Carry = 1;ImmEn = 1;
		
		//Random simulation
		for( i = 0; i< 10; i = i+ 1)
		begin
			#10
			Dest = $random % 65536;
			Immediate = $random % 256;
			Carry = $random % 2;
		end
		
//////////////////////////////////////
////				AddCUI				 ////
//////////////////////////////////////

		
		// Initialize inputs for AddCUi test same opcode as AddCi since to the ALU they are the same
		$display("\n\nAddCUi Tests:");
		Src = 0;
		Dest = 0;
		Opcode = 4'b0111;
		Immediate = 8'b00000000;
		Carry = 0;

		// Wait 100 ns for global reset to finish

		// One vector-by-vector case simulation should cause overflow 
		#10;
		Dest = 16'b1111111111111100; Immediate = 8'b00000011; Carry = 1;	ImmEn = 1;
		#10;

		// case simulation shouldn't cause overflow 
		Dest = 16'b1111111111111100; Immediate = 8'b00000011; Carry = 0;	ImmEn = 1;
		#10;
		
		// Case that Ensures Src doesn't affect result
		Dest = 16'b0000000000000001; Immediate = 8'b00000001; Src = 16'b1000111111111101; Carry = 1;ImmEn = 1;
		#10;
		
		//Random simulation
		for( i = 0; i< 10; i = i+ 1)
		begin
			#10
			Dest = $random % 65536;
			Immediate = $random % 256;
			Carry = $random % 2;
		end
		
//////////////////////////////////////
////				Subi					 ////
//////////////////////////////////////

		
		// Initialize inputs for Subi tests same opcode as AddCi since to the ALU they are the same
		$display("\n\nSubi Tests:");
		Src = 0;
		Dest = 0;
		Opcode = 4'b1001;
		Immediate = 8'b00000000;
		Carry = 0;

		// Wait 100 ns for global reset to finish

		// One vector-by-vector case simulation that should cause overflow positive minus negative
		#10;
		Dest = 16'b1111111111111100; Immediate = 8'b10000011; ImmEn = 1;	
		#10;
		
		// One vector-by-vector case simulation that shouldn't cause overflow positive minus negative
		Dest = 16'b1000011111111100; Immediate = 8'b10000001; ImmEn = 1;	
		#10;

		// case simulation that should cause overflow negative minus positive
		Dest = 16'b1000000000000110; Immediate = 8'b01000011;ImmEn = 1;
		#10;
		
		// case simulation that shouldn't cause overflow negative minus positive
		Dest = 16'b1100000000000110; Immediate = 8'b01000011;ImmEn = 1;
		#10;
		
		// Case where postive minus positive results in a negative
		Dest = 16'b0000000000000110; Immediate = 8'b01000011;ImmEn = 1;
		#10;
		
		// Case where negative minus negative results in a positive
		Dest = 16'b1111111111110110; Immediate = 8'b10000011;ImmEn = 1;
		#10;
		
		// Case that Ensures Src and Carry doesn't affect result
		Dest = 16'b1111111111110110; Immediate = 8'b10000011; Src = 16'b1000111111111101; Carry = 1; ImmEn = 1;
		#10;
		
		//Random simulation
		for( i = 0; i< 10; i = i+ 1)
		begin
			#10
			Dest = $random % 65536;
			Immediate = $random % 256;
		end
		
//////////////////////////////////////
////				Cmpi					 ////
//////////////////////////////////////

		
		// Initialize inputs for Cmpi tests same opcode as AddCi since to the ALU they are the same
		$display("\n\nCmpi Tests:");
		Src = 0;
		Dest = 0;
		Opcode = 4'b1011;
		Immediate = 8'b00000000;
		Carry = 0;

		// Wait 100 ns for global reset to finish

		// Dest > Src. Pos > Neg
		#10;
		Dest = 16'b0111111111111100; Immediate = 8'b10000011; ImmEn = 1;	
		#10;
		
		// Dest < Src. Neg < Pos
		Dest = 16'b1110001111111100; Immediate = 8'b00000011; ImmEn = 1;	
		#10;

		// Dest = Src. Negatives
		Dest = 16'b1111111111000110; Immediate = 8'b11000110;ImmEn = 1;
		#10;
		
		// Dest = Src. Positives
		Dest = 16'b0000000001000110; Immediate = 8'b01000110;ImmEn = 1;
		#10;
		
		// Dest > Src. Positives
		Dest = 16'b0010000001000110; Immediate = 8'b01110110;ImmEn = 1;
		#10;
		
		// Dest < Src. Positives
		Dest = 16'b0000000001000110; Immediate = 8'b01100110;ImmEn = 1;
		#10;
		
		// Dest > Src. Negatives
		Dest = 16'b1111111111001111; Immediate = 8'b10000110;ImmEn = 1;
		#10;
		
		// Dest < Src. Negatives
		Dest = 16'b1011111111000110; Immediate = 8'b10000110;ImmEn = 1;
		#10;
		
		// Case that Ensures Src and Carry doesn't affect result
		Dest = 16'b1011111111000110; Immediate = 8'b10000110; Src = 16'b1000111111111101; Carry = 1; ImmEn = 1;
		#10;
		
		//Random simulation
		for( i = 0; i< 10; i = i+ 1)
		begin
			#10
			Dest = $random % 65536;
			Immediate = $random % 256;
		end
		
		
//////////////////////////////////////
////				Cmpui					 ////
//////////////////////////////////////

		
		// Initialize inputs for Cmpi tests same opcode as AddCi since to the ALU they are the same
		$display("\n\nCmpui Tests:");
		Src = 0;
		Dest = 0;
		Opcode = 4'b1011;
		Immediate = 8'b00000000;
		Carry = 0;

		// Wait 100 ns for global reset to finish

		// Dest > Src.
		#10;
		Dest = 16'b0100000000011100; Immediate = 8'b10000011; ImmEn = 1;
		#10;
		
		// Dest < Src. 
		Dest = 16'b0000000000111100; Immediate = 8'b10000011; ImmEn = 1;
		#10;

		// Dest = Src. 
		Dest = 16'b0000000011000110; Immediate = 8'b11000110;ImmEn = 1;
		#10;
		
		// Dest = Src. 
		Dest = 16'b0000000001000110; Immediate = 8'b01000110;ImmEn = 1;
		#10;
		
		// Dest > Src. 
		Dest = 16'b0010000001000110; Immediate = 8'b01110110;ImmEn = 1;
		#10;
		
		// Dest < Src. 
		Dest = 16'b0000000001000110; Immediate = 8'b01100110;ImmEn = 1;
		#10;
		
		// Dest > Src. 
		Dest = 16'b1111111111001111; Immediate = 8'b10000110;ImmEn = 1;
		#10;
		
		// Dest < Src. 
		Dest = 16'b000000000000110; Immediate = 8'b10000110;ImmEn = 1;
		#10;
		
		// Case that Ensures Src and Carry doesn't affect result
		Dest = 16'b000000000000110; Immediate = 8'b10000110; Src = 16'b1000111111111101; Carry = 1; ImmEn = 1;
		#10;
		
		//Random simulation
		for( i = 0; i< 10; i = i+ 1)
		begin
			#10
			Dest = $random % 65536;
			Immediate = $random % 256;
		end
		
//////////////////////////////////////
////				AND					 ////
//////////////////////////////////////
		
		// Initialize inputs for AND tests 
		$display("\n\nAND Tests:");
		Src = 0;
		Dest = 0;
		Opcode = 4'b0001;
		Immediate = 8'b00000000;
		Carry = 0;
		
		// Wait 100 ns for global reset to finish

		// case simulation should cause output to be all 0 
		#10;
		Dest = 16'b1111111111111100; Src = 16'b0000000000000000;	ImmEn = 0;
		#10;

		// case simulation should cause output to be all 1 
		Dest = 16'b1111111111111111; Src = 16'b1111111111111111; ImmEn = 0;	
		#10;
		
		// Case that Ensures immediate doesn't affect result
		Dest = 16'b0000000000000001; Src = 16'b0000000000000001; Immediate = 8'b00000001; ImmEn = 0;
		#10;
		
		// Case that Ensures Carry doesn't affect result
		Dest = 16'b0000000000000001; Src = 16'b0000000000000001; Carry = 1; ImmEn = 0;
		#10;
		
		//Random simulation
		for( i = 0; i< 10; i = i+ 1)
		begin
			#10
			Dest = $random % 65536;
			Src = $random % 65536;
		end
		
//////////////////////////////////////
////					OR					 ////
//////////////////////////////////////
		
		// Initialize inputs for OR tests 
		$display("\n\nOR Tests:");
		Src = 0;
		Dest = 0;
		Opcode = 4'b0010;
		Immediate = 8'b00000000;
		Carry = 0;
		
		// Wait 100 ns for global reset to finish

		// case simulation should cause output to be all 0 
		#10;
		Dest = 16'b0000000000000000; Src = 16'b0000000000000000;	ImmEn = 0;
		#10;

		// case simulation should cause output to be all 1 
		Dest = 16'b1010101010101010; Src = 16'b0101010101010101; ImmEn = 0;
		#10;
		
		// Case that Ensures immediate doesn't affect result
		Dest = 16'b0000000000010001; Src = 16'b1000000000000001; Immediate = 8'b00000001;ImmEn = 0;
		#10;
		
		// Case that Ensures Carry doesn't affect result
		Dest = 16'b0000000000000001; Src = 16'b0000000000000001; Carry = 1; ImmEn = 0;
		#10;
		
		//Random simulation
		for( i = 0; i< 10; i = i+ 1)
		begin
			#10
			Dest = $random % 65536;
			Src = $random % 65536;
		end
		
//////////////////////////////////////
////				XOR					 ////
//////////////////////////////////////
		
		// Initialize inputs for XOR tests 
		$display("\n\nXOR Tests:");
		Src = 0;
		Dest = 0;
		Opcode = 4'b0011;
		Immediate = 8'b00000000;
		Carry = 0;
		
		// Wait 100 ns for global reset to finish

		// case simulation should cause output to be all 0 
		#10;
		Dest = 16'b0101010101010101; Src = 16'b0101010101010101;	ImmEn = 0;
		#10;

		// case simulation should cause output to be all 1 
		Dest = 16'b0101010101010101; Src = 16'b1010101010101010; ImmEn = 0;
		#10;
		
		// Case that Ensures immediate doesn't affect result
		Dest = 16'b0000000000000001; Src = 16'b0000000000000010; Immediate = 8'b00000001; ImmEn = 0;
		#10;
		
		// Case that Ensures Carry doesn't affect result
		Dest = 16'b0000000000000001; Src = 16'b0000000000000010; Carry = 1; ImmEn = 0;
		#10;
		
		//Random simulation
		for( i = 0; i< 10; i = i+ 1)
		begin
			#10
			Dest = $random % 65536;
			Src = $random % 65536;
		end
		
//////////////////////////////////////
////				NOT					 ////
//////////////////////////////////////
		
		// Initialize inputs for NOT tests 
		$display("\n\nNOT Tests:");
		Src = 0;
		Dest = 0;
		
		Opcode = 4'b1111;
		Immediate = 8'b00000000;
		Carry = 0;
		
		// Wait 100 ns for global reset to finish

		// case simulation should cause output to be all 0 
		#10;
		Dest = 16'b1111111111111111; ImmEn = 0;
		#10;

		// case simulation should cause output to be all 1 
		#10
		Dest = 16'b0000000000000000; 	ImmEn = 0;
		#10;
		
		// Case that Ensures immediate doesn't affect result
		Dest = 16'b0000000000000001; Immediate = 8'b00000001; ImmEn = 0;
		#10;
		
		// Case that Ensures Carry doesn't affect result
		Dest = 16'b0000000001000000; Carry = 1; ImmEn = 0;
		#10;
		
		//Random simulation
		for( i = 0; i< 10; i = i+ 1)
		begin
			#10
			Dest = $random % 65536;
		end
		
//////////////////////////////////////
////				LSH					 ////
//////////////////////////////////////
		
		// Initialize inputs for LSH tests 
		$display("\n\nLSH Tests:");
		Src = 0;
		Dest = 0;
		Opcode = 4'b1000;
		Immediate = 8'b01000001;
		Carry = 0;
		
		// Wait 100 ns for global reset to finish

		// ALU only supports 1 bit shifts so don't need to worry about immediate
		
		// case simulation should cause output to be all 0 
		#10;
		Dest = 16'b1000000000000000; Src = 16'b0000000000000001; Immediate = 8'b01000001; ImmEn = 0;
		#10;

		// case simulation should cause output to be 2 
		Dest = 16'b0000000000000001; Src = 16'b0000000000000001; Immediate = 8'b01000001; ImmEn = 0;
		#10;
		
		// Case that Ensures Carry doesn't affect result
		Dest = 16'b0000000000000001; Src = 16'b0000000000000001; Immediate = 8'b01000001; Carry = 1; ImmEn = 0;
		#10;
		
		//Random simulation
		for( i = 0; i< 10; i = i+ 1)
		begin
			#10
			Dest = $random % 65536;
			Src = 16'b0000000000000001;
			Immediate = 8'b01000001;
		end
		
//////////////////////////////////////
////				LSHI					 ////
//////////////////////////////////////
		
		// Initialize inputs for LSHI tests 
		$display("\n\nLSHI Tests:");
		Src = 0;
		Dest = 0;
		Opcode = 4'b1000;
		Immediate = 8'b00000000;
		Carry = 0;
		
		// Wait 100 ns for global reset to finish

		// Immediate value of -1 signals a 1-bit right shift, tests for right shift below
		
		// case simulation should cause output to be all 0 
		#10;
		Dest = 16'b1000000000000000; Immediate = 8'b00000001; ImmEn = 1;
		#10;

		// case simulation should cause output to be 2 
		Dest = 16'b0000000000000001; Immediate = 8'b00000001; ImmEn = 1;
		#10;
		
		// Case that Ensures Carry doesn't affect result
		Dest = 16'b0000000000000001; Immediate = 8'b00000001; Carry = 1; ImmEn = 1;
		#10;
		
		//Random simulation
		for( i = 0; i< 10; i = i+ 1)
		begin
			#10
			Dest = $random % 65536;
			Immediate = 8'b00000001;
		end
		
//////////////////////////////////////
////				RSH					 ////
//////////////////////////////////////
		
		// Initialize inputs for RSH tests 
		$display("\n\nRSH Tests:");
		Src = 0;
		Dest = 0;
		Opcode = 4'b1000;
		Immediate = 8'b01010001;
		Carry = 0;
		
		// Wait 100 ns for global reset to finish
	
		// case simulation should cause output to be all 0 
		#10;
		Dest = 16'b0000000000000001; Src = 16'b0000000000000001; Immediate = 8'b01010001; ImmEn = 0;
		#10;

		// case simulation should cause output to be 1 
		Dest = 16'b0000000000000010; Src = 16'b0000000000000001; Immediate = 8'b01010001; ImmEn = 0;
		#10;
		
		// Case that Ensures Carry doesn't affect result
		Dest = 16'b0000000000001000; Src = 16'b0000000000000001; Immediate = 8'b01010001; Carry = 1; ImmEn = 0;
		#10;
		
		//Random simulation
		for( i = 0; i< 10; i = i+ 1)
		begin
			#10
			Dest = $random % 65536;
			Src = 16'b0000000000000001;
			Immediate = 8'b01010001;
		end
		
//////////////////////////////////////
////				RSHI					 ////
//////////////////////////////////////
		
		// Initialize inputs for RSHI tests 
		$display("\n\nRSHI Tests:");
		Src = 0;
		Dest = 0;
		Opcode = 4'b1000;
		Immediate = 8'b00010001;
		Carry = 0;
		
		// Wait 100 ns for global reset to finish
	
		// case simulation should cause output to be all 0 
		#10;
		Dest = 16'b0000000000000001; Immediate = 8'b00010001; ImmEn = 1;
		#10;

		// case simulation should cause output to be 1 
		Dest = 16'b0000000000000010; Immediate = 8'b00010001; ImmEn = 1; 	
		#10;
		
		// Case that Ensures Carry doesn't affect result
		Dest = 16'b0000000000001000; Immediate = 8'b00010001; Carry = 1; ImmEn = 1;
		#10;
		
		//Random simulation
		for( i = 0; i< 10; i = i+ 1)
		begin
			#10
			Dest = $random % 65536;
			Immediate = 8'b00010001;
		end
		
//////////////////////////////////////
////				ALSH					 ////
//////////////////////////////////////
		
		// Initialize inputs for ALSH tests 
		$display("\n\nALSH Tests:");
		Src = 0;
		Dest = 0;
		Opcode = 4'b1000;
		Immediate = 8'b01100001;
		Carry = 0;
		
		// Wait 100 ns for global reset to finish
	
		// case simulation should cause output to be all 0 
		#10;
		Dest = 16'b1000000000000000; Src = 16'b0000000000000001; Immediate = 8'b01100001; ImmEn = 0;
		#10;

		// case simulation should cause output to be 2 
		Dest = 16'b0000000000000001; Src = 16'b0000000000000001; Immediate = 8'b01100001; ImmEn = 0;
		#10;
		
		// Case that Ensures Carry doesn't affect result
		Dest = 16'b0000000000001000; Src = 16'b0000000000000001; Immediate = 8'b01100001; Carry = 1; ImmEn = 0;
		#10;
		
		//Random simulation
		for( i = 0; i< 10; i = i+ 1)
		begin
			#10
			Dest = $random % 65536;
			Src = 16'b0000000000000001;
			Immediate = 8'b01100001;
		end
		
//////////////////////////////////////
////				ARSH					 ////
//////////////////////////////////////
		
		// Initialize inputs for ARSH tests 
		$display("\n\nARSH Tests:");
		Src = 0;
		Dest = 0;
		Opcode = 4'b1000;
		Immediate = 8'b01110001;
		Carry = 0;
		
		// Wait 100 ns for global reset to finish
		
		// arithmetic shift ensures sign bit stays the same,
		// so right arithmetic shift needs sign extension
	
		// case simulation should cause output to still be a large negative number 
		#10;
		Dest = 16'b1000000000000001; Src = 16'b0000000000000001; Immediate = 8'b01110001; ImmEn = 0;
		#10;

		// case simulation should cause output to be 1 
		Dest = 16'b0000000000000010; Src = 16'b0000000000000001; Immediate = 8'b01110001; ImmEn = 0;
		#10;
		
		// Case that Ensures Carry doesn't affect result
		Dest = 16'b0000000000001000; Src = 16'b0000000000000001; Immediate = 8'b01110001; Carry = 1; ImmEn = 0;
		#10;
		
		//Random simulation
		for( i = 0; i< 10; i = i+ 1)
		begin
			#10
			Dest = $random % 65536;
			Src = 16'b0000000000000001;
			Immediate = 8'b01110001;
		end
		
//////////////////////////////////////
////				ALSHI					 ////
//////////////////////////////////////
		
		// Initialize inputs for ALSHI tests 
		$display("\n\nALSHI Tests:");
		Src = 0;
		Dest = 0;
		Opcode = 4'b1000;
		Immediate = 8'b00100001;
		Carry = 0;
		
		// Wait 100 ns for global reset to finish
	
		// case simulation should cause output to be all 0 
		#10;
		Dest = 16'b1000000000000000; Immediate = 8'b00100001; ImmEn = 0;
		#10;

		// case simulation should cause output to be 2 
		Dest = 16'b0000000000000001; Immediate = 8'b00100001; ImmEn = 0;
		#10;
		
		// Case that Ensures Carry doesn't affect result
		Dest = 16'b0000000000001000; Immediate = 8'b00100001; Carry = 1; ImmEn = 0;
		#10;
		
		//Random simulation
		for( i = 0; i< 10; i = i+ 1)
		begin
			#10
			Dest = $random % 65536;
			Immediate = 8'b00100001;
		end
		
//////////////////////////////////////
////				ARSHI					 ////
//////////////////////////////////////
		
		// Initialize inputs for ARSHI tests 
		$display("\n\nARSHI Tests:");
		Src = 0;
		Dest = 0;
		Opcode = 4'b1000;
		Immediate = 8'b00110001;
		Carry = 0;
		
		// Wait 100 ns for global reset to finish
		
		// arithmetic shift ensures sign bit stays the same,
		// so right arithmetic shift needs sign extension
	
		// case simulation should cause output to still be a large negative number 
		#10;
		Dest = 16'b1000000000000001; Immediate = 8'b00110001; ImmEn = 0;
		#10;

		// case simulation should cause output to be 1 
		Dest = 16'b0000000000000010; Immediate = 8'b00110001; ImmEn = 0;
		#10;
		
		// Case that Ensures Carry doesn't affect result
		Dest = 16'b0000000000001000; Immediate = 8'b00110001; Carry = 1; ImmEn = 0;
		#10;
		
		//Random simulation
		for( i = 0; i< 10; i = i+ 1)
		begin
			#10
			Dest = $random % 65536;
			Immediate = 8'b00110001;
		end
		
		$finish(2);

	end
      
endmodule
