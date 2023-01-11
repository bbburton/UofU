public class Window
{
   public static void main(String[] args)
   { 
      int a = 5;
      for(int z = 0; z < a; z++)
      {
      System.out.println();
      displayWindow();
      
      for (int y = 0; y < 2; y++)
      {
      
      String line = "|";
      for (int x = 0; x < 3; x++)
      {
         for (int i = 0; i < 9; i++)
         {
            if(i == 0)
            {
               System.out.printf("%s", line);
            }
         
            else if (i == 4)
            {
               System.out.printf("%s", line);
            }
         
            else if (i == 8)
            {
               System.out.printf("%s", line);
            }
         
            else
            {
               System.out.print(" ");
            }
         }System.out.println();
      }
      
      displayWindow();
      }
      }
   }
   
   public static final void displayWindow()
   {
      String plus = "+";
      String equals = "=";
      
      for (int i = 0; i < 9; i++)
      {
         if(i == 0)
         {
            System.out.printf("%s", plus);
         }
         
         else if (i == 4)
         {
            System.out.printf("%s", plus);
         }
         
         else if (i == 8)
         {
            System.out.printf("%s", plus);
         }
         
         else
         {
            System.out.printf("%s", equals);
         }
      }
      System.out.println();
      
   }
}