/*
	Filename: HeadPhones.java
	Author: Stephen Makowski
	Date: December 3, 2017
	Purpose: Headphones class with fields, constructor, and methods
*/

import java.awt.Color; // import color

public class HeadPhones {
	// class constants
	final int MUTE = 0; // added mute constant for 0 volume
	final int LOW = 1;
 	final int MEDIUM = 2;
 	final int HIGH = 3;

 	// class fields
 	private int volume;
 	private boolean pluggedIn;
 	private String manufacturer;
 	private Color headPhoneColor;
 	private String headPhoneModel;

 	public HeadPhones() { // no args constructor
 		this.volume = MEDIUM; // init with efault
 		this.pluggedIn = false; // init with defaut
 		// no defaults were provided in prompt for below values
 		// these can be set
		this.manufacturer = null;
		this.headPhoneColor = null;
		this.headPhoneModel = null;
 	}

 	//getter methods for each field
 	public int getVolume() {
 		return this.volume;
 	}

 	public boolean getPluggedIn() {
 		return this.pluggedIn;
 	}

 	public String getManufacturer() {
 		return this.manufacturer;
 	}

 	public Color getHeadPhoneColor() {
 		return this.headPhoneColor;
 	}

 	public String getHeadPhoneModel() {
 		return this.headPhoneModel;
 	}

 	// setter methods for each field
 	public void setVolume(int volume) {
 		if (volume >= 0 && volume <= 3) { // if acceptable set to volume
 			this.volume = volume;
 		} else { // if arg volume out of range notify user
 			System.out.println("ERROR: Cannot set Volume. Volume (" + volume + ") is out range.");
 		}
 	}

 	public void setIsPluggedIn(boolean pluggedIn) {
 		this.pluggedIn = pluggedIn;
 	}

 	public void setManufacturer(String manufacturer) {
 		this.manufacturer = manufacturer;
 	}

 	public void setHeadPhoneColor(Color color) {
 		this.headPhoneColor = color;
 	}

 	public void setHeadPhoneModel(String model) {
 		this.headPhoneModel = model;
 	}

 	// toString Method
 	public String toString() {
 		// return string will all fields for instance
 		return "(volume=" + this.volume + ", pluggedIn=" + this.pluggedIn +
 		", manufacturer=" + this.manufacturer + ", headPhoneColor=" + this.headPhoneColor +
 		", headPhoneModel=" + this.headPhoneModel + ")";
 	}
 	// change/set volume method
 	public void changeVolume(int volume) {
 		// init array of strings for corresponding volume levels
 		String[] modes = new String[]{"MUTE", "LOW", "MEDIUM", "HIGH"};

 		if (volume == this.volume) { // if volume same as current, notify user
 			System.out.println("ERROR: Volume (" + volume +") is same as current Volume Level. Volume will remain at " +
 			this.volume + " (" + modes[this.volume] +").");
 		} else if (volume >= 0 && volume <= 3) { // if different and valid change and notify
 			System.out.println("Volume has been changed from " + volume +
 			" (" + modes[volume] + ") to " + this.volume + " (" + modes[this.volume] + ").");
 			this.volume = volume;
 		} else { // handle arugments that are out of accepted ranges
 			System.out.println("ERROR: Volume (" + volume +") not supported. Volume will remain at " +
 			this.volume + " (" + modes[this.volume] +").");
 		}
 	}
}
