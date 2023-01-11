import java.util.Arrays;

public class LabArraysClass 
{
   public static void main(String[] args)
   {
      int[] iArray1 = {6, 12, 3, 9};
      int[] iArray2 = new int[5];
                
      // fill iArray2 with 7  
      
      iArray2[0] = 7;
      iArray2[1] = 7;
      iArray2[2] = 7;
      iArray2[3] = 7;
      iArray2[4] = 7;
                
      // print iArray1 and iArray2 (toString)
      
      System.out.printf("iArray1: %s\n", (Arrays.toString(iArray1)));
      System.out.printf("iArray2: %s\n", (Arrays.toString(iArray2)));
                
      // search for number 9 in iArray1 and print the value returned:
      
      System.out.printf("9 in iArray1: %s\n", (Arrays.binarySearch(iArray1, 9)));

      // sort iArray1 and print it
      
      Arrays.sort(iArray1);
      System.out.printf("iArray1 sorted: %s\n", (Arrays.toString(iArray1)));

      // search for number 9 in iArray1 and print the value returned:
      
      System.out.printf("9 in iArray1: %s\n", (Arrays.binarySearch(iArray1, 9)));
                
      // create iArray3 and assign it the first 3 elements of iArray1; print it
      
      int iArray3[] = {3, 6, 9};
      System.out.printf("iArray3: %s\n", (Arrays.toString(iArray3)));
                                
      // test equality of new int[] {3, 6, 9} and iArray3; print result
                
      int[] iArrayNew = {3, 6, 9};
      boolean arrayEqual = Arrays.equals(iArrayNew, iArray3);
      
      System.out.printf("iArray3 equals [3, 6, 9]: %b\n", arrayEqual);
      
      System.out.print("Reason: iArray1 was not sorted first time and the second time, iArray1 was sorted.");
    }
}