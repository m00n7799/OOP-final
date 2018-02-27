package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import controller.CardGames;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

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
	
	@FXML public void returnMain(ActionEvent event) {
		
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
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

	}
}
