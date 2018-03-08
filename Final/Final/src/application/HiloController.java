package application;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import models.Deck;

import java.io.IOException;

import games.HiLo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

public class HiloController {
	
	HiLo hl = new HiLo();
	Deck deck = new Deck();
	
	boolean bool = false;
	
	@FXML
	private Button Lower;

	@FXML
	private Button Higher;

	@FXML
	private Button Exit;

	@FXML
	private Label Card;

	@FXML
	void gotomainMenu(ActionEvent event) {

		AnchorPane root = new AnchorPane();
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("/MainMenu.fxml"));
		
		try {
			root = loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Scene scene = new Scene(root);
		Stage secondStage = Main.getStage();
		secondStage.setScene(scene);
		secondStage.show();
	}

	@FXML
	void CardIsHigher(ActionEvent event) {
		
		Deck deck = new Deck();
		Card.setText(Integer.toString(deck.getCard().get(0).getCardValue()));
	}

	@FXML
	void CardIsLower(ActionEvent event) {

	}

	public void check() {

	}
}
