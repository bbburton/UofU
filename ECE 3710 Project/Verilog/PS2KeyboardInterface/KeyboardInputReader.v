`timescale 1ns / 1ps
module KeyboardInputReader(sysClk, PS2clk, PS2data, keysPressed);//, prevKeycode);

	input sysClk, PS2clk, PS2data; // Clock and data wires that are used to determine which key was pressed/released
	reg [7:0] keycode; // This stores the code recieved from the keyboard trhough the PS2 connection
	reg errorOccured;				//this becomes one if an error was received somewhere in the packet
	reg reading;				//this is 1 if still waits to receive more bits 
	reg [11:0] pulsesSinceLastBit;		//this is used to detect how much time passed since it received the previous keycode
	reg prevPS2Clk;			// to detect negedge of the PS2 clock
	reg [10:0] bitsRecieved;			//this stores 11 received bits
	reg fullPacketRecieved;				//this is set high when the full 11 bits are received
	reg [3:0] numBitsRecieved;				//tells how many bits were received for the current recieve
	reg clk200kHz;			//This acts as a 250 times slower than the board clock. 
	reg [7:0] clkCounter;		//Used to slow down the board clock
	reg [7:0]prevKeycode;      // Stores the keycode previously recieved
	reg [7:0] prevPrevKeycode; // Stored the keycode recieved two sends ago
	output reg [15:0] keysPressed; // Output register marking which keys are pressed down

	// Parameter wires used to detect the keycode
	wire [7:0] IGNORE = 8'hEE;
	wire [7:0] AKEY = 8'h1C;
   wire [7:0] SKEY = 8'h1B;
   wire [7:0] DKEY = 8'h23;
   wire [7:0] WKEY = 8'h1D;
	wire [7:0] ARROWUPKEY = 8'h75;	//codes for arrows
	wire [7:0] ARROWDOWNKEY = 8'h72;
	wire [7:0] ARROWLEFTKEY = 8'h6B;
	wire [7:0] ARROWRIGHTKEY = 8'h74;
	wire [7:0] JKEY = 8'h3B;
   wire [7:0] KKEY = 8'h42;
   wire [7:0] LKEY = 8'h4B;
   wire [7:0] IKEY = 8'h43;
	wire [7:0] QKEY = 8'h15;
   wire [7:0] ENTERKEY = 8'h5A;
   wire [7:0] UKEY = 8'h3C;
	wire [7:0] SPACEKEY = 8'h29;
	wire [7:0] ARROW = 8'hE0;	// arrow code 
	wire [7:0] RELEASE = 8'hF0; // release code

	// Parameters assigning keys to bits in the keysPressed array
	parameter A = 1;
	parameter S = 3;
	parameter D = 2;
	parameter W = 0;
	parameter ARROWLEFT = 5;
	parameter ARROWDOWN = 7;
	parameter ARROWRIGHT = 6;
	parameter ARROWUP = 4;
	parameter J = 9;
	parameter K = 11;
	parameter L = 10;
	parameter I = 8;
	parameter Q = 12;
	parameter ENTER = 13;
	parameter U  = 14;
	parameter SPACE = 15;
	
	//Set initial values
	initial begin
		clk200kHz = 0;
		clkCounter = 0;
		prevPS2Clk = 1;		
		errorOccured = 0;		
		bitsRecieved = 0;
		numBitsRecieved = 0;			
		keycode = 0;
		reading = 0;
		pulsesSinceLastBit = 0;
		keysPressed = 0;
		prevKeycode = 0;
		prevPrevKeycode = 0;
	end

	//This reduces the system clock frequency 250 times the resulting clock is a 200kHz clock
	always @(posedge sysClk) 
	begin	
		if (clkCounter < 249) 
		begin			
			clkCounter <= clkCounter + 1;
			clk200kHz <= 0;
		end
		else 
		begin
			clkCounter <= 0;
			clk200kHz <= 1;
		end
	end
	
	always @(posedge sysClk) 
	begin	
		if (clk200kHz) 
		begin
			// Keep track of the number of pulses recieved since the last bit was recieved if 
			// Helps to end recieving bits if for some reason not all of them were send.
			if (reading)				
				pulsesSinceLastBit <= pulsesSinceLastBit + 1;	
			else 						
				pulsesSinceLastBit <= 0;
		end
	end

	always @(posedge sysClk) 
	begin		
		if (clk200kHz) // system clock is ready to read
		begin						
			if (!PS2clk && PS2clk != prevPS2Clk) // if it is a falling edge on the PS2clock
			begin			//if it is a falling edge on the PS2clock
				reading <= 1;				//mark down that it is still reading
				errorOccured <= 0;		// you haven't encountered any errors yet
				bitsRecieved[10:0] <= {PS2data, bitsRecieved[10:1]};	//shift the newly recieved bit into the bitsRecieved array losing the least recently recieved bit
				numBitsRecieved <= numBitsRecieved + 1; // Mark that you have recieved 1 more bit
			end
			// Will be triggered very soon after all bits are recieved before the next one is sent
			else if (numBitsRecieved == 11) // All 11 bits have been recieved
			begin				
				numBitsRecieved <= 0;            // Next bit recieved will be the start of a new 11 bits
				reading <= 0;							// all bits have been recieved so you are no longer reading.
				fullPacketRecieved <= 1;			// Mark that all bits have been recieved
			
				//An error occured if the first bit wasn't 1, the last bit wasn't 0, or if the parity bit didn't match what was sent
				if (!bitsRecieved[10] || bitsRecieved[0] || !(bitsRecieved[1]^bitsRecieved[2]^bitsRecieved[3]^bitsRecieved[4]
					  ^bitsRecieved[5]^bitsRecieved[6]^bitsRecieved[7]^bitsRecieved[8]^bitsRecieved[9]))
					errorOccured <= 1;
				else 
					errorOccured <= 0;
			end	
			else  //the negedge didn't occur and not all bits have been recieved
			begin						
				fullPacketRecieved <= 0;					//The 11 bits have not been recieved yet
				if (numBitsRecieved < 11 && pulsesSinceLastBit >= 4000) //and if recieving has stopped for too long of a time
				begin	
					numBitsRecieved <= 0;	// Make sure the next recieve considers it a fresh signal
					reading <= 0;				// stop waiting to recieve
				end
			end
		prevPS2Clk <= PS2clk;	// previous state of the keyboard clock this will be used to help detect the negedge
		end
	end


	always @(posedge sysClk) 
	begin
		if (clk200kHz) 
		begin	
			if (fullPacketRecieved) // All 11 bits have been recieved
			begin	
				if (errorOccured) 
				begin			
					keycode <= 8'hee;		//If there was an error in what was recieved the keycode is corrupted so don't set it
				end
				else 
				begin
					keycode <= bitsRecieved[8:1];	//Put the correct bits in the keycode register if no error occurred
				end				
			end					
			else keycode <= 8'hee;				// you haven't recieved all bits yet so don't modify the keycode
		end
		else keycode <= 8'hee;					// The clock is not ready to read
	end
	
	always @(posedge sysClk) 
	begin
		//if (clk200kHz)
		//begin
			if(keycode != IGNORE)
			begin
				prevPrevKeycode <= prevKeycode;
				prevKeycode <= keycode;
				
				// Check if a key has been released
				if (prevKeycode == RELEASE && keycode == AKEY)
					keysPressed[A] = 0;
				else if (prevKeycode == RELEASE && keycode == SKEY)
					keysPressed[S] = 0;
				else if (prevKeycode == RELEASE && keycode == DKEY)
					keysPressed[D] = 0;
				else if (prevKeycode == RELEASE && keycode == WKEY)
					keysPressed[W] = 0;
				else if (prevKeycode == RELEASE && keycode == JKEY)
					keysPressed[J] = 0;
				else if (prevKeycode == RELEASE && keycode == KKEY)
					keysPressed[K] = 0;
				else if (prevKeycode == RELEASE && keycode == LKEY)
					keysPressed[L] = 0;
				else if (prevKeycode == RELEASE && keycode == IKEY)
					keysPressed[I] = 0;
				else if (prevKeycode == RELEASE && keycode == QKEY)
					keysPressed[Q] = 0;
				else if (prevKeycode == RELEASE && keycode == ENTERKEY)
					keysPressed[ENTER] = 0;
				else if (prevKeycode == RELEASE && keycode == UKEY)
					keysPressed[U] = 0;
				else if (prevKeycode == RELEASE && keycode == SPACEKEY)
					keysPressed[SPACE] = 0;	
	
				// Check if a key has been pressed
				else if (keycode == AKEY)				
					keysPressed[A] <= 1;
				else if (keycode == SKEY)			
					keysPressed[S] <= 1;
				else if (keycode == DKEY)
					keysPressed[D] <= 1;
				else if (keycode == WKEY)
					keysPressed[W] <= 1;
				else if (keycode == JKEY)			
					keysPressed[J] <= 1;
				else if (keycode == KKEY)			
					keysPressed[K] <= 1;
				else if (keycode == LKEY)			
					keysPressed[L] <= 1;
				else if (keycode == IKEY)			
					keysPressed[I] <= 1;
				else if (keycode == QKEY)			
					keysPressed[Q] <= 1;
				else if (keycode == ENTERKEY)			
					keysPressed[ENTER] <= 1;
				else if (keycode == UKEY)			
					keysPressed[U] <= 1;					
				else if (keycode == SPACEKEY)
					keysPressed[SPACE] <= 1;
					
				// Check if an arrow key has been pressed
				else if (prevKeycode == ARROW && keycode == ARROWUPKEY)
					keysPressed[ARROWUP] = 1;
				else if (prevKeycode == ARROW && keycode == ARROWDOWNKEY)
					keysPressed[ARROWDOWN] = 1;
				else if (prevKeycode == ARROW && keycode == ARROWLEFTKEY)
					keysPressed[ARROWLEFT] = 1;
				else if (prevKeycode == ARROW && keycode == ARROWRIGHTKEY)
					keysPressed[ARROWRIGHT] = 1;
					
				// Check if an arrow key has been released
				else if (prevPrevKeycode == ARROW && prevKeycode == RELEASE && keycode == ARROWUPKEY)
					keysPressed[ARROWUP] = 0;
				else if (prevPrevKeycode == ARROW && prevKeycode == RELEASE && keycode == ARROWDOWNKEY)
					keysPressed[ARROWDOWN] = 0;
				else if (prevPrevKeycode == ARROW && prevKeycode == RELEASE && keycode == ARROWLEFTKEY)
					keysPressed[ARROWLEFT] = 0;
				else if (prevPrevKeycode == ARROW && prevKeycode == RELEASE && keycode == ARROWRIGHTKEY)
					keysPressed[ARROWRIGHT] = 0;
			end
		//end
	end
endmodule
