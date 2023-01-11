/*******************************************************
* Name: Brian Burton
* Assignment: A02
*******************************************************/

public class A02
{
	public static void main(String[] args)
	{
      // exmaple 0
		System.out.println("Example 0:");
      System.out.println("  o  ");
      System.out.println(" / \\ ");
      System.out.println("o o o");
      
      // example 1
		System.out.println("\n\nExample 1:");
      String name = "Michael";
      int miles = 7;
      System.out.printf("%s swam %d laps.", name, miles);
      
      // example 2
		System.out.println("\n\nExample 2:");
      int number = 0;
      System.out.printf("2 / 4 = %d", number);

      // example 3
		System.out.println("\n\nExample 3:");
      int side = 7;
      System.out.printf("The perimeter of a square with side %d is %d."
         , side, side * 4);

      // example 4
		System.out.println("\n\nExample 4:");
      int y = 8642;
		System.out.printf("The value of y is %d. ",y);
      System.out.print("The first 3 digits are: ");
      System.out.printf("\n%-3d %-3d %-3d", y%10000/1000, y%1000/100, y%100/10);

      // example 5
		System.out.println("\n\nExample 5:");
      int number1 = 21;
      if (number1 % 7 == 0)
      {
         System.out.printf("%d is 3 times 7.", number1);
      }
      if (number1 % 7 != 0)
      {
         System.out.printf("%d is not 3 times 7.", number1);
      }

      // example 6
		System.out.println("\n\nExample 6:");
      int numberOfSides = 3;
      if (numberOfSides == 3)
      {
         System.out.println("*******");
         System.out.println("*     *");
         System.out.println("*******");
      }
      		
		// example 7
		System.out.println("\n\nExample 7:");
		int n1 = 2;
		int n2 = 4;
		int n3 = 6;
		System.out.println("Number  Square  Cube");
		System.out.printf("%-7d  %-7d  %d\n", n1, n1 * n1, n1 * n1 * n1);
		System.out.printf("%-6d  %-7d  %d\n", n2, n2 * n2, n2 * n2 * n2);
		System.out.printf("%-6d  %-6d  %d\n", n3, n3 * n3, n3 * n3 * n3);

	}
}