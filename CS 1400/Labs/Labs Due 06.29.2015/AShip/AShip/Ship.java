public class Ship
{
   // fields
   
   private String name;
   private double speed;
   
   // constructors
   
   // methods
   
   public void setName(String newName)
   {
      name = newName;
   }
   
   public void setSpeed(int newSpeed)
   {
      speed = newSpeed;
   }
   
   public String getName()
   {
      return name;
   }
   
   public double getSpeed()
   {
      return speed;
   }

   public double travelTime(double distance)
   {
      double mph = speed * 1.151;
      return distance / mph;
   }
}