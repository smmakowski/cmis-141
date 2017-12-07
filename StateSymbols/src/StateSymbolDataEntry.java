/*
  * File: StateSymbolDataEntry.java
  * Author: Stephen Makowski
  * Date: November 19, 2017
  * Purpose: Main program that uses State class. Prompts user to add state bird and flower information
  * and creates instances of State class that are stored in array list. After data entry is complete,
  * information for each state is printed back to user
*/

import java.util.Scanner;
import java.util.ArrayList;

public class StateSymbolDataEntry {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		// declare values for state entry
		String name = "";
		String bird = "";
		String flower = "";
		// declare array list to hold states entered
		ArrayList<State> statesData = new ArrayList<State>();
		while (true) {
			System.out.println("Enter a State or None to exit:");
			name = scan.nextLine();
			
			if (name.equalsIgnoreCase("none")) {
				break;
			} else {
				System.out.print("Bird: ");
				bird = scan.nextLine();
				System.out.print("Flower: ");
				flower = scan.nextLine();
				
				statesData.add(new State(name, bird, flower));
			}
		}
		
		// print results headers
		System.out.println("");
		System.out.println("**** Thank you *****");
		System.out.println("A summary report for each State, Bird, and Flower is:");
		
		// iterate through statesData
		for (int i = 0; i < statesData.size(); i++) {
			// call printInfo for each state in statesData to print data
			statesData.get(i).printInfo();
		}
		
		System.out.println("Please vist our site again!");
	}

}
