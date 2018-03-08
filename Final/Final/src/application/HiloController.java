package application;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
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

	boolean isHigher;

	int count = 0;
	
	@FXML
	private Button Lower;
	
	@FXML
    private Button start;
	
	@FXML
	private Button Higher;

	@FXML
	void Enter(KeyEvent event) {
		Card.setText(Integer.toString(deck.getCard().get(0).getCardValue()));
	}

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
		} catch (IOException e){
			e.printStackTrace();
		}

		Scene scene = new Scene(root);
		Stage secondStage = Main.getStage();
		secondStage.setScene(scene);
		secondStage.show();
	}

	@FXML
	void CardIsHigher(ActionEvent event) {
		count++;
		isHigher = true;
		Card.setText(Integer.toString(Deck.getCard().get(count).getCardValue()));
		check();
	}

	@FXML
	void CardIsLower(ActionEvent event) {
		
		isHigher = false;
		count++;
		Card.setText(Integer.toString(Deck.getCard().get(count).getCardValue()));
		check();
		
	}
	 @FXML
	    void StartGame(ActionEvent event) {
		 Card.setText(Integer.toString(Deck.getCard().get(0).getCardValue()));
	    }

	public void check() {
		
		if(Deck.getCard().get(count).getCardValue() > Deck.getCard().get(count - 1).getCardValue() && isHigher) {
			System.out.println("Winner");
		}else if(Deck.getCard().get(count).getCardValue() < Deck.getCard().get(count - 1).getCardValue() && isHigher){
			System.out.println("Loser");
		}else if(Deck.getCard().get(count).getCardValue() > Deck.getCard().get(count - 1).getCardValue() && !isHigher) {
			System.out.println("Loser");
		}else if(Deck.getCard().get(count).getCardValue() < Deck.getCard().get(count - 1).getCardValue() && !isHigher) {
			System.out.println("winner");
		}else {
			System.out.println("tie");
		}
	}
}
