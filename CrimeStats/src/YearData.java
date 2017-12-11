/*
  * File: YearData.java
  * Author: Stephen Makowski
  * Date: December 10, 2017
  * Purpose: Year class to hold multi-type crime data for one year. All fields are public to eliminate need for
  * getter methods
*/
public class YearData {
	int year;
	int population;
	int violent;
	double violentRate;
	int homicide;
	double homicideRate;
	int rape;
	double rapeRate;
	int robbery;
	double robberyRate;
	int assault;
	double assaultRate;
	int property;
	double propertyRate;
	int burglary;
	double burglaryRate;
	int larceny;
	double larcenyRate;
	int motor;
	double motorRate;
	
	
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
}
