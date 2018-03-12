package models;

public class Dealer extends Player {

	static String name = "Dealer";

	public Dealer() {
		super(name);
	}

	public boolean isDrawing() {
		if (this.getHandValue() <= 17) {
			return true;
		} else {
			return false;
		}
	}
}
