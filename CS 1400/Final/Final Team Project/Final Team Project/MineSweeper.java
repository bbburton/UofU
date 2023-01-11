package minesweeper;

/**
 * * @author Andrew Russell, Brian Burton, Jeffrey Wood Students: Andrew
 * Russell, Brian Burton, Jeffrey Wood Class: CSIS 1400-002-SU15 Assignment: A10
 * - Team Project
 */
import java.util.Scanner;

public class MineSweeper
{

    /**
     * @param args the command line arguments
     */
    public static boolean PlayGame() //Play Game is true, game keeps playing.
    {
        Scanner input = new Scanner(System.in); // Setup scanner object with "input" as name.
        System.out.print("Please enter map size (Maximum of 50): "); //User can select a map size of up to 50 tiles.
        int selection = input.nextInt(); // receive input from user on map size.
        Map myMap = new Map(selection); //create map of size selection

        boolean alive = true;
        do
        {
            myMap.printMap(); //prints current map
            int row = 0; // setup var to recieve input from user on selecting tile location.
            int column = 0; // setup var to receive input from user on selecting tile location.
            boolean validInput = false; // used to determine if input is value.

            while (validInput == false) // player selects row
            {
                System.out.printf("Enter Row (1-%d): ", selection); // prompt user for input.
                row = input.nextInt() - 1; // recieve row input, then subtract by (1) to ofset because array starts at 0 instead of (1).
                if (row >= 0 && row < selection) // determine if selection is valid
                {
                    validInput = true;
                } else
                {
                    System.out.printf("Invalid input.%n");
                }
            }

            validInput = false;
            while (validInput == false) // player selects column
            {
                System.out.printf("Enter Column (1-%d): ", selection);
                column = input.nextInt() - 1;// recieve column input, then subtract by (1) to ofset because array starts at 0 instead of (1).
                if (column >= 0 && column < selection) // determine if selection is valid
                {
                    validInput = true;
                } else
                {
                    System.out.printf("Invalid input%n");
                }

            }
            alive = myMap.input(column, row);  //finds out what tile is and returns false if a bomb is hit       
            if (myMap.tilesLeft() <= 0 && alive != false)
            {
                myMap.printMap(); //prints ending map
                return true;
            }

        } while (alive);
        System.out.println();
        myMap.printMap(); //prints ending map

        return false; //if bomb was triggered, false signifies loss
    }

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        System.out.printf("Welcome to MiNeSwEePer!%n"); // Game introduction message
        System.out.print("Please enter your name: "); // request name of player.

        String player = input.nextLine(); // receive player's name from input
        Player myPlayer = new Player(player); // create player object with name, see Player.java (used to keep score).

        int newGame = 1;
        Scanner inputInt = new Scanner(System.in);
        do
        {
            boolean win = PlayGame();
            if (win) // if the user won the game, then increment win score.
            {
                System.out.printf("You Won!%n");

                myPlayer.setWin(1); // Used to increment score on player object.       
            } else // if the user lost the game, then increment loss score.
            {

                myPlayer.setLoss(1); // Used to increment score on player object.

            }

            System.out.printf("%nPress 1 to play another game or 2 to quit: "); // allows the user to continue playing or exit the game.
            newGame = inputInt.nextInt();
        } while (newGame == 1);
        System.out.printf("%n%S, you won %d games and lost %d games.%n", myPlayer.getName(), myPlayer.getWin(), myPlayer.getLoss()); //if user decided to exit, display score.
        System.out.println("Good Bye!"); // display exit message to user.

    }

}
