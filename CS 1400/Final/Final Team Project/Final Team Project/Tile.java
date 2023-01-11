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

public class Tile
{

    // private field(s)           //each tile has two attributes:

    private char value;              //a character value
    boolean isHidden;                //and whether or not the player can see the real character value

    // constructor(s)
    public Tile()  //constructor for tiles that will assign a bomb or a safe to the tile
    {
        isHidden = false;
        Random rand = new Random();
        if (isBomb(rand.nextInt(10))) //each tile has a 20% chance to be a bomb
        {
            value = 'B'; // sets value as BOMB
        } else
        {
            value = 'S'; // sets value os SAFE
        }
    }

    public boolean isBomb() //isBomb returns a true if the selected tile is a bomb
    {
        if (value == 'B')
        {
            return true;
        } else
        {
            return false;
        }
    }

    public static boolean isBomb(int random) //if isBomb is handed a random number that is less than two, it will declare the tile a bomb.
    {
        if (random < 2)
        {
            return true;
        } else
        {
            return false;
        }
    }

    public char getValue()  //used in the print map method. If a character is hidden, the map will display a *, if not, it will return it's true value
    {
        if (isHidden)
        {
            return '*';
        } else
        {
            return value;
        }
    }

    public void toggle() //if tile is hidden, it will be revealed. if it is revealed, it will be hidden
    {
        if (isHidden)
        {
            isHidden = false;
        } else
        {
            isHidden = true;
        }
    }

    public void setValue(char newValue) //setter for value
    {
        value = newValue;
    }

    public char getTrueValue()
    {
        return value;
    }

    public void makeVisible() //make tile visible.
    {
        isHidden = false;
    }

    public boolean hideCheck() //check to see if tile is hidden or visible.
    {
        if (isHidden)
        {
            return true;
        } else
        {
            return false;
        }
    }
}
