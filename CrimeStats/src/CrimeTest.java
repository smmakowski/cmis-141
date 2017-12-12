/*
  * File: CrimeTest.java
  * Author: Stephen Makowski
  * Date: December 17, 2017
  * Purpose: Test class designed to use methods from Crime class to read file data and run calculations/results printing
  * Test program takes 1 command line argument (fileName) which is the path where the crime data is located. Also keeps track of start and end time
  * to print elapsed time at end of proper run using the Date object.
*/
import java.io.*;
import java.util.Date;

//import java.util.Scanner;

public class CrimeTest {
	public static void main(String[] args) throws FileNotFoundException, NumberFormatException {
		// get start time for using program
		Date startTime = new Date();
		// if argument provided
		if (args.length > 0) {
			Crime crimeData = new Crime();
			try {
				// read the file data with Crime class method
				crimeData.readCrimeData(args[0]);
				crimeData.promptUser(); // prompt user for questions until response 'Q' using method 

				Date endTime = new Date(); // get end time by instantiating new object
				
				int difference = (int)((endTime.getTime() - startTime.getTime()) / 1000L); // calculate difference using long type and explicitly case as int
				System.out.print("Thank you for trying the US Crimes Statistics Program.");
				System.out.println("Elapsed time in seconds: " + difference);
				
			} catch (FileNotFoundException e) {
				// exit; since read crime data has it's own handling and notification for exception
				System.exit(1);
			} catch (NumberFormatException e) {
				// exit since read crime data has own handling
			 	System.exit(1);
			} // no need for finally since scanner is closed inside of finally block of readFile method in Crime class
		} else { // if no argument provided
			// notify and exit
			System.out.println("No file path argument provided. Please run the program with the file path for the crime data as an argument (ex. java CrimeTest Crime.csv).");
			System.exit(1); // exit 
		}
		
	}
}
