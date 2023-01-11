/*******************************************************
* Name: Brian Burton
* Assignment: A02
*******************************************************/

public class A02original
{
	public static void main(String[] args)
	{
      // exmaple 0
		System.out.println("Example 0:");
      System.out.print("***");
      System.out.print("!!!");
      System.out.print("ooo");
      
      // example 1
		System.out.println("\n\nExample 1:");
      String name = "Susan";
      int age = 8;
      System.out.printf("%s is %d years old.", name, age);
      
      // example 2
		System.out.println("\n\nExample 2:");
      int number = 10;
      System.out.printf("2 * %d = %d", number, 2 * number);

      // example 3
		System.out.println("\n\nExample 3:");
      int side = 5;
      System.out.printf("Side: %d, Perimeter: %d", side, side * 3);

      // example 4
		System.out.println("\n\nExample 4:");
      int y = 456;
		System.out.printf("The value of y is %d.\n",y);
      System.out.printf("%-3d %-3d %-3d", y%1000/100, y%100/10, y%10);

      // example 5
		System.out.println("\n\nExample 5:");
      int number1 = 24;
      if (number1 % 7 == 0)
      {
         System.out.printf("%d is a multiple of 7.", number1);
      }
      if (number1 % 7 != 0)
      {
         System.out.printf("%d is not a multiple of 7.", number1);
      }

      // example 6
		System.out.println("\n\nExample 6:");
      int numberOfSides = 3;
      if (numberOfSides == 3)
      {
         System.out.println("*");
         System.out.println("**");
         System.out.print("***");
      }
      		
		// example 7
		System.out.println("\n\nExample 7:");
		int n1 = 1;
		int n2 = 3;
		int n3 = 5;
		System.out.println("Number  Square");
		System.out.printf("%-6d  %d\n", n1, n1 * n1);
		System.out.printf("%-6d  %d\n", n2, n2 * n2);
		System.out.printf("%-6d  %d\n", n3, n3 * n3);

	}
}