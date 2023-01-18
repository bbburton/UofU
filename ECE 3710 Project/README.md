# ECE3710Project

This is the Github for the ECE 3710 Project of Group 5 Fall 2020

The final project was a 2 player Tron game that took in a PS/2 keyboard as input 
and displayed the game screen using a vga connection and ran on a FPGA. As part of 
the game for every single game a player wins their score is increased by 1 and this 
overall score for both players is shown on the Seven Segment display of the FPGA. 
Furthermore, you are also allowed to "jump" over a line approximately every 8 1/2 
seconds in the game which differentiates our game from other tron games out there.

In order to download and run the game yourself follow these instructions:
1.  Navigate to the Verilog file on the github and put all verilog files contained 
    within it into a Quartus project because all of these modules are required and 
    used by the game. 
2.  Set the TronDatapath.v file to be the top level entity. 
3.  Now, you will then need to assign pin outputs by using the given qsf file which 
    contains all necessary pin assignments. 
4.  You can also add the sof and sdc files given as well.
5.  Go into the Software and Assembler folder and inside of it will be a folder called 
    SoftwareMemory inside of this folder is the hex memory file required for the game
    to run under the name SoftwareMemory.hex. This file contains the entire software 
    code (all code above @B000), the inital flag being set to run (the line under @B000)
    and the bitmap for the player 1 win screen and the player 2 win screen (all lines
    under @C000 and @D000 respectively).
 6. With all of these added you can now compile the game and upload it to an FPGA connected
    to a PS/2 keyboard and a vga monitor to run and play the game. WASD is used for player
    1 movement and the arrows are used for player 2 movement. Then, player 1 can press Q to 
    jump while player 2 can press enter to jump. Then, when a game is finished you can press 
    the space bar to start a new game.
    
Also in the github you will find testing folders these are groups of testing files that were
used to verify that all portions of the project were working correctly. Using these we are 
very confident that the code is operating exactly as intended.

Also in the software and assembler folder you will find the assembler we used to compile the 
game code given in the final code folder. The result of this assembly is placed above @B000 is 
the hex file. Then, you will also fine some bitmap excel folders and a hex file generator from
these bitmaps. These were used for the menu screens loaded in memory that the vga will read to 
display a menu screen. There are two of these one for a player 1 win screen which is placed 
below the @C000 in the hex file and one for the player 2 win screen which is placed below the @D000
in the hex file. The code used to take the excel bitmap file and transform it into a hex file is
given as well which is simply just reading it like a CSV file and then appending it line by line
into a hex file. Then, the only part of the hex file this doesn't include is that inside of the 
hex file there is a @B000 followed by 0001 which sets the flag for the VGA to start on a menu screen
instead of the game screen.

Lastly, the documents folder contains our final project report along with our Social, Environment,
and Ethical implication write up for our Tron game.
