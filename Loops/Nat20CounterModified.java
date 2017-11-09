// File:    Nat20Counter.java
// Author:  Stephen Makowski
// Date:    11-09-2017
// Purpose: Modification of Loops program by Michael Denman. Additons allow
//          user to input the number of sides as well as the number you want
//          to get.

//Import required java classes
import java.util.*;

public class Nat20CounterModified {
	public static void main (String args[]) {
		// define variables
		int counter = 0;
		Random roll = new Random(); // rename to roll
		int currentRandValue = 0;
		boolean flag = true;
		// Add variables to store sides and target number
		int sides = 0;
		int target = 0;

		// create scanner instance
		Scanner scanner = new Scanner(System.in);
		//Prompt user for number of sides
		while (sides < 1) {
			System.out.println("Please enter a number of sides (greater than 1) you want you die to have (ex. 6),");
			System.out.println("or enter 2 to flip a coin instead: ");
			sides = scanner.nextInt();

			if (sides < 0) {
				System.out.println("Number is not valid. Please enter a positive number.");
			} else if (sides < 1) {
				System.out.println("Number is not valid. You cannot have a one-side die.");
			}
		}
		// prompt user for a target sides
		while (target < 1 || target > sides) {
			if (sides == 2) {
				System.out.println("Please enter what side you want to flip (1 for Heads, 2 for Tails):");
			} else {
				System.out.println("Please enter what number you want to roll (between  1 and " + sides + "):");
			}
			target = scanner.nextInt();

			if (target < 1 || target > sides) {
				System.out.println("Invalid number. Please enter a number with correct range.");
			}
		}

		// flip or roll while target has not been reached
		while (flag) {
			counter++;
			// roll/flip the dice or coin
			currentRandValue = roll.nextInt(sides) + 1;
			// if coin print flip related notification
			if (sides == 2) {
				if (currentRandValue == 1) {
					System.out.println("Current flip: Heads");
				} else {
					System.out.println("Current flip: Tails");
				}
			} else { // if die print roll
				System.out.println("Current roll: " + currentRandValue); // remove from both below conditionals to avoid unneccsary repeat
			}
			// if target is reached and flipping coin, print success
			if (currentRandValue == target && sides == 2) {
				if (target  == 1) { // heads success
					System.out.println("It took " + counter + " flips to get Heads.");
				} else { // tails success
					System.out.println("It took " + counter + " flips to get Tails.");
				}
				System.out.println("   __________");
				System.out.println(" /            \\");
				System.out.println("|              |");
				System.out.println("|       $      |");
				System.out.println("|              |");
				System.out.println(" \\____________/");
				flag = false;
			} else if (currentRandValue == target) { // if success and fdie print success
				System.out.println("It took " + counter + " rolls to get a " + target + ".");
				System.out.println("   _______   ");
				System.out.println("  /\\       \\  ");
				System.out.println(" /()\\   ()  \\  ");
				System.out.println("/    \\_______\\  ");
				System.out.println("\\    /()     / ");
				System.out.println(" \\()/   ()  / ");
				System.out.println("  \\/_____()/");
				flag = false; //Terminate loop
			}
			// remove counter++ and move to before check to avoid 0 rool situations
		} //End while
	} //End main
} //End class
