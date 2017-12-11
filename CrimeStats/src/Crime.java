/*
  * File: Crime.java
  * Author: Stephen Makowski
  * Date: December 10, 2017
  * Purpose: Crime class to read,parse, and store data from crime files, and perform calculations involving data
  * also includes methods to allow user to view results of calculations
*/
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Crime {
	// Arraylist for year data using YearData class
	private ArrayList<YearData> crimeByYear = new ArrayList<YearData>();
	
	// method to read, parse, and fill years array with data from .csv file
	public void readCrimeData(String fileName) throws FileNotFoundException {
		Scanner scan = null;
		int lineNum = 0;
		String lineText = "";
		
		try {
			//
			scan = new Scanner(new File(fileName));
			// while there are more lines to parse
			while (scan.hasNextLine()) {
				lineText = scan.nextLine();
				if (lineNum > 0) { // if not the header line
					parseYear(lineText); // parse line with method
				}
				lineNum++; //increment line
			}
		} catch (FileNotFoundException e) {
			System.err.println("Unable to find file. Please make sure that your file path is correct.");
		} finally { // after scan is done, close scanner
			if (scan != null) {
				scan.close();
			}
		}
	}
	// method to prompt user for informatio 
	public void promptUser() {
		String selection = "";
		Scanner scan = new Scanner(System.in);
		// while response if not 'Q' for quit
		while (!selection.equals("Q")) {
			// print options
			System.out.println("Enter the number of the question you want answered. Enter 'Q' to quit the program");
			System.out.println("");
			System.out.println("1. What were the percentages of population growth for each year from 1994-2013?");
			System.out.println("2. What year was the Murder rate the highest?");
			System.out.println("3. What year was the Murder rate the lowest?");
			System.out.println("4. What year was the Robbery rate the highest?");
			System.out.println("5. What year was the Robbery rate the lowest?");
			System.out.println("Q. Quit the program");
			System.out.print("");
			// prompt for choice
			System.out.print("Enter your selection: ");
			selection = scan.nextLine();
			// swtich for selection 
			switch (selection) {
				case "1": // case for question number
					getMaxPopulationGrowth(); // run related method
					break;
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
				default: // handle invalid responses
					System.out.println("Please enter a valid question number or 'Q' to Quit (case-sensitive).");
			}
		}
	}
	
	public void parseYear(String lineText) throws NumberFormatException {
		String[] stats = lineText.split(",");
		try {
			// parse and save data from columns
			int y = Integer.parseInt(stats[0]);
			int pop = Integer.parseInt(stats[1]);
			int v = Integer.parseInt(stats[2]);
			double vr = Double.parseDouble(stats[3]);
			int h = Integer.parseInt(stats[4]);
			double hr = Double.parseDouble(stats[5]);
			int r =  Integer.parseInt(stats[6]);
			double rr =  Double.parseDouble(stats[7]);	
			int ro = Integer.parseInt(stats[8]);
			double ror = Double.parseDouble(stats[9]);
			int a = Integer.parseInt(stats[10]);
			double ar = Double.parseDouble(stats[11]);
			int p = Integer.parseInt(stats[12]);
			double pr = Double.parseDouble(stats[13]);
			int b = Integer.parseInt(stats[14]);
			double br = Double.parseDouble(stats[15]);
			int l = Integer.parseInt(stats[16]);
			double lr = Double.parseDouble(stats[17]);
			int m = Integer.parseInt(stats[18]);
			double mr = Double.parseDouble(stats[19]);
			// create new Year object with parsed data
			YearData year = new YearData(y, pop, v, vr, h, hr, r, rr, ro, ror, a, ar, p, pr, b, br, l, lr, m, mr);
			// add year to ArrayList
			crimeByYear.add(year);
		} catch (NumberFormatException e) {
			
		}
	}
	// method to calculate and print largest population increase for year
	public void getMaxPopulationGrowth() {
//		for (int i = 0; i < crimeByYear.size(); i++) {
//			System.out.println(crimeByYear.get(i).year);
//			System.out.println(crimeByYear.get(i).population);
//			System.out.println(crimeByYear.get(i).homicideRate);
//			System.out.println(crimeByYear.get(i).robberyRate);
//			
//		}
		int maxYear = crimeByYear.get(1).year;
		double maxGrowth = (((double)crimeByYear.get(1).population - (double)crimeByYear.get(0).population) / (double)crimeByYear.get(1).population) * 100.0;
		
		for (int i = 1; i < crimeByYear.size(); i++) {
			double yearGrowth = (((double)crimeByYear.get(i).population - (double)crimeByYear.get(i - 1).population) / (double)crimeByYear.get(i).population) * 100.0;
			
			if (yearGrowth > maxGrowth) {
				maxGrowth = yearGrowth;
				maxYear = crimeByYear.get(i).year;
			}
		}
		
		System.out.println("The Population Growth was highest during " + (maxYear - 1) + "-" + maxYear);
	}
	
	public void getMaxMurderYear() {
		int maxYear = crimeByYear.get(0).year;
		double maxHomicideRate = crimeByYear.get(0).homicideRate;
		// iterate from second year in list
		for (int i = 1; i < crimeByYear.size(); i++) {
			if (crimeByYear.get(i).homicideRate > maxHomicideRate) {
				maxYear = crimeByYear.get(i).year;
				maxHomicideRate = crimeByYear.get(i).homicideRate;
			}
		}
		
		System.out.println("The Murder rate was highest in " + maxYear);
	}
	
	public void getMinMurderYear() {
		int minYear = crimeByYear.get(0).year;
		double minHomicideRate = crimeByYear.get(0).homicideRate;
		// iterate from second year in list
		for (int i = 1; i < crimeByYear.size(); i++) {
			if (crimeByYear.get(i).homicideRate < minHomicideRate) {
				minYear = crimeByYear.get(i).year;
				minHomicideRate = crimeByYear.get(i).homicideRate;
			}
		}
		
		System.out.println("The Murder rate was lowest in " + minYear);
	}
	
	public void getMaxRobberyYear() {
		int maxYear = crimeByYear.get(0).year;
		double maxRobberyRate = crimeByYear.get(0).robberyRate;
		// iterate from second year in list
		for (int i = 1; i < crimeByYear.size(); i++) {
			if (crimeByYear.get(i).robberyRate > maxRobberyRate) {
				maxYear = crimeByYear.get(i).year;
				maxRobberyRate = crimeByYear.get(i).robberyRate;
			}
		}
		
		System.out.println("The Robbery rate was highest in " + maxYear);
	}
	
	public void getMinRobberyYear() {
		int minYear = crimeByYear.get(0).year;
		double minRobberyRate = crimeByYear.get(0).robberyRate;
		// iterate from second year in list
		for (int i = 1; i < crimeByYear.size(); i++) {
			if (crimeByYear.get(i).robberyRate < minRobberyRate) {
				minYear = crimeByYear.get(i).year;
				minRobberyRate = crimeByYear.get(i).robberyRate;
			}
		}
		
		System.out.println("The Robbery rate was lowest in " + minYear);
	}
}
