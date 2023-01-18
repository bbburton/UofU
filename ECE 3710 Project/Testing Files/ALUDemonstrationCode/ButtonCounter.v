module ButtonCounter(Button, Operation, ImmEn);

input Button;
output reg [3:0] Operation;
output reg ImmEn;

reg ButtonCount;

parameter AND = 4'b0001;
parameter OR = 4'b0010;
parameter XOR = 4'b0011;
parameter ADD = 4'b0101;
parameter ADDU = 4'b0110;
parameter ADDC = 4'b0111;
parameter SUB = 4'b1001;
parameter SUBC = 4'b1010;
parameter CMP = 4'b1011;
parameter NOT = 4'b1111;

parameter LSHI = 3'b000;
parameter LSH = 3'b010;
parameter ASHUI = 3'b001;
parameter ASHU = 3'b011;

always @(Button)
begin
	if (Button == 0)
	begin
	   ButtonCount = ButtonCount + 1;
	end
		
	
	case(ButtonCount)
		1://Add
		begin
			Operation = ADD; ImmEn = 0;
		end
		2://Addi
		begin
			Operation = ADD; ImmEn = 1;
		end
		3://Addu
		begin
			Operation = ADDU; ImmEn = 0;
		end
		4://Addui
		begin
			Operation = ADDU; ImmEn = 1;
		end
		5://Addc
		begin
			Operation = ADDC; ImmEn = 0;
		end
		6://Addci
		begin
			Operation = ADDC; ImmEn = 1;
		end
		7://Sub
		begin
			Operation = SUB; ImmEn = 0;
		end
		8://Subi
		begin
			Operation = SUB; ImmEn = 1;
		end
		9: //Cmp
		begin
			Operation = CMP; ImmEn = 0;
		end
		10: //Cmpi
		begin
			Operation = CMP; ImmEn = 1;
		end
		11: //AND
		begin
			Operation = AND; ImmEn = 0;
		end
		12: //OR
		begin
			Operation = OR; ImmEn = 0;
		end
		13: //XOR
		begin 
			Operation = XOR; ImmEn = 0;
		end
		14: // NOT
		begin
			Operation = NOT; ImmEn = 0;
			ButtonCount = 0;
		end
	endcase
	end
endmodule