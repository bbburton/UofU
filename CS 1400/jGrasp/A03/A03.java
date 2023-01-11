public class A03
{
   public static void main(String[] args)
   {
      System.out.println("Testing class Car: ");
      
      Car myPrius = new Car();
      System.out.println();
      
      myPrius.setMake("Toyota");
      System.out.printf("Make: %s\n", myPrius.getMake());
      
      myPrius.setModel("Prius");
      System.out.printf("Model: %s\n", myPrius.getModel());
      
      myPrius.setOwner("Bob Smith");
      System.out.printf("Owner: %s\n\n", myPrius.getOwner());
      
      myPrius.setMake("Tesla");
      System.out.printf("Make: %s\n", myPrius.getMake());
      
      myPrius.setModel("Roadster");
      System.out.printf("Model: %s\n", myPrius.getModel());
      
      myPrius.setOwner("Lisa Ray");
      System.out.printf("Owner: %s\n\n", myPrius.getOwner());
      
      myPrius.setOwner("Bob Smith");
      System.out.printf("New Roadster Owner: %s\n\n\n", myPrius.getOwner());
      
      System.out.println("Testing class Country: ");
      
      Country country1 = new Country();
      System.out.println();
      
      country1.setName("Macau");
      System.out.printf("Name: %s\n", country1.getName());
      
      country1.setPopulation(453000);
      System.out.printf("Population: %,d\n", country1.getPopulation());
      
      country1.setArea(6);
      System.out.printf("Area: %d\n", country1.getArea());
      
      System.out.printf("Population Density: %,d\n\n", country1.populationDensity());
      
      Country country2 = new Country();
      
      country2.setName("Libya");
      System.out.printf("Name: %s\n", country2.getName());
      
      country2.setPopulation(5900000);
      System.out.printf("Population: %,d\n", country2.getPopulation());
      
      country2.setArea(679358);
      System.out.printf("Area: %,d\n", country2.getArea());
      
      System.out.printf("Population Density: %,d\n\n", country2.populationDensity());
      
      Country country3 = new Country();
      
      country3.setName("USA");
      System.out.printf("Name: %s\n", country3.getName());
      
      country3.setPopulation(298500000);
      System.out.printf("Population: %,d\n", country3.getPopulation());
      
      country3.setArea(3539225);
      System.out.printf("Area: %,d\n", country3.getArea());
      
      System.out.printf("Population Density: %,d\n\n", country3.populationDensity());
      
      country3.setPopulation(179323175);
      System.out.printf("1960 Population: %,d\n", country3.getPopulation());
      
      System.out.printf("1960 Population Density: %,d\n", country3.populationDensity());
      
   }
}