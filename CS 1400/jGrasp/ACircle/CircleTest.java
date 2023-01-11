// Name: Brian Burton
// Assignment: A05
import java.util.Scanner;

public class CircleTest
{
   private static void circleTest(double r)
   {
      Scanner input = new Scanner(System.in);
      Circle myCircle = new Circle();
      myCircle.setRadius(r);
      
      System.out.printf("Parameter: %.0f\n\n", r);
      System.out.printf("radius = %.1f\n", myCircle.getRadius());
      System.out.printf("diameter = %.1f\n", myCircle.getDiameter());
      System.out.printf("area = %.1f\n", myCircle.getArea());
      System.out.printf("circumference = %.1f\n", myCircle.getCircumference());
      
      System.out.printf("radius = %.1f\n", myCircle.getRadius());
      System.out.printf("diameter = %.1f\n", myCircle.getDiameter());
      System.out.printf("area = %.1f\n", myCircle.getArea());
      System.out.printf("circumference = %.1f\n", myCircle.getCircumference());
   }
   
   public static void main(String[] args)
   {
      circleTest(-2);
      System.out.println();
      circleTest(2);
      System.out.println();
      circleTest(6);
      System.out.println();
   }
}