/*
  * File: Crime.java
  * Author: Stephen Makowski
  * Date: December 17, 2017
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
			// create fileScanner
			scan = new Scanner(new File(fileName));
			// while there are more lines to parse
			while (scan.hasNextLine()) {
				lineText = scan.nextLine();
				if (lineNum > 0) { // if not the header line
					parseYear(lineText); // parse line with method
				}
				lineNum++; //increment line
			}
		} catch (FileNotFoundException e) { // if exception thrown then exit
			System.err.println("Unable to find file. Please make sure that your file path is correct.");
		} finally { // after scan is done, close scanner, if created
			if (scan != null) {
				scan.close();
			}
		}
	}
	// method to prompt user for information
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
					getPopulationGrowthForAllYears(); // run related method
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
		scan.close();
	}
	// private methods for parsing and caluclation
	
	private void parseYear(String lineText) throws NumberFormatException {
		String[] stats = lineText.split(",");
		try { // attmempt parse and save data from columns
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
		} catch (NumberFormatException e) { // if format exception is thrown, print paragraph notification
			System.out.println("One or more lines in the .csv file that you tried to read is not properly formatted." + 
			"Please make sure that your document begins with a line containing the following headers: " + 
			"'Year,Population,Violent crime,Violent crime rate,Murder and nonnegligent manslaughter," +
			"Murder and nonnegligent manslaughter rate,Rape,Rape rate,Robbery,Robbery rate,Aggravated assault,Aggravated assault rate," +
			"Property crime,Property crime rate ,Burglary,Burglary rate,Larceny-theft,Larceny-theft rate ,Motor vehicle theft,Motor vehicle theft rate'" + 
			"Please also make sure that all subsequent rows use the proper number formats: " +
			"Years and Crime counts (Integer, ex. 1341234), Crime Rates (Double, ex. 1234.09213" +
			"Lastly, please make sure to delineate column data with commas (','), and do not use traling or leading spaces.");
		}
	}
	// method to calculate and print largest population increase for year
	private void getMaxPopulationGrowth() {
		// set max year and max growth to second year, and rate of growth between 1st and second years
		int maxYear = crimeByYear.get(1).getYear(); 
		double maxGrowth = (((double)crimeByYear.get(1).getPopulation() - (double)crimeByYear.get(0).getPopulation()) / (double)crimeByYear.get(1).getPopulation()) * 100.0;
		// iterate through years starting at 3rd year
		for (int i = 2; i < crimeByYear.size(); i++) {
			// calculate rate of growth between current and prvious year
			double yearGrowth = (((double)crimeByYear.get(i).getPopulation() - (double)crimeByYear.get(i - 1).getPopulation()) / (double)crimeByYear.get(i - 1).getPopulation()) * 100.0;
			// current growth is greater than max growth set max to current
			if (yearGrowth > maxGrowth) {
				maxGrowth = yearGrowth;
				maxYear = crimeByYear.get(i).getYear();
			}
		}
		// print max
		System.out.println("The Population Growth was highest during " + (maxYear - 1) + "-" + maxYear);
	}
	private void getPopulationGrowthForAllYears() {
		for (int i = 1; i < crimeByYear.size(); i++) {
			// calculate rate of growth between current and prvious year
			double yearGrowth = (((double)crimeByYear.get(i).getPopulation() - (double)crimeByYear.get(i - 1).getPopulation()) / (double)crimeByYear.get(i - 1).getPopulation()) * 100.0;
			int endYear = crimeByYear.get(i).getYear();
			System.out.println("Population growth for " + (endYear - 1) + "-" + endYear + " is " + yearGrowth + "%.");
		}
	}
	// method to find and print year with highest murder rate
	private void getMaxMurderYear() {
		//set max year and max rate 
		int maxYear = crimeByYear.get(0).getYear();
		double maxHomicideRate = crimeByYear.get(0).getHomicideRate();
		// iterate from second year in list
		for (int i = 1; i < crimeByYear.size(); i++) {
			if (crimeByYear.get(i).getHomicideRate() > maxHomicideRate) { // set maxs if current year is greater than max
				maxYear = crimeByYear.get(i).getYear();
				maxHomicideRate = crimeByYear.get(i).getHomicideRate();
			}
		}
		// print max
		System.out.println("The Murder rate was highest in " + maxYear);
	}
	// method to find and print max year; functionally similar to getMaxMurderYear but switchs > with < 
	private void getMinMurderYear() {
		int minYear = crimeByYear.get(0).getYear();
		double minHomicideRate = crimeByYear.get(0).getHomicideRate();
		
		for (int i = 1; i < crimeByYear.size(); i++) {
			if (crimeByYear.get(i).getHomicideRate() < minHomicideRate) {
				minYear = crimeByYear.get(i).getYear();
				minHomicideRate = crimeByYear.get(i).getHomicideRate();
			}
		}
		
		System.out.println("The Murder rate was lowest in " + minYear);
	}
	// method to find and print max year for robbery; similar to maxMurderYear
	private void getMaxRobberyYear() {
		int maxYear = crimeByYear.get(0).getYear();
		double maxRobberyRate = crimeByYear.get(0).getRobberyRate();
		
		for (int i = 1; i < crimeByYear.size(); i++) {
			if (crimeByYear.get(i).getRobberyRate() > maxRobberyRate) {
				maxYear = crimeByYear.get(i).getYear();
				maxRobberyRate = crimeByYear.get(i).getRobberyRate();
			}
		}
		
		System.out.println("The Robbery rate was highest in " + maxYear);
	}
	// method to find and print min year for robery; functionally similar to getMaxMurderYear but switchs > with < and uses robbery
	private void getMinRobberyYear() {
		int minYear = crimeByYear.get(0).getYear();
		double minRobberyRate = crimeByYear.get(0).getRobberyRate();
		
		for (int i = 1; i < crimeByYear.size(); i++) {
			if (crimeByYear.get(i).getRobberyRate() < minRobberyRate) {
				minYear = crimeByYear.get(i).getYear();
				minRobberyRate = crimeByYear.get(i).getRobberyRate();
			}
		}
		
		System.out.println("The Robbery rate was lowest in " + minYear);
	}
}
