public class Player {
	private String name;
	private int potions;
	private Pokemon pokemon;

	public Player() {
		name = "";
		potions = 3;
		pokemon = null;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public int getPotions() {
		return this.potions;
	}

	public void usePotion() {
		this.potions--;
	}
}
