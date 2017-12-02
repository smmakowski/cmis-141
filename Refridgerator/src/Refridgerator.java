/*
 * Author: Stephen Makowski
 * Filename: Refridgerator.java
 * Date: December 1, 2017
 * Purpose: refriedgerator class with consturctors, fields, and methods
 */
import java.util.ArrayList; // import arrayLIST

public class Refridgerator {
	//class constants
	private final int RECOMMENDED = 7;
	// class fields
	private String manufacturer;
	private String model;
	private boolean isPluggedIn;
	private int capacity;
	private int temperatureSetting;
	private ArrayList<String> storage;
	// constructors: with and without args
	public Refridgerator(String manufacturer, String model, int capacity) {
		this.manufacturer = manufacturer;
		this.model = model;
		this.isPluggedIn = false;
		
		if (capacity < 1) {
			this.capacity = 10;
			System.out.println("Capacity must be greater than 0. Capacity set to 10.");
		} else {
			this.capacity = capacity;
		}
		
		this.temperatureSetting = RECOMMENDED;
		this.storage = new ArrayList<String>();
	}
	
	public Refridgerator() {
		this.manufacturer = null;
		this.model = null;
		this.isPluggedIn = false;
		this.capacity = 10;
		this.temperatureSetting = RECOMMENDED;
		this.storage = new ArrayList<String>();
	}
	// methods
	
	public void togglePluggedIn() { // toggles this.pluggedin 
		if (this.isPluggedIn) { // if aslready pluggedin, unplug
			System.out.println("You have unplugged the refridgerator.");
			if (this.storage.size() > 0) { // print this if there is stuff in fridge
				System.out.println("You still have items in the refridgerator. You may want to plug it back in.");
			}
			this.isPluggedIn = false;
		} else { // plug infridge if not pluggedin already
			System.out.println("You have plugged the refridgerator in.");
			this.isPluggedIn = true;
		}
	}
	
	public void setTemperature(int temperature) {
		if (temperature > 0 && temperature <= 10) { // if temperature is in range..
			this.temperatureSetting = temperature; //set  temperature and notify
			System.out.println("The temperature has been set to " + this.temperatureSetting + ".");
		} else { // else, notify user
			System.out.println(temperature + " is not a valid setting. Temperature remains at " + 
			this.temperatureSetting + ".");
		}
	}
	// no argument version of setTemperature sets to recommended
	public void setTemperature() {
		this.temperatureSetting = this.RECOMMENDED;
	}
	
	public void checkStatus() {
		String pluggedIn;
		if(this.isPluggedIn) { // depening on pluggedIn status, notification is different
			pluggedIn = "IS";
		} else {
			pluggedIn = "IS NOT";
		}
		System.out.print("The refridgerator " + pluggedIn + " plugged in, and the temperature is set to " + 
		this.temperatureSetting + ".\n");
	}
	
	public void getInfo() { // print model and manufacturer
		System.out.println("This refridgerator is a " + this.model + " made by " + this.manufacturer + ".");
	}
	
	public void viewContents() { 
		System.out.println("There are " + this.storage.size() + " items in the refridgerator out of " + 
		this.capacity + " available spots. The items are...");
		// iterate through arrayList and print all items 
		for (int i = 0; i < this.storage.size(); i++) {
			System.out.println((i + 1) + ": " + this.storage.get(i));
		}
		System.out.println("~~~ END LIST ~~~");
	}
	
	public void addItem(String item) {
		if (this.isPluggedIn) { // if pluggin in
			if (this.storage.size() < this.capacity) { // if room left
				this.storage.add(item.toUpperCase()); // add item to fridge
				System.out.println("You have added '" + item.toUpperCase() + "' to the refridgerator");
			} else {// notify full
				System.out.println("The refridgerator is full. Please use '.removeItem(String item) to remove items.");
			}
		} else { // if not plugged in tell user to plug in
			System.out.println("Please plug refridgerator in before putting in items");
		}
		
	}
	
	public void removeItem(String item) {
		int searchResult = this.storageIndexOfAllCaps(item); // serach index
		if (searchResult != -1) { // if found
			this.storage.remove(searchResult); // remove from storage and notify
			System.out.println("Removed '" + item.toUpperCase() + "'.");
		} else { // if not in fridge, notify
			System.out.println("Cannot remove '" + item + "' because it is not in the refridgerator.");
		}
	}
	
	public void removeItem() { // no args to hangdle accidnetal forgetting to pass item
		System.out.println("Removal could not be completed. Please provide an item for removal");
	}
	
	// index of that auto capitalizes 
	private int storageIndexOfAllCaps(String item) {
		// iterate throuhg list
		for (int i = 0; i < this.storage.size(); i++) {
			if (item.toUpperCase().equals(this.storage.get(i).toUpperCase())) { // if in list
				return i; // return index
			}
		}
		return -1; // return -1 if not found
	}
}
