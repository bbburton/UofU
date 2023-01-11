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

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;
import javax.swing.JComponent;

/**
 * Creates a GUI that draws circles.
 * 
 * @author Brian Burton, last updated 01/19/17
 */
public class Circle extends JComponent implements MouseListener{
	
	private int xPosition;
	private int yPosition;
	private int width;
	private int height;
	private String circleName;
	private Boolean random;
	
	/**
	 * The circle constructor.
	 * 
	 * @param _xPosition -- X variable used to keep track of the components X value.
	 * @param _yPosition -- Y variable used to keep track of the components Y value.
	 * @param _width -- Width variable used to keep track of the components width value.
	 * @param _height -- Height variable used to keep track of the components height value.
	 * @param _circleName -- A String that allows you to name your circle. (Not sure why this is useful).
	 */
	public Circle(int _xPosition, int _yPosition, int _width, int _height, String _circleName) {
	
		//These initialize each variable keeping the object variables and the parameter variables separate.
		xPosition = _xPosition;
		yPosition = _yPosition;
		width = _width;
		height = _height;
		circleName = _circleName;
		
		//These setup the circle
		this.setLocation(xPosition, yPosition);
		this.setSize(width, height);
		this.setName(circleName);
		this.addMouseListener(this);
		
		//Determines if each circle is either colored red or blue.
		if(random = new Random().nextBoolean()) {
			
			this.setForeground(Color.RED);
		}
		else {
			
			this.setForeground(Color.BLUE);
		}
		
	}
	
	/**
	 * This method draws a single circle onto the GUI.
	 */
	@Override
	public void paintComponent(Graphics drawCircle) {
		
		//Determines whether or not each circle is outlined or filled in.
		if(random = new Random().nextBoolean()){
		
			drawCircle.drawOval(0, 0, width - 1, height - 1);
		}
		else {
			
			drawCircle.fillOval(0, 0, width - 1, height - 1);
		}
	}
	
	/**
	 * This method was suppose to move the amoebas back and forth at a fast rate.
	 */
	public void move() {
		
		//yPosition = speed
	}
	
	//This method is called whenever the user presses the mouse.
	@Override
	public void mousePressed(MouseEvent e) {
		
		//Testing to see if I could find out what the x and y position of a circle is.
		System.out.println(xPosition);
		System.out.println(yPosition);
	}
	
	//This method is called whenever the user drags the mouse.
	public void mouseDragged(MouseEvent event) {
		
		// I know that I need to find a way to find out where the mouse was first 
		//clicked and then subtract where the mouse was released. Not sure how to do this however...
		//this.setLocation(xPosition - , yPosition - );
		
		//Testing to see if I could find out what the new x and y positions of a circle are.
		System.out.println(xPosition);
		System.out.println(yPosition);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
		// This method has no use in this program.
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
		// This method has no use in this program.
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
		// This method has no use in this program.
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
		// This method has no use in this program.
	}

}
