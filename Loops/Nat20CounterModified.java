// File:    Nat20Counter.java
// Author:  Michael Denman
// Date:    11-09-2017
// Purpose: Demonstrate understanding of for/while looping.

//Import required java classes
import java.util.*;

public class Nat20Counter {
	public static void main (String args[]) {
	// define variables
	int counter = 0;
	Random rollD20 = new Random();
	int currentRandValue = 0;
	boolean flag = true;

	/*Begin while loop*/
	while (flag) {
		currentRandValue = (rollD20.nextInt(21));
		if (currentRandValue == 20) {
			System.out.println("Current roll: " + currentRandValue);
			System.out.println("It took " + counter + " rolls to get a Natural 20 using this roll random program.");
			System.out.println("   _______   ");
			System.out.println("  /\\       \\  ");
			System.out.println(" /()\\   ()  \\  ");
			System.out.println("/    \\_______\\  ");
			System.out.println("\\    /()     / ");
			System.out.println(" \\()/   ()  / ");
			System.out.println("  \\/_____()/");
			flag = false; //Terminate loop
		} //End if
		else {
			System.out.println("Current roll: " + currentRandValue);
			counter++; //One-up counter
		} //End else
	} //End while
	} //End main
} //End class
