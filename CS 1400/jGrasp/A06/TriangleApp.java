import java.util.Scanner;

public class TriangleApp
{
   public static void main(String[] args)
   {
      Scanner input = new Scanner(System.in);
      System.out.print("Side1: ");
      double side1 = input.nextDouble();
      System.out.print("Side2: ");
      double side2 = input.nextDouble();
      System.out.print("Side3: ");
      double side3 = input.nextDouble();
      Triangle myTriangle = new Triangle(side1, side2, side3);
            
      if(myTriangle.isRight() == true)
      {
         System.out.println("Triangle(" + myTriangle.getSide1() + ", " + myTriangle.getSide2() + ", " 
            + myTriangle.getSide3() + ") is right");

      }
      
      else if(myTriangle.isEquilateral() == true)
      {
         System.out.println("Triangle(" + myTriangle.getSide1() + ", " + myTriangle.getSide2() + ", " 
            + myTriangle.getSide3() + ") is equalateral");

      }
      
      else
      {
         System.out.println("Triangle(" + myTriangle.getSide1() + ", " + myTriangle.getSide2() + ", " 
            + myTriangle.getSide3() + ")");

      }
   }
}