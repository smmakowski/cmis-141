/*
  * File: CrimeTest.java
  * Author: Stephen Makowski
  * Date: December 10, 2017
  * Purpose: Test class designed to use methods from Crime class to read file data and run calculations/results printing
  * Test program takes 1 command line argument (fileName) which is the path where the crime data is located.
*/
import java.io.*;
//import java.util.Scanner;

public class CrimeTest {
	static int  seconds = 0;
	public static void main(String[] args) throws FileNotFoundException {
		// if argument provided
		if (args.length > 0) {
			Crime crimeData = new Crime();

			try {
				// read the file data with Crime class method
				crimeData.readCrimeData(args[0]);
				crimeData.promptUser(); // prompt user for questions until response 'Q'
				// end seconds interval increment
				
				// print 'thank you' and elapsed seconds
				System.out.print("Thank you for trying the US Crimes Statistics Program.");
				
			} catch (FileNotFoundException e) {
				System.out.println("Cannot run the program without passing a valid file path as an argument. Now exiting...");
				System.exit(1);
			}
		} else { // if no argument provided
			// notify and exit
			System.out.println("No file path provided. Please run the program with the file path for the crime data as an argument (Example: java CrimeTest Crime.csv).");
		}
		
	}
}
