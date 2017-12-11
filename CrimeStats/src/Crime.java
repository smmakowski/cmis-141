import java.io.*;
import java.util.Scanner;

public class Crime {
	
	public void readCrimeData(String fileName) throws FileNotFoundException {
		Scanner scan = null;
		
		try {
			//
			scan = new Scanner(new File(fileName));
			// while there are more lines to parse
			while (scan.hasNextLine()) {
				scan.useDelimiter(",");
				System.out.println(scan.nextLine());
			}
		} catch (FileNotFoundException e) {
			System.err.println("Unable to find file. Please make sure that file is in root directory of eclipse project," +
			"OR if running in command-line, makse sure file is in same directory as .class files");
		} finally {
			if (scan != null) {
			scan.close();
			}
		}
	}
	
	public void promptUser() {
		String selection = ";";
		Scanner scan = new Scanner(System.in);
		
		while (!selection.equals("Q")) {
			System.out.println("Enter the number of the question you want answered. Enter 'Q' to quit the program");
			System.out.println("");
			System.out.println("1. What were the percentages of population growth for each year from 1994-2013?");
			System.out.println("2. What year was the Murder rate the highest?");
			System.out.println("3. What year was the Murder rate the lowest?");
			System.out.println("4. What year was the Robbery rate the highest?");
			System.out.println("5. What year was the Robbery rate the lowest?");
			System.out.println("Q. Quit the program");
			System.out.print("");
			System.out.print("Enter your selection: ");
			selection = scan.nextLine();
			
			switch (selection) {
				case "1":
					
				case "2":
					getMaxMurderYear();
					break;
				case "3":
					getMinMurderYear();
					break;
				case "4":
					getMaxRobberyYear();
					break;
				case "5":
					getMinRobberyYear();
					break;
				case "Q": // do nothing if Q, loop will terminate at end of iteration
					break;
				default:
					System.out.println("Please enter a valid question number or 'Q' to Quit (case-sensitive).");
			}
		}
	}
	public void getPopulationGrowth() {
		
	}
	
	public void getMaxMurderYear() {
		
	}
	
	public void getMinMurderYear() {
		
	}
	
	public void getMaxRobberyYear() {
		
	}
	
	public void getMinRobberyYear() {
		
	}
}
