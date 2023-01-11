import java.util.Scanner;

public class TimeTable
{
   public static void main(String[] args)
   {
      int number;
      int sum;
      
      Scanner input = new Scanner(System.in);
      System.out.println("Time Talbe:");
      System.out.print("Number (1 - 10): ");
      number = input.nextInt();
      
      for(int x = 1; x <= 10; x++)
      {
         sum = x * number;
         System.out.printf("%d * %d = %d\n", x, number, sum);
      }
   }
}