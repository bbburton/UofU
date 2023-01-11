public class isGoldenRatioTest
{
   public static void main(String[] args)
   {
      double n1 = 34;
      double n2 = 55;
      boolean result = isGoldenRatio(n1, n2);
      System.out.printf("Result: %b\n", result);
   }
   
   private static boolean isGoldenRatio (double n1, double n2)
   {
      double numerator = 0;
      double denominator = 0;
      
      if(n2 > n1)
      {
         numerator = n2;
         denominator = n1;
      }
      
      else
      {
         numerator = n1;
         denominator = n2;
      }
      
      double quotient = numerator / denominator;
      quotient = Math.round(quotient * 1000) / 1000d;
      
      
      if(quotient == 1.618)
      {
         return true;
      }
      
      else
      {
         return false;
      }
   }

}   

      