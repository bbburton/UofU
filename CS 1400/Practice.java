import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class Practice
{
   public static void main(String[] args)
   {
      int[] iArray = {2, 3, 4, 1};
      int[] iArray2 = new int[5];
      ArrayList<String> treeList = new ArrayList<String>();
      treeList.add("Brian");
      
      String[] myNames = {"Brian", "Steven", "Brian"};
            
      System.out.printf("%s\n", Arrays.toString(iArray));
      
      System.out.println(treeList);
      
      iArray2[1] = 3;
            
      for (int x: iArray)
      {
         System.out.printf("%d ", x);
      }
      System.out.println();
      
      for (int y: iArray2)
      {
         System.out.printf("%d ", y);
      }
      System.out.println();
   }
}