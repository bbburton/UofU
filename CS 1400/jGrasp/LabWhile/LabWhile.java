import java.util.Scanner;

public class LabWhile
{
   public static void main(String[] args)
   {
      multiplyNumbers();
   }
   
   public static void multiplyNumbers()
   {
      int product = 1;
      Scanner input = new Scanner(System.in);
      System.out.print("Please enter an integer: ");
      int number = input.nextInt();
      
      while (number != 0)
      {
         int sum = (number *= product);
         System.out.printf("%d * ", number);
         number = input.nextInt();
         number *= sum;
         System.out.println("Enter 0 to quit.");
         System.out.println();
         
         if (number == 0)
         {
            System.out.printf("Product: %d\n",
               sum);
         }
      }
   }
}