import java.util.Scanner;

public class CalculatorApp
{
   public static void main(String[] args)
   {
      Calculator myCalculator = new Calculator();
      Scanner input = new Scanner(System.in);
      
      System.out.print("number1: ");
      int number1 = input.nextInt();
      System.out.print("number2: ");
      int number2 = input.nextInt();
      System.out.println();
      
      System.out.printf("sum: %d\n", myCalculator.sum(number1, number2));
      System.out.printf("difference: %d\n", myCalculator.difference(number1, number2));
      System.out.printf("product: %d\n", myCalculator.product(number1, number2));
   }
}