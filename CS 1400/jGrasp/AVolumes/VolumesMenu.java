// Name: Brian Burton
// Assignment: A07

import java.util.Scanner;

public class VolumesMenu
{
   public static void main(String[] args)
   {
      Volumes myVolume = new Volumes();
      int selection;
      
      do
      {
         menuPrompt();
         Scanner input = new Scanner(System.in);
         selection = input.nextInt();
         switch (selection)
         {
            case 1:
               System.out.printf("cuboid(2, 4, 6): volume = %.1f\n", myVolume.cuboid(2, 4, 6));
               break;
            
            case 2:
               System.out.printf("cuboid(4): volume = %.1f\n", myVolume.cuboid(4));
               break;
               
            case 3:
               System.out.printf("ellipsoid(2, 4, 6): volume = %.1f\n", myVolume.ellipsoid(2, 4, 6));
               break;
               
            case 4:
               System.out.printf("ellipsoid(4): volume = %.1f\n", myVolume.ellipsoid(4));
               break;
               
            case 5:
               System.out.printf("cylinder(3, 4): volume = %.1f\n", myVolume.cylinder(3, 4));
               break;
               
            case 6:
               System.out.printf("cone(6, 5): volume = %.1f\n", myVolume.cone(6, 5));
               break;
               
            case 0:
               System.out.print("Good Bye");
               break;
               
            default:
               System.out.println("Invalid Input");
               break;
          }
          System.out.println();
          
      }while(selection != 0);

   }
   
   public static void menuPrompt()
   {
      System.out.printf("%-25s %-25s\n", "1 .. cuboid(2, 4, 6)", "2 .. cuboid(4)");
		System.out.printf("%-25s %-25s\n", "3 .. ellipsoid(2, 4, 6)", "4 .. ellipsoid(4)");
      System.out.printf("%-25s %-25s\n", "5 .. cylinder(3, 4)", "6 .. cone(6, 5)");
		System.out.println("0 .. exit");
		System.out.print("Your choice: ");

   }
}