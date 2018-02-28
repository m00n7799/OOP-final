package models;

import java.util.ArrayList;

import javafx.scene.image.Image;

public class CardSuit {
	static ArrayList<Image> suits = new ArrayList<Image>();

	public static void suit() {
		suits.add(new Image("club.png"));
		suits.add(new Image("diamond.png"));
		suits.add(new Image("Hearts.jpg"));
		suits.add(new Image("spade.png"));
	}
}
