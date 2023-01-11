// Name: Brian Burton
// Assignment: A05

public class Circle
{

   // fields
   private double radius;
   
   //constructors
   public Circle ()
   {
       double r = 0;
   }
   
   //methods
   public double getRadius()
   {
      return radius;
   }
   
   public void setRadius(double r)
   {
      if (r > 0)
      {
         radius = r;
      }
      
   }
   
   public double getDiameter()
   {
      double diameter;
      diameter = radius * 2;
      return diameter;
   }
   
   public double getArea()
   {
      double area;
      area = radius * radius * Math.PI;
      return area;
   }
   
   public double getCircumference()
   {
      double circumference;
      circumference = Math.PI * 2 * radius;
      return circumference;
   }
}