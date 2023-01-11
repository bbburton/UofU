import java.util.Random;
import java.util.Arrays;

public class Dice
{
   public static void main(String[] args)
   {
      Random rand = new Random();
      
      for(int x = 1; x <= 3600; x++)
      {
         int dice1 = rand.nextInt(6) + 1;
         int dice2 = rand.nextInt(6) + 1;
         
         //Once both dice have been rolled calculate
         //the sum of the two values.
         
         int diceSum = dice1 + dice2;
      }
         //Use a one dimensional integer array to 
         //count how often each sum appears.
         
         int[] sumArray = new int[11];
         
         System.out.println(sumArray[11]);
   }
}