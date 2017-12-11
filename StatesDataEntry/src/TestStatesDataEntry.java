/*
  * File: TestStatesDataEntry.java
  * Author: Stephen Makowski
  * Date: December 10, 2017
  * Purpose: Test class that creates instances of data entry class and runs entry and print methods
*/
public class TestStatesDataEntry {

	public static void main(String[] args) {
		// instantiate object
		StatesDataEntry dataEntry = new StatesDataEntry();

	
		// gather data and print data for all cases 
		dataEntry.enterData();
		dataEntry.printData();

	}

}
