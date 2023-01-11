// Name: Brian Burton
// Assignment: A07

public class Volumes
{
   
   public static double cuboid(double sideA, double sideB, double sideC)
   {
      return (sideA * sideB * sideC);
   }
   
   public static double cuboid(double side)
   {
      return (side * side * side);
   }
   
   public static double ellipsoid(double sideA, double sideB, double sideC)
   {
      return ((4.0/3.0)*Math.PI*sideA*sideB*sideC);
   }
   
   public static double ellipsoid(double side)
   {
      return (4.0/3.0)*Math.PI*side*side*side;
   }
   
   public static double cylinder(double radius, double height)
   {
      return Math.PI*radius*radius*height;
   }
   
   public static double cone(double diameter, double side)
   {
      return (1.0/3.0)*Math.PI*(diameter/2)*(diameter/2)*side;
   }
}