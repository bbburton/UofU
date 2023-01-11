import java.util.Scanner;

public class ShipApp
{
   public static void main(String[] args)
   {
      Scanner input = new Scanner(System.in);
      System.out.println("Crusie Ferry:");
      
      Ship ship1 = new Ship();
      
      ship1.setName("Peter Pan");
      System.out.printf("Name: %s\n", ship1.getName());
      
      ship1.setSpeed(21);
      System.out.printf("Speed: %.1f knots", ship1.getSpeed());
      System.out.println();
      
      System.out.printf("Time to cross bass strait: %.1f hours\n\n", ship1.travelTime(374));
      
      Ship ship2 = new Ship();
      
      System.out.println("Dinghy:");
      
      ship2.setName("Laser Dinghy");
      System.out.printf("Name: %s\n", ship2.getName());
      
      ship2.setSpeed(25);
      System.out.printf("Speed: %.1f knots\n", ship2.getSpeed());
      
      System.out.printf("Time to cross bass strait: %.1f hours\n\n", ship2.travelTime(374));
   }
}