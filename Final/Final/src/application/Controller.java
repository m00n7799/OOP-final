package application;

import java.net.URL;
import java.util.ResourceBundle;

import controller.CardGames;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class Controller implements Initializable{

	@FXML public void playBlackJack(ActionEvent event){
		CardGames.runBlackjack();
	}

	@FXML public void playHiLo(ActionEvent event){
		CardGames.runHiLo();
	}
	@FXML public void exit(ActionEvent event){
		System.exit(0);
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

	}
}
