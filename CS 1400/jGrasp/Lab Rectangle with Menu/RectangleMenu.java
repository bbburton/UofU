import java.util.Scanner;

public class RectangleMenu
{
	public static void main(String[] args)
	{
      Rectangle myRectangle = new Rectangle(5, 4);
      int selection;
       
      do
      {
         menuPrompt();
         Scanner input = new Scanner(System.in);
         selection = input.nextInt();
         switch (selection)
         {
            case 1:
               System.out.printf("Area = %d", myRectangle.area());
               break;
            
            case 2:
               System.out.printf("Perimeter = %d", myRectangle.perimeter());
               break;
               
            case 3:
               System.out.printf("Length = %d\n Width = %d", 
                  myRectangle.getLength(), myRectangle.getWidth());
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
   
	
	private static void menuPrompt()
	{
	   System.out.println("1 .. area");
		System.out.println("2 .. perimeter");
		System.out.println("3 .. length and width");
		System.out.println("0 .. exit");
		System.out.print("Your choice: ");
	}
}
