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
<<<<<<< HEAD
	
	@FXML
	private Button Lower;

	@FXML
	private Button Higher;
=======
	int count = 0;
		@FXML
	    private Button Lower;

	    @FXML
	    private Button Higher;

	    @FXML
	    private Button Exit;

	    @FXML
	    private Label Card;
	    @FXML
	    void Enter(ActionEvent event) {
	    	Card.setText(Integer.toString(Deck.getCard().get(0).getCardValue()));
	    }
		@FXML
	    void gotomainMenu(ActionEvent event) {
>>>>>>> 6e99e8546dccc77aa82d482019ff412659d194fd

	@FXML
	private Button Exit;

<<<<<<< HEAD
	@FXML
	private Label Card;

	@FXML
	void gotomainMenu(ActionEvent event) {
=======
	    @FXML
	    void CardIsHigher(ActionEvent event) {
	    	count++;
	    	Card.setText(Integer.toString(Deck.getCard().get(count).getCardValue()));
	    }

	    @FXML
	    void CardIsLower(ActionEvent event) {
	    	count++;
	    	Card.setText(Integer.toString(Deck.getCard().get(count).getCardValue()));
	    }
	    public void check() {
	    
	    }
>>>>>>> 6e99e8546dccc77aa82d482019ff412659d194fd

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
