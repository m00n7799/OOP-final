package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import games.HiLo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import models.Deck;

public class HiloController implements Initializable{

	boolean isHigher;
	boolean isWinner;
	int count = 0;
	Deck deck = new Deck();

	@FXML
	private Button Higher;

	@FXML
	private Button Lower;

	@FXML
	private Label Card;

	@FXML
	private Button start;

	@FXML
	private Label LastCard;

	@FXML
	private Label money;

	@FXML
	private Label promptText;
	
    @FXML
    private Label lastCardPrompt;
    
    @FXML
    private Label isThisPrompt;

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

		count++;
		if (count > 52) {
			count = 1;
		}
		isHigher = true;
		LastCard.setText(deck.getCard().get(count - 1).toString());
		Card.setText(deck.getCard().get(count).toString());
		check();
		HiLo.game(isWinner);
		money.setText(Integer.toString(HiLo.anti));
	}

	@FXML
	void CardIsLower(ActionEvent event) {

		isHigher = false;
		count++;
		if (count > 52) {
			count = 1;
		}
		LastCard.setText(deck.getCard().get(count - 1).toString());
		Card.setText(deck.getCard().get(count).toString());
		check();
		HiLo.game(isWinner);
		money.setText(Integer.toString(HiLo.anti));

	}

	@FXML
	void StartGame(ActionEvent event) {
		
		Higher.setVisible(true);
		Higher.setDisable(false);
		
		Lower.setVisible(true);
		Lower.setDisable(false);
		
		money.setVisible(true);
		money.setDisable(false);
		
		Card.setVisible(true);
		Card.setDisable(false);
		
		promptText.setVisible(true);
		promptText.setDisable(false);
		promptText.setText("");
		
		LastCard.setVisible(true);
		LastCard.setDisable(false);
		LastCard.setText("");
		
		start.setVisible(false);
		start.setDisable(true);
		
		isThisPrompt.setVisible(true);
		isThisPrompt.setDisable(false);
		
		lastCardPrompt.setVisible(true);
		lastCardPrompt.setDisable(false);
		
		money.setText(Integer.toString(HiLo.anti));
		Card.setText(deck.getCard().get(0).toString());
	}

	public void check() {
		
		
		if (deck.getCard().get(count).getCardValue() > deck.getCard().get(count - 1).getCardValue() && isHigher) {
			promptText.setText("Correct");
			isWinner = true;
		} else if (deck.getCard().get(count).getCardValue() < deck.getCard().get(count - 1).getCardValue() && isHigher) {
			promptText.setText("Wrong");
			isWinner = false;
		} else if (deck.getCard().get(count).getCardValue() > deck.getCard().get(count - 1).getCardValue() && !isHigher) {
			promptText.setText("Wrong");
			isWinner = false;
		} else if (deck.getCard().get(count).getCardValue() < deck.getCard().get(count - 1).getCardValue() && !isHigher) {
			promptText.setText("Correct");
			isWinner = true;
		} else {
			promptText.setText("Even, House Wins");
			isWinner = false;
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
       
        assert Higher != null : "fx:id=\"Higher\" was not injected: check your FXML file 'HiLo.fxml'.";
        assert Lower != null : "fx:id=\"Lower\" was not injected: check your FXML file 'HiLo.fxml'.";
        assert Card != null : "fx:id=\"Card\" was not injected: check your FXML file 'HiLo.fxml'.";
        assert start != null : "fx:id=\"start\" was not injected: check your FXML file 'HiLo.fxml'.";
        assert LastCard != null : "fx:id=\"LastCard\" was not injected: check your FXML file 'HiLo.fxml'.";
        assert money != null : "fx:id=\"money\" was not injected: check your FXML file 'HiLo.fxml'.";
        assert promptText != null : "fx:id=\"promptText\" was not injected: check your FXML file 'HiLo.fxml'.";
	}
}
