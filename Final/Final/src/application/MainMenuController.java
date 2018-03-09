package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MainMenuController implements Initializable {

	@FXML
	public void playBlackJack(ActionEvent event) {

		AnchorPane root = new AnchorPane();
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("/BlackJack.fxml"));
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
	public void playHiLo(ActionEvent event) {
		
		AnchorPane root = new AnchorPane();
		FXMLLoader loader = new FXMLLoader();
		
		loader.setLocation(Main.class.getResource("/HiLo.fxml"));
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
	void exit(ActionEvent event) {
		System.exit(0);
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
}
