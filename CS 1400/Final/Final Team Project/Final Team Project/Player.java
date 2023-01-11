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
public class Player
{

    //fields

    static String name;
    static int win;
    static int loss;

   //Constructor
    //Create player object with name, wins, and lost fields.
    public Player(String n)
    {
        name = n;
        win = 0;
        loss = 0;

    }

    //Getters
    public String getName()
    {
        return name;
    }

    public int getWin()
    {
        return win;
    }

    public int getLoss()
    {
        return loss;
    }

   //Setters
    //When parameter is passed in, it increments
    public static void setWin(int w)
    {
        win = w + win;
    }

    public static void setLoss(int l)
    {
        loss = l + loss;
    }
}
