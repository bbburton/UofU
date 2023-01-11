import java.util.Scanner;

public class PatternsTest
{
   public static void main(String[] args)
   {
      Scanner input = new Scanner(System.in);
      System.out.print("Choose a pattern (1-4) or 0 to quit: ");
      int choice = input.nextInt();
      
      switch (choice)
      {
      case 1:
         patterns1(7);
         break;
      case 2:
         patters2(7);
         break;
      case 3:
         patters3(7);
         break;
      case 4:
         patters3(7);
         break;
      }
   }
}