/**
  * File: Player.java
  * Author: Stephen Makowski
  * Date: November 17, 2017
  * Purpose: The Pokemon class. This class allow for the construction of Player
  * instances and includes methods related to the class for setting and getting fields, as well as
  * making calculations for damage
*/
public class Player {
	// private fields
	private String name;
	private int potions;
	private Pokemon pokemon;
	//constructor
	public Player() {
		name = "";
		potions = 3;
		pokemon = null;
	}
	// get methods
	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public int getPotions() {
		return this.potions;
	}
	//use method that decreases ption count
	public void usePotion() {
		this.potions--;
	}
}
