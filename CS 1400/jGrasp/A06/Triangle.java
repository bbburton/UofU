public class Triangle
{
   //fields
   
   private double side1;
   private double side2;
   private double side3;
   
   //constructors
   
   public Triangle (double a, double b, double c)
   {
      if(isTriangle(a, b, c) == true)
      {
         side1 = a;
         side2 = b;
         side3 = c;
      }
      else
      {
         side1 = 1;
         side2 = 1;
         side3 = 1;
      }
   }
   
   //methods
   
   public double getSide1()
   {
      return side1;
   }
   
   public double getSide2()
   {
      return side2;
   }
   
   public double getSide3()
   {
      return side3;
   }
   
   private boolean isTriangle(double a, double b, double c)
   {
      if((a > 0) &&
         (b > 0) &&
         (c > 0) &&
         (a + b > c) &&
         (a + c > b) &&
         (b + c > a))
         return true;
      else
      return false;
   }
   
   public boolean isEquilateral()
   {
      if((side1 == side2) && (side1 == side3))
      return true;
      else
      return false;
   }
   
   public boolean isRight()
   {
      if(((side1 * side1) == ((side2 * side2) + (side3 * side3))) ||
        ((side2 * side2) == ((side1 * side1) + (side3 * side3))) ||
        ((side3 * side3) == ((side1 * side1) + (side2 * side2))))
         return true;
      else
         return false;
   }
}