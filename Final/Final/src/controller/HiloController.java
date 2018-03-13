package controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import application.Main;
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
	
	Deck deck = new Deck();
	boolean isHigher;
	boolean isWinner;
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
    private Button save;

    @FXML
    private Button Load;

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
		if(count>51) {
			LastCard.setText("You're out of cards");
			Card.setText("You're out of cards");
		}
		else {
		isHigher = true;
		check();
		LastCard.setText(Deck.getCard().get(count - 1).toString());
		Card.setText(Deck.getCard().get(count).toString());
		HiLo.game(isWinner);
		money.setText(Integer.toString(HiLo.anti));
		}
	}

	@FXML
	void CardIsLower(ActionEvent event) {

		count++;
		if(count>51) {
			LastCard.setText("You're out of cards");
			Card.setText("You're out of cards");
		}
		else {
			isHigher = false;
		check();
		LastCard.setText(Deck.getCard().get(count - 1).toString());
		Card.setText(Deck.getCard().get(count).toString());
		HiLo.game(isWinner);
		money.setText(Integer.toString(HiLo.anti));
		}
	}

	@FXML
	void StartGame(ActionEvent event) {
		
		money.setText(Integer.toString(HiLo.anti));
		Card.setText(Deck.getCard().get(0).toString());
	}

	public void check() {
		if (Deck.getCard().get(count).getCardValue() > Deck.getCard().get(count - 1).getCardValue() && isHigher) {
			isWinner = true;
		} else if (Deck.getCard().get(count).getCardValue() < Deck.getCard().get(count - 1).getCardValue() && isHigher) {
			isWinner = false;
		} else if (Deck.getCard().get(count).getCardValue() > Deck.getCard().get(count - 1).getCardValue() && !isHigher) {
			isWinner = false;
		} else if (Deck.getCard().get(count).getCardValue() < Deck.getCard().get(count - 1).getCardValue() && !isHigher) {
			isWinner = true;
		} else {
			isWinner = false;
		}
	}
	 @FXML
	    void SaveGame(ActionEvent event) throws IOException {
		
		 FileOutputStream fos = new FileOutputStream("./hilo.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			oos.writeObject(HiLo.anti);
			oos.close();
			fos.close();
	    }

	    @FXML
	    void LoadGame(ActionEvent event) throws ClassNotFoundException {
	    	try {
	    		
	    		FileInputStream fis = new FileInputStream("./test.txt");
	    		ObjectInputStream ois = new ObjectInputStream(fis);

	    		HiLo.anti = (int) ois.readObject();
	    		ois.close();
	    		fis.close();
	    		}catch(FileNotFoundException e){
	    			System.out.println("No file");
	    		}catch(IOException ioe){
	    			System.out.println("Hit an IOException");
	    		}
	    }
}
