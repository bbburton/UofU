//Did in class

import java.util.Arrays
;

public class Eratosthenes
{
   public static void main(String[] args)
   {
      char[] sieve = new char [121];
      Arrays.fill(sieve, '0');
      
      System.out.println(Arrays.toString(sieve));
      
      sieve[0] = 'n';
      sieve[1] = 'n';
      
      System.out.println(Arrays.toString(sieve));
      
      for(int x = 2; x < sieve.length; ++x)
      {
         if(sieve[x] == '0');
         {
            sieve[x] = 'p';
            for(int y = x + 1; y < sieve.length; ++y)
            {
               if(y % x ==0)
               {
                  sieve[y] = 'n';
               }
            }
         }
      }
      System.out.println(Arrays.toString(sieve));
   }
}