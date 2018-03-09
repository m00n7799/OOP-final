package application;

import java.io.IOException;

import games.HiLo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import models.Deck;

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
	private Button Exit;
	
    @FXML
    private Label LastCard;

	@FXML
	private Label Card;
	
    @FXML
    private Label money;
	

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
		LastCard.setText(Integer.toString(Deck.getCard().get(count-1).getCardValue()));
		Card.setText(Integer.toString(Deck.getCard().get(count).getCardValue()));
		hl.game(check());
		money.setText(Integer.toString(HiLo.anti));
	}

	@FXML
	void CardIsLower(ActionEvent event) {
		
		isHigher = false;
		count++;
		LastCard.setText(Integer.toString(Deck.getCard().get(count-1).getCardValue()));
		Card.setText(Integer.toString(Deck.getCard().get(count).getCardValue()));
		hl.game(check());
		money.setText(Integer.toString(HiLo.anti));
		
	}
	 @FXML
	    void StartGame(ActionEvent event) {
		 money.setText(Integer.toString(HiLo.anti));
		 Card.setText(Integer.toString(Deck.getCard().get(0).getCardValue()));
	    }

	public boolean check() {
		if(Deck.getCard().get(count).getCardValue() > Deck.getCard().get(count - 1).getCardValue() && isHigher) {
			return true;
		}else if(Deck.getCard().get(count).getCardValue() < Deck.getCard().get(count - 1).getCardValue() && isHigher){
			return false;
		}else if(Deck.getCard().get(count).getCardValue() > Deck.getCard().get(count - 1).getCardValue() && !isHigher) {
			return false;
		}else if(Deck.getCard().get(count).getCardValue() < Deck.getCard().get(count - 1).getCardValue() && !isHigher) {
			return true;
		}else {
			return false;
		}
	}
}
