/**
 * Brian Burton
 * u1038667
 * 01/19/17
 * CS 2420
 * Assignment #1
 * 
 * I pledge that the work done here was my own and that I have learned how to write 
 * this program, such that I could throw it out and restart and finish it in a timely 
 * manner. I am not turning in any work that I cannot understand, describe, or recreate. 
 * 
 * -Brian Burton
 */

package Amoebas;

import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.JLabel;

/**
 * Creates a JLabel that keeps track of the frames per second. Also is to jiggle any component.
 * 
 * @author Brian Burton, last updated 01/19/17
 */
public class Jiggler extends Thread {
	
	ArrayList<JComponent> howManyCircles;
	JLabel framesPerSecond;
	boolean spreadOut;
	double speed;
	JComponent comp;
	double frameCount;
	long startTime;
	
	/**
	 * The jiggler constructor.
	 * 
	 * @param _framesPerSecond -- Is to display the frames per second onto the GUI.
	 */
	public Jiggler(JLabel _framesPerSecond) {
		
		//This initialized each variable keeping the object variables and the parameter variables separate.
		framesPerSecond = _framesPerSecond;
	}
	
	/**
	 * This method was an attempt to get the amoebas to jiggle.
	 */
	public void jiggle() {
		
		//Determines how fast the circles move.
		speed = (int)(Math.random() * .1);
		
		//Initializes the x and y values to the x and y values of the component.
		int yValue = comp.getY();
		int xValue = comp.getX();
		
		//Makes each circle full down.
		yValue += speed;
		
		//Determines when a circle is no longer on the GUI and brings it back up to the top.
		if(yValue > 700) {
			
			yValue = 0;
			xValue = (int) (Math.random() * 1000);
		}
		
		//Sets the new location of the circle and repaints it to the GUI.
		comp.setLocation(xValue, yValue);
		comp.repaint();
	}
	
	/**
	 * This method times the GUI's frames per second.
	 */
	public void run() {
		
		//Sets these variables to 0.
		frameCount = 0;
		startTime = System.nanoTime();
		
		//Computes the frames per second until user closes program. Also prints to the console the frames per second.
		while(true) {
			
			//Adds one to the frame count every time the compiler runs this forever loop.
			frameCount++;
			
			//Determines when to print the frames per second to the console.
			if(frameCount % 10000000 == 0) {
				
				//Calculates the frames per second.
				double elapsed = System.nanoTime() - startTime;
				double framesPerSecond = frameCount/elapsed;
				
				//Prints to the console.
				System.out.println("The frames per second are: " + framesPerSecond);
			}
		}
	}
}
