import java.util.Random;

public class LabRandom
{
   public static void main(String[] args)
   {
      Random rand = new Random();
      int number;
      
      for(int i = 1; i <= 100; i++)
      {
         number = rand.nextInt(4) + 4;
         System.out.printf("%-5d", number);
         
         if ((i % 10) == 0)
         {
            System.out.println();
         }
      }
         System.out.println();
      
      for(int x = 1; x <= 100; x++)
      {
         number = rand.nextInt(9) * 10 + 10;
         System.out.printf("%-5d", number);
         
         if ((x % 10) == 0)
         {
            System.out.println();
         }
      }
         System.out.println();
      
      for(int y = 1; y <= 100; y++)
      {
         number = rand.nextInt(98) + 901;
         System.out.printf("%-5d", number);
         
         if ((y % 10) == 0)
         {
            System.out.println();
         }
      }
         System.out.println();
      
   }
}