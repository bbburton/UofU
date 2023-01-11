public class Pattern3
{
   public static void main(String[] args)
   {
      String n1 = "o";
      String n2 = ".";
      
      for(int x = 5; x >= 1; x = x - 1)
      {
         for(int i = 0; i <= 4; i++)
         {
            if(x > i)
            {
            System.out.printf("%s ", n1);
            }
         
            else
            {
            System.out.printf("%s ", n2);
            }
         }
         System.out.println();
      }
   }
}