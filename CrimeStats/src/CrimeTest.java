import java.io.*;
//import java.util.Scanner;

public class CrimeTest {
	static int  seconds = 0;
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Crime crimeData = new Crime();

		try {
			// read the file data with Crime class method
			crimeData.readCrimeData("Crime.csv");
			crimeData.promptUser(); // prompt user for questions until response 'Q'
			// end seconds interval increment
			
			// print 'thank you' and elapsed seconds
			System.out.print("Thank you for trying the US Crimes Statistics Program.");
			
		} catch (FileNotFoundException e) {
			System.out.println("Cannot run the program without a valid file. Now exiting...");
			System.exit(1);
		}
	}
}
