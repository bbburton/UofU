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

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

/**
 * This class holds my main method. It creates the GUI, determines the number of circles, 
 * 
 * @author Brian Burton, last updated 01/19/17
 */
public class Main {
	
	public static void main( String[] args ) {
		
		//Create new instances of each component.
		JFrame frame = new JFrame("The Jigglers");
		JPanel panel = new JPanel();
		JLabel label = new JLabel();
		JMenuBar menuBar = new JMenuBar();
		
		//Add each component to the JFrame and set some default properties.
		frame.setContentPane(panel);
		frame.setSize(700, 700);
		frame.setJMenuBar(menuBar);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel.setLayout(null);
		
		//
		JMenu myMenu = new JMenu("Extra"); 
		menuBar.add(myMenu); 
		
		JMenuItem myMenuItem = myMenu.add(new JMenuItem("Switch")); 
		
		//This is a method that listens for the user to select the "Switch" Menu Item.
		//This was a design decision that I made after making a mistake. :)
		myMenuItem.addActionListener(new ActionListener() {
			
			//This method repaints the screen in a random way.
			@Override
			public void actionPerformed(ActionEvent e) {
				
				panel.repaint();
			}
		});
		
		//Creates a new ArrayList to hold the Circle Components and sets it at null.
		ArrayList<Circle> myCircles = new ArrayList<Circle>();
		Circle ourCircles = null;
		
		//Creates a new Jiggler class to "jiggle" the amoebas and find the frames per second.
		Jiggler jig = new Jiggler(label);
		
		//This is where you can hard code how many circles to put onto the GUI.
		int numberOfCircles = 1000000;
		
		//This loop adds however many circles to the GUI and the Array List.
		for(int i = 0; i < numberOfCircles; i++){
		
			ourCircles = new Circle((int)(Math.random() * 500), (int)(Math.random() * 500), (int)(Math.random() * 150), (int)(Math.random() * 150),"Circle 1");
			panel.add(ourCircles);
			myCircles.add(ourCircles);
		}
		
		//This allows the user to see the GUI.
		frame.setVisible(true);
		
		//This variable is set to 0.
		int numberOfOvals = 0;
		
		//This for loop was created to jiggle each Circle Component put onto the GUI.
		for(Circle c1: myCircles) {
			
			//This was my failed attempt to jiggle each Circle Component.
			//jig.jiggle();
			
			//Keeps track of how many Circle Components are being jiggled.
			numberOfOvals++;
		}
		
		//Determines if the number of circles that were hard coded was also the 
		//same number of circles was added to the Array List.
		System.out.println("How many circles do I have? I have " + numberOfOvals);
		
		//Calculates the frames per second.
		jig.run();
	}
}
