public class Car
{
   // fields
	private String model;
	private String owner;
	
	// contructors
	
	// methods
	public String getModel()
	{
		return model;
	}
	
	public void setModel(String newModel)
	{
		model = newModel;
	}
		
	public String getOwner()
	{
		return owner;
	}
	
	public void setOwner(String newOwner)
	{
		owner = newOwner;
	}
	
	public void drive()
	{
		System.out.println("vroom");
	}
}