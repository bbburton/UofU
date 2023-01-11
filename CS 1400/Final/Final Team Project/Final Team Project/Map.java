/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeper;

/**
 *
 * @author slcjjw
 */
import java.util.Random;

public class Map
{

    // private field(s)

    int size;
    int notBombCounter;
    Tile gameMap[][] = new Tile[50][50]; //Max size of map is 50

    // constructor(s)
    public Map(int input)   // input is the size of map the player selected
    {
        size = input; // the size of the map.
        notBombCounter = 0; //a counter for how many tiles are NOT a bomb tile.

        createMap(); //assigns each tile a bomb or a safe character 
        refineMap(); // each tile determines if there is a bomb nearby and then hides map
    }

    public void createMap()
    { // nested for loop to fill in the array with either a bomb or a safe character
        for (int i = 0; i < size; i++)
        {
            for (int j = 0; j < size; j++)
            {
                gameMap[j][i] = new Tile();
                if (gameMap[j][i].getValue() != 'B') // looks at each tile to determine if BOMB or not.
                {
                    notBombCounter++; // increment the counter that tracks how many tiles are NOT bombs.
                }
            }
        }
    }

    public void refineMap()
    { //determines which tiles are adjacent to tiles and hides map
        for (int i = 0; i < size; i++)
        {
            for (int j = 0; j < size; j++)
            {
                int counter = 0; // keeps track of adjacent bombs
                if (gameMap[j][i].getValue() != 'B') //if the current tile isn't a bomb
                {
                    if (j != 0) //if we aren't on the far left side of the  map
                    {
                        if (gameMap[j - 1][i].getValue() == 'B') //if the tile to the left of the current tile is a bomb,
                        {
                            counter++;                         //add to counter
                        }
                    }
                    if (j != size - 1) // if we aren't on the far right side of the map
                    {
                        if (gameMap[j + 1][i].getValue() == 'B') //if the tile to the right of the current tile is a bomb,
                        {
                            counter++;                         //add to counter
                        }
                    }
                    if (i != 0) //if we aren't on the top of the map
                    {
                        if (gameMap[j][i - 1].getValue() == 'B') //of the tile above the current tile is a bomb,
                        {
                            counter++;                         //add to counter
                        }
                    }
                    if (i != size - 1) //if we aren't at the bottom of the map
                    {
                        if (gameMap[j][i + 1].getValue() == 'B') //if the tile below the current tile is a bomb,
                        {
                            counter++;                         //add to counter
                        }
                    }
                    if (j != 0 && i != 0) //if we aren't at the bottom of the map
                    {
                        if (gameMap[j - 1][i - 1].getValue() == 'B') //if the tile ABOVE and to the LEFT of the selected tile is a bomb, add to counter.
                        {
                            counter++;
                        }
                    }
                    if (i != 0 && j != size - 1)//if we aren't at the bottom of the map
                    {
                        if (gameMap[j + 1][i - 1].getValue() == 'B') //if the tile ABOVE and to the RIGHT of the selected tile is a bomb, add to counter. 
                        {
                            counter++;
                        }
                    }
                    if (j != size - 1 && i != size - 1)//if we aren't at the bottom of the map
                    {
                        if (gameMap[j + 1][i + 1].getValue() == 'B') //if the tile BELOW and to the LEFT of the selected tile is a bomb, add to counter.
                        {
                            counter++;
                        }
                    }
                    if (i != size - 1 && j != 0)//if we aren't at the bottom of the map
                    {
                        if (gameMap[j - 1][i + 1].getValue() == 'B') //if the tile BELOW and to the RIGHT of the selected tile is a bomb, add to counter.
                        {
                            counter++;
                        }
                    }

                    switch (counter) //Use switch counter to store information on the tile and its location to a bomb.
                    {
                        case 1:
                            gameMap[j][i].setValue('1');
                            break;
                        case 2:
                            gameMap[j][i].setValue('2');
                            break;
                        case 3:
                            gameMap[j][i].setValue('3');
                            break;
                        case 4:
                            gameMap[j][i].setValue('4');
                            break;
                        case 5:
                            gameMap[j][i].setValue('5');
                            break;
                        case 6:
                            gameMap[j][i].setValue('6');
                            break;
                        case 7:
                            gameMap[j][i].setValue('7');
                            break;
                        case 8:
                            gameMap[j][i].setValue('8');
                            break;
                        case 9:
                            gameMap[j][i].setValue('9');
                            break;
                    }

                }
            }
        }
        for (int ww = 0; ww < size; ww++)
        {
            for (int kk = 0; kk < size; kk++)
            {
                gameMap[ww][kk].toggle();// now that we've determined if the tile is a bomb or counted the number of adjacent bombs, we want to hide the tile from the player
            }
        }
    }

    public void printMap()
    { // prints current map. It's basically a nested loop to print each tile in the 2D array
        System.out.print("   ");
        for (int kk = 1; kk <= size; kk++) // print column number at the top
        {
            System.out.printf("%d ", kk);
        }
        System.out.println();

        System.out.print("  ");
        for (int tt = 1; tt <= size; tt++)
        {
            System.out.printf("__", tt);
        }
        System.out.println();

        for (int i = 0; i < size; i++)
        {
            System.out.printf("%-2d|", i + 1);//print row number at the left         

            for (int j = 0; j < size; j++)
            {
                System.out.printf("%c ", gameMap[j][i].getValue()); //print tile
            }
            System.out.println();
        }
        System.out.printf("Safe spots left: %d%n", notBombCounter); // displays the number of tiles that are not bombs to user.
    }

    public boolean input(int row, int column) //determines if player input hits a bomb.
    {
        gameMap[row][column].toggle(); //unhides the tile
        if (gameMap[row][column].getValue() == 'B') //if current tile is a bomb
        {
            System.out.print("You Hit a Bomb");
            return false; //false will trigger loss
        } else
        {
            fillIn(row, column);

            return true; //true will allow the player to keep playing
        }

    }

    public int tilesLeft()
    {
        return notBombCounter; // returns how many safe tiles (tiles that are not bombs) are left
    }

    public void fillIn(int row, int column)
    {
        if (gameMap[row][column].getTrueValue() != 'B')
        {
            gameMap[row][column].makeVisible();
            notBombCounter--; // decrement safe tile counter once a safe tile has been toggled/displayed.
        }
        if (gameMap[row][column].getTrueValue() == 'S')
        {

            if (row != 0)
            {
                if (gameMap[row - 1][column].hideCheck())
                {
                    fillIn(row - 1, column);
                }
                if (column != 0)
                {
                    if (gameMap[row - 1][column - 1].hideCheck())
                    {
                        fillIn(row - 1, column - 1);
                    }
                }
            }
            if (column != 0)
            {
                if (gameMap[row][column - 1].hideCheck())
                {
                    fillIn(row, column - 1);
                }
                if (row != size - 1)
                {
                    if (gameMap[row + 1][column - 1].hideCheck())
                    {
                        fillIn(row + 1, column - 1);
                    }
                }
            }
            if (row != size - 1)
            {
                if (gameMap[row + 1][column].hideCheck())
                {
                    fillIn(row + 1, column);
                }
                if (column != size - 1)
                {
                    if (gameMap[row + 1][column + 1].hideCheck())
                    {
                        fillIn(row + 1, column + 1);
                    }
                }
            }
            if (column != size - 1)
            {
                if (gameMap[row][column + 1].hideCheck())
                {
                    fillIn(row, column + 1);
                }
                if (row != 0)
                {
                    if (gameMap[row - 1][column + 1].hideCheck())
                    {
                        fillIn(row - 1, column + 1);
                    }
                }
            }
        }
    }
}