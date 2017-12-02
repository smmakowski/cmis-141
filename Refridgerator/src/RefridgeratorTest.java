
public class RefridgeratorTest {

	public static void main(String[] args) {
		Refridgerator fridge = new Refridgerator("General Electric", "Type R", 5);
		
		fridge.getInfo();
		fridge.setTemperature(-190);
		fridge.setTemperature(8);
		fridge.addItem("Cheese Burger");
		fridge.togglePluggedIn();
		fridge.addItem("Pizza");
		fridge.addItem("Bacon");
		fridge.addItem("Mountain Dew");
		fridge.addItem("Apples");
		fridge.addItem("Lunchables");
		fridge.addItem("Cheese Burger");
		fridge.removeItem("MountainDew");
		fridge.removeItem("mountain dew");
		fridge.addItem("Cheese Burger");
		fridge.togglePluggedIn();
		fridge.checkStatus();
		fridge.viewContents();
	}

}
