import java.util.ArrayList;

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
	// constructors
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
	
	public void togglePluggedIn() {
		if (this.isPluggedIn) {
			System.out.println("You have unplugged the refridgerator.");
			if (this.storage.size() > 0) {
				System.out.println("You still have items in the refridgerator. You may want to plug it back in.");
			}
			this.isPluggedIn = false;
		} else {
			System.out.println("You have plugged the refridgerator in.");
			this.isPluggedIn = true;
		}
	}
	
	public void setTemperature(int temperature) {
		if (temperature > 0 && temperature <= 10) {
			this.temperatureSetting = temperature;
			System.out.println("The temperature has been set to " + this.temperatureSetting + ".");
		} else {
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
		if(this.isPluggedIn) {
			pluggedIn = "IS";
		} else {
			pluggedIn = "IS NOT";
		}
		System.out.print("The refridgerator " + pluggedIn + " plugged in, and the temperature is set to " + 
		this.temperatureSetting + ".");
	}
	
	public void getInfo() {
		System.out.println("This refridgerator is a " + this.model + " made by " + this.manufacturer + ".");
	}
	
	public void viewContents() {
		System.out.println("There are " + this.storage.size() + " items in the refridgerator out of " + 
		this.capacity + " available spots.");
		System.out.println("The items are...");
		
		for (int i = 0; i < this.storage.size(); i++) {
			System.out.println((i + 1) + ": " + this.storage.get(i));
		}
		System.out.println("~~~ END LIST ~~~");
	}
	
	public void addItem(String item) {
		if (this.isPluggedIn) {
			if (this.storage.size() < this.capacity) {
				this.storage.add(item.toUpperCase());
				System.out.println("You have added '" + item.toUpperCase() + "' to the refridgerator");
			} else {
				System.out.println("The refridgerator is full. Please use '.removeItem(String item) to remove items.");
			}
		} else {
			System.out.println("Please plug refridgerator in before putting in items");
		}
		
	}
	public void removeItem(String item) {
		if (item != null) {
			int searchResult = this.storageIndexOfAllCaps(item);
			if (searchResult != -1) {
				this.storage.remove(searchResult);
				System.out.println("Removed '" + item + "'.");
			} else {
				System.out.println("Cannot remove '" + item + "' because it is not in the refridgerator.");
			}
		}
	}
	
	private int storageIndexOfAllCaps(String item) {
		for (int i = 0; i < this.storage.size(); i++) {
			if (item.toUpperCase().equals(this.storage.get(i).toUpperCase())) {
				return i;
			}
		}
		return -1;
	}
}
