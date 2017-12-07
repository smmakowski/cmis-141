import java.util.Scanner;
import java.util.ArrayList;

public class StateSymbolDataEntry {
	public static void main(String[] args) {
		// declare values for state entry
		String name = "";
		String bird = "";
		String flower = "";
		// declare array list to hold states entered
		ArrayList<State> statesData = new ArrayList<State>();
		State state = new State("TEST NAME", "test-flower", "tEST-Burd");
		
		// print results headers
		System.out.println("**** Thank you *****");
		System.out.println("A summary report for each State, Bird, and Flower is:");
		state.printInfo();
		
		// iterate through statesData
		for (int i = 0; i < statesData.size(); i++) {
			// call printInfo for each state in statesData to print data
		}
		
		System.out.println("Please vist our site again!");
	}

}
