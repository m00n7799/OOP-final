package application;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import controller.CardGames;
import games.BlackJack;
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
import models.Player;

public class Controller implements Initializable {
	
	@FXML
	private TextField enterNumberOfPlayers;

	@FXML
	private AnchorPane player3Board;

	@FXML
	private Label player3Name;

	@FXML
	private Label player3CardTotal;

	@FXML
	private AnchorPane player3Card1;

	@FXML
	private AnchorPane player3Card2;

	@FXML
	private AnchorPane player3Card3;

	@FXML
	private AnchorPane player3Card4;

	@FXML
	private AnchorPane player3Card5;

	@FXML
	private AnchorPane player1Board;

	@FXML
	private Label player1Name;

	@FXML
	private Label player1CardTotal;

	@FXML
	private AnchorPane player2Board;

	@FXML
	private Label player2Name;

	@FXML
	private Label player2CcardTotal;

	@FXML
	private AnchorPane dealerBoard;

	@FXML
	private Label DealCardTotal;

	@FXML
	private void playBlackJack(ActionEvent event) {
		CardGames.runBlackjack();
	}

	@FXML
	private void playHiLo(ActionEvent event) {
		CardGames.runHiLo();
	}

	@FXML
	private void exit(ActionEvent event) {
		System.exit(0);
	}

	public AnchorPane getPlayer3Board() {
		return player3Board;
	}

	public String getPlayer3Name() {
		return player3Name.getText();
	}

	public void setPlayer3Name(String player3Name) {
		this.player3Name.setText(player3Name);
	}

	public String getPlayer3CardTotal() {
		return player3CardTotal.getText();
	}

	public void setPlayer3CardTotal(int handTotal){
		this.player3CardTotal.setText(Integer.toString(handTotal));
	}

	public AnchorPane getPlayer3Card1() {
		return player3Card1;
	}

	public void setPlayer3Card1(AnchorPane player3Card1) {
		this.player3Card1 = player3Card1;
	}

	public AnchorPane getPlayer3Card2() {
		return player3Card2;
	}

	public void setPlayer3Card2(AnchorPane player3Card2) {
		this.player3Card2 = player3Card2;
	}

	public AnchorPane getPlayer3Card3() {
		return player3Card3;
	}

	public void setPlayer3Card3(AnchorPane player3Card3) {
		this.player3Card3 = player3Card3;
	}

	public AnchorPane getPlayer3Card4() {
		return player3Card4;
	}

	public void setPlayer3Card4(AnchorPane player3Card4) {
		this.player3Card4 = player3Card4;
	}

	public AnchorPane getPlayer3Card5() {
		return player3Card5;
	}

	public void setPlayer3Card5(AnchorPane player3Card5) {
		this.player3Card5 = player3Card5;
	}

	public AnchorPane getPlayer1Board() {
		return player1Board;
	}

	public String getPlayer1Name() {
		return player1Name.getText();
	}

	public void setPlayer1Name(String playerName) {
		player1Name.setText(playerName);
	}

	public String getPlayer1CardTotal() {
		return player1CardTotal.getText();
	}

	public void setPlayer1CardTotal(int handValue) {
		this.player1CardTotal.setText(Integer.toString(handValue));
	}

	public AnchorPane getPlayer2Board() {
		return player2Board;
	}

	public String getPlayer2Name() {
		return player2Name.getText();
	}

	public void setPlayer2Name(String player2Name) {
		this.player2Name.setText(player2Name);
	}

	public String getPlayer2CcardTotal() {
		return player2CcardTotal.getText();
	}

	public void setPlayer2CcardTotal(int handValue) {
		this.player2CcardTotal.setText(Integer.toString(handValue));
	}

	public AnchorPane getDealerBoard() {
		return dealerBoard;
	}

	public String getDealCardTotal() {
		return DealCardTotal.getText();
	}

	public void setDealCardTotal(int dealCardTotal) {
		DealCardTotal.setText(Integer.toString(dealCardTotal));
	}

	@FXML
	void playerNumberEntered(KeyEvent event) {
		String input = enterNumberOfPlayers.getText();
		int number = Integer.parseInt(input);
		ArrayList<Player> players = new ArrayList<>();

		switch (number) {

		case 1:
			enterNumberOfPlayers.setDisable(true);
			enterNumberOfPlayers.setVisible(false);
			player1Board.setDisable(false);
			player1Board.setVisible(true);
			dealerBoard.setDisable(false);
			dealerBoard.setVisible(true);
			players.add(new Player("Player 1"));
			BlackJack.setPlayers(players);
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
			players.add(new Player("Player 1"));
			players.add(new Player("Player 2"));
			BlackJack.setPlayers(players);
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

			players.add(new Player("Player 1"));
			players.add(new Player("Player 2"));
			players.add(new Player("Player 3"));

			BlackJack.setPlayers(players);
			break;

		default:
			enterNumberOfPlayers.setText("Not Valid");
			break;
		}
	}

	@FXML
	public void returnMain(ActionEvent event) {

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
