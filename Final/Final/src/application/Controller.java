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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
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
	
    @FXML
    public Label numberLabel;
    
    @FXML
    private TextField enterNumberOfPlayers;
    
    @FXML
    private AnchorPane player3Board;

    @FXML
    private AnchorPane dealerBoard;

    @FXML
    private AnchorPane player2Board;

    @FXML
    private AnchorPane player1Board;
    
	@FXML 
    void playerNumberEntered(KeyEvent event) {
		String input = enterNumberOfPlayers.getText();
		int number = Integer.parseInt(input);
		
		switch(number) {
		case 1:
			enterNumberOfPlayers.setDisable(true);
			enterNumberOfPlayers.setVisible(false);
			player1Board.setDisable(false);
			player1Board.setVisible(true);
			dealerBoard.setDisable(false);
			dealerBoard.setVisible(true);
			break;
		case 2:
			enterNumberOfPlayers.setDisable(true);
			enterNumberOfPlayers.setVisible(false);
			player2Board.setVisible(true);
			player2Board.setDisable(false);
			player3Board.setVisible(true);
			player3Board.setDisable(false);
			dealerBoard.setDisable(false);
			dealerBoard.setVisible(true);
			break;
		case 3:
			enterNumberOfPlayers.setDisable(true);
			enterNumberOfPlayers.setVisible(false);
			player1Board.setDisable(false);
			player1Board.setVisible(true);
			player2Board.setVisible(true);
			player2Board.setDisable(false);
			player3Board.setVisible(true);
			player3Board.setDisable(false);
			dealerBoard.setDisable(false);
			dealerBoard.setVisible(true);
			break;
		default:
			enterNumberOfPlayers.setText("Not Valid");
			break;
		}
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
