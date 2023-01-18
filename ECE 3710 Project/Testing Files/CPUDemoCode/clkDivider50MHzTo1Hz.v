module clk_divider_50MHz_to_1Hz(clk_50MHz, reset, clk_1Hz);
input clk_50MHz, reset;
output reg clk_1Hz;

reg[24:0] count;

always@(posedge clk_50MHz, posedge reset)
begin
  if (reset == 1)
  begin
    count <=25'd0;
	 clk_1Hz <= 0;
  end
  else if (count == 25_000000)
  begin
    count <= 21'd0;
	 clk_1Hz <= ~clk_1Hz;
  end
  else
  begin
    count <= count + 1;
	 clk_1Hz = clk_1Hz;
  end
  
end
endmodule