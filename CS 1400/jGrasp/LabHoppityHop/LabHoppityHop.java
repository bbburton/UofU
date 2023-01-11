import java.util.Scanner;

public class LabHoppityHop
{
   public static void main(String[] args)
   {
      Scanner input = new Scanner(System.in);
      
      for(int x = 1; x <= 25; ++x)
      {
         
      if(x % 3 == 0 && x % 5 == 0)
      {
         System.out.println("Hoppity Hop");
      }
      else if(x % 3 == 0)
      {
         System.out.println("Hoppity");
      }
      
      else if(x % 5 == 0)
      {
         System.out.println("Hop");
      }
      
      else
      {
         System.out.println(x);
      }
      }
   }
}