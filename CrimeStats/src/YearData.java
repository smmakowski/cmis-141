/*
  * File: YearData.java
  * Author: Stephen Makowski
  * Date: December 17, 2017
  * Purpose: Year class to hold multi-type crime data for one year. All fields are public to eliminate need for
  * getter methods
*/
public class YearData {
	// fields for holding data; public to avoid need for getter methods (not all were used in calcualtions)
	private int year;
	private int population;
	private int violent;
	private double violentRate;
	private int homicide;
	private double homicideRate;
	private int rape;
	private double rapeRate;
	private int robbery;
	private double robberyRate;
	private int assault;
	private double assaultRate;
	private int property;
	private double propertyRate;
	private int burglary;
	private double burglaryRate;
	private int larceny;
	private double larcenyRate;
	private int motor;
	private double motorRate;
	
	// constructor
	public YearData(int y, int pop, int v, double vr, int h, double hr, int r, double rr, 
	int ro, double ror, int a, double ar, int p, double pr, int b, double br, int l, double lr, int m, double mr) {
		year = y;
		population = pop;
		violent = v;
		violentRate = vr;
		homicide = h;
		homicideRate = hr;
		rape = r;
		rapeRate = rr;
		robbery = ro;
		robberyRate = ror;
		assault = a;
		assaultRate = ar;
		property = p;
		propertyRate = pr;
		burglary = b;
		burglaryRate = br;
		larceny = l;
		larcenyRate = lr;
		motor = m;
		motorRate = mr;
	}
	
	// getter methods for data pertinent to required calcualtions in Crime.java
	
	public int getYear() {
		return this.year;
	}
	
	public double getPopulation() {
		return this.population;
	}
	public int getHomicide() {
		return this.homicide;
	}
	
	public double getHomicideRate() {
		return this.homicideRate;
	}
	
	public int getRobbery() {
		return this.robbery;
	}
	
	public double getRobberyRate() {
		return this.robberyRate;
	}
}
