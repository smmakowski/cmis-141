/*
	Filename: HeadPhones.java
	Author: Stephen Makowski
	Date: Novemeber , 2017
	Purpose: Headphones class with fields, constructor, and methods
*/

import java.awt.Color; // import color

public class HeadPhones {
	// class constants
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
 		this.manufacturer = "";
 		this.headPhoneColor = null;
 		this.headPhoneModel = "";
 	}
 	
 	//getter methods for each field
 	public int getVolume() {
 		return this.volume;
 	}
 	
 	public boolean getIsPluggedIn() {
 		return this.pluggedIn;
 	}
 	
 	public String getManufacturer() {
 		return this.manufacturer;
 	}
 	
 	public Color getHeadPhoneColor() {
 		return this.headPhoneColor;
 	}
 	
 	public String getHeadphoneModel() {
 		return this.headPhoneModel;
 	}
 	
 	// setter methods for each field
 	/*public void setVolume(int volume) {
 		I have commented this, and excluded a 'setVolume()'
 		method because it seems like the 'changeVolume()' 
 		method does the same thing.
 		
 		Since we were required to declare
 		three volume constants, and since the constructor
 		sets the volume to the MEDIUM constant, I assume
 		that those are the only options for volume and that
 		changeVolume.
 		
 		
 	} */
 	
 	public void setIsPluggedIn() {
 	
 	}
 	
 	public void setManufacturer() {
 		
 	}
 	
 	public void setHeadPhoneColor() {
 		
 	}
 	
 	public void setHeadPhoneModel() {
 		
 	}
 	
 	// toString Method
 	
 	public String toString() {
 		
 	}
 	
 	public void changeVolume(int volume) {
 		
 	}
}
