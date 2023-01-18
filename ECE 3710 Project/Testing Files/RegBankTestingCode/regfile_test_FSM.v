module regfile_test_FSM(clk, reset, /*all outputs...*/);

reg [4:1] y; //Update the 4-bit state variables

parameter [4:1] S0 = 4'b0000, S1 = 4'b0001, S2 = 4'b0010, S3 = 4'b0011, S4 = 4'b0100, S5 = 4'b0101, S6 = 4'b0110, S7 = 4'b0111, S8 4'b1000, S9 = 4'b1001, S10 = 4'b1010, S11 = 4'b1011, S12 = 4'b1100, S13 = 4'b1101, S14 = 4'b1110, S15 = 4'b1111;

//Next State logic updated @ Positive Edge Clock

always@(posedge clk)
begin

	if (reset)
	begin
		
		y <= S0; 
		R0 <= 4'd1;
		R1 <= 4'd1;
		R2 <= 4'd0;
		R3 <= 4'd0;
		R4 <= 4'd0;
		R5 <= 4'd0;
		R6 <= 4'd0;
		R7 <= 4'd0;
		R8 <= 4'd0;
		R9 <= 4'd0;
		R10 <= 4'd0;
		R11 <= 4'd0;
		R12 <= 4'd0;
		R13 <= 4'd0;
		R14 <= 4'd0;
		R15 <= 4'd0;
	end
	
case(y)

	S0:
	begin
		
		//Put decimal value 1 into Register 0 & 1.
		R0 <= 4'd1;
		R1 <= 4'd1;
		
		//Go to the next state.
		y <= S1;
	end
	
	S1:
	begin
	
		//Add contents of Register 0 with Register 1 and put answer into Register 2. (1+1 = 2).
		R2 <= R0 + R1;

		//Go to the next state.
		y <= S2;
	end

	S2:
	begin
	
		//Add contents of Register 1 with Register 2 and put answer into Register 3. (1+2 = 3).
		R3 <= R1 + R2;
		
		//Go to the next state.
		y <= S3;
	end	
	
	S3:
	begin
	
		//Add contents of Register 2 with Register 3 and put answer into Register 4. (2+3 = 5).
		R4 <= R2 + R3;
	
		//Go to the next state.
		y <= S4;
	end
	
	S4:
	begin
	
		//Add contents of Register 3 with Register 4 and put answer into Register 5. (3+5 = 8).
		R5 <= R3 + R4;
	
		//Go to the next state.
		y <= S5;
	end
	
	S5:
	begin
	
		//Add contents of Register 4 with Register 5 and put answer into Register 6. (5+8 = 13).
		R6 <= R4 + R5;
	
		//Go to the next state.
		y <= S6;
	end
	
	S6:
	begin
	
		//Add contents of Register 5 with Register 6 and put answer into Register 7. (8+13 = 21).
		R7 <= R5 + R6;
	
		//Go to the next state.
		y <= S7;
	end
	
	S7:
	begin
	
		//Add contents of Register 6 with Register 7 and put answer into Register 8. (13+21 = 34).
		R8 <= R6 + R7;
	
		//Go to the next state.
		y <= S8;
	end
	
	S8:
	begin
	
		//Add contents of Register 7 with Register 8 and put answer into Register 9. (21+34 = 55).
		R9 <= R7 + R8;
	
		//Go to the next state.
		y <= S9;
	end
	
	S9:
	begin
	
		//Add contents of Register 8 with Register 9 and put answer into Register 10. (34+55 = 89).
		R10 <= R8 + R9;
	
		//Go to the next state.
		y <= S10;
	end
	
	S10:
	begin
	
		//Add contents of Register 9 with Register 10 and put answer into Register 11. (55+89 = 144).
		R11 <= R9 + R10;
	
		//Go to the next state.
		y <= S11;
	end
	
	S11:
	begin
	
		//Add contents of Register 10 with Register 11 and put answer into Register 12. (89+144 = 233).
		R12 <= R10 + R11;
	
		//Go to the next state.
		y <= S12;
	end
	
	S12:
	begin
	
		//Add contents of Register 11 with Register 12 and put answer into Register 13. (144+233 = 377).
		R13 <= R11 + R12;
	
		//Go to the next state.
		y <= S13;
	end
	
	S13:
	begin
	
		//Add contents of Register 12 with Register 13 and put answer into Register 14. (233+377 = 610).
		R14 <= R12 + R13;
	
		//Go to the next state.
		y <= S14;
	end
	
	S14:
	begin
	
		//Add contents of Register 13 with Register 14 and put answer into Register 15. (377+610 = 987).
		R15 <= R13 + R14;
	
		//Go to the next state.
		y <= S15;
	end
	
	S15:
	begin
	
		//Not sure what to do here...
	end
endcase

endmodule
