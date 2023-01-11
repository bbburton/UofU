public class CarApp
{
   public static void main(String[] args)
   {
      Car myCar = new Car();
      
      myCar.setModel("Prius");
      String model = "Prius";
      System.out.printf("Model: %s\n", myCar.getModel());
      
      myCar.setOwner("Ms Summer");
      String owner = "Ms Summer";
      System.out.printf("Owner: %s\n", myCar.getOwner());
      
      myCar.setOwner("Mr Smith");
      String newOwner = "Mr Smith";
      System.out.printf("New owner: %s\n", myCar.getOwner());
      
      myCar.drive();
   }
}