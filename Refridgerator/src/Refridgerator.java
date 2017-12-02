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
			this.isPluggedIn = false;
		} else {
			this.isPluggedIn = true;
		}
	}
	
	public void setTemperature(int temperature) {

	}
	public void checkStatus() {
		
	}
	
	public void getInfo() {
		
	}
	
	public void viewContents() {
		
	}
	
	public void addItem(String item) {
		if (this.isPluggedIn) {
			if (this.storage.size() < this.capacity) {
				this.storage.add(item.toUpperCase());
				System.out.println("You have added '" + item.toUpperCase() + "' to the " +
				this.manufacturer + " " + this.model);
			} else {
				System.out.println("The " + this.manufacturer + " " + this.model +" is full. Please use '.removeItem() to remove items.");
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
