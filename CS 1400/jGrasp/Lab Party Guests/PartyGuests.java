import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class PartyGuests
{
   public static void main(String[] args)
   {
      int numberOfGuests = 4;
      Scanner input = new Scanner(System.in);
      Random rand = new Random();
      ArrayList<String> guestList = new ArrayList<>();
   
      System.out.printf("Please enter %d guests: ", numberOfGuests);
      System.out.println();
      
      for(int x = 0; x < numberOfGuests; x++)
      {
         System.out.printf("guest%d: ", x + 1);
         guestList.add(input.nextLine());
      }
      
      System.out.printf("Guest list: %s\n", guestList);
      
      int guestNot = rand.nextInt(4);
      String guestGone = guestList.get(guestNot);
      guestList.remove(guestNot);
      System.out.printf("%s can't come\n", guestGone);
      
      System.out.printf("Updated guest list: %s\n", guestList);
   }
}