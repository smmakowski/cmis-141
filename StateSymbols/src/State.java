
public class State {
	private String stateName;
	private String stateBird;
	private String stateFlower;
	
	// constructor with arguments
	public State(String name, String bird, String flower) {
		this.stateName = autoTitleCase(name).trim(); // auto Title Case and remove trailing/leading spaces
		this.stateBird = autoTitleCase(bird).trim();
		this.stateFlower = autoTitleCase(flower).trim();
	}
	
	public void printInfo() {
		System.out.println(this.stateName+ ", " + this.stateBird + ", " + this.stateFlower);
	}
	// auto capitalizes first letter of every word
	private static String autoTitleCase(String string) {
		String[] chars = string.split("");
		for (int i = 0; i < chars.length; i++) {
			if (i == 0 || (i > 0 && chars[i - 1].equals(" "))) { // if first character or proceeding space
				chars[i] = chars[i].toUpperCase(); // capitalize
			} else {
				chars[i] = chars[i].toLowerCase(); // de-capitalize
			}
		}
		return String.join("", chars);
	}
}
