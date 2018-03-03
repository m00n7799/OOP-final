package application;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.sun.corba.se.impl.oa.poa.ActiveObjectMap.Key;

import controller.CardGames;
import games.BlackJack;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
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
	private Label dNum1;

	@FXML
	private Label dSuit1;
	
    @FXML
    private Label pot;

    @FXML
    private Button stand;

    @FXML
    private Button hit;
    
    @FXML
    private AnchorPane playerOptionsView;


	public void playBlackJack(ActionEvent event) {
		CardGames.runBlackjack();
	}

	@FXML
	public void playHiLo(ActionEvent event) {
		CardGames.runHiLo();
	}

	@FXML
	public void exit(ActionEvent event) {
		System.exit(0);
	}

	public AnchorPane getPlayer3Board() {
		return player3Board;
	}

	public void setPlayer3Board(AnchorPane player3Board) {
		this.player3Board = player3Board;
	}

	public String getPlayer3Name() {
		return player3Name.getText();
	}

	public void setPlayer3Name(String name) {
		player3Name.setText(name);
	}

	public Label getPlayer3CardTotal() {
		return player3CardTotal;
	}

	public void setPlayer3CardTotal(Label player3CardTotal) {
		this.player3CardTotal = player3CardTotal;
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

	public void setPlayer1Board(AnchorPane player1Board) {
		this.player1Board = player1Board;
	}

	public String getPlayer1Name() {
		return player1Name.getText();
	}

	public void setPlayer1Name(String playerName) {
		player1Name.setText(playerName);
	}

	public Label getPlayer1CardTotal() {
		return player1CardTotal;
	}

	public void setPlayer1CardTotal(Label player1CardTotal) {
		this.player1CardTotal = player1CardTotal;
	}

	public AnchorPane getPlayer2Board() {
		return player2Board;
	}

	public void setPlayer2Board(AnchorPane player2Board) {
		this.player2Board = player2Board;
	}

	public String getPlayer2Name() {
		return player2Name.getText();
	}

	public void setPlayer2Name(String name) {
		player2Name.setText(name);
	}

	public Label getPlayer2CcardTotal() {
		return player2CcardTotal;
	}

	public void setPlayer2CcardTotal(Label player2CcardTotal) {
		this.player2CcardTotal = player2CcardTotal;
	}

	public AnchorPane getDealerBoard() {
		return dealerBoard;
	}

	public void setDealerBoard(AnchorPane dealerBoard) {
		this.dealerBoard = dealerBoard;
	}

	public Label getDealCardTotal() {
		return DealCardTotal;
	}

	public void setDealCardTotal(Label dealCardTotal) {
		DealCardTotal = dealCardTotal;
	}

	@FXML
	void playerNumberEntered(KeyEvent event) {

		String input = enterNumberOfPlayers.getText();
<<<<<<< HEAD

		setPlayer1Name("");
		setPlayer2Name("");
		setPlayer3Name("");

		if (!input.equals("") && event.getCode().equals(KeyCode.ENTER)) {

			int number = Integer.parseInt(input);

			switch (number) {

			case 1:
				enterNumberOfPlayers.setDisable(true);
				enterNumberOfPlayers.setVisible(false);
				player1Board.setDisable(false);
				player1Board.setVisible(true);
				dealerBoard.setDisable(false);
				dealerBoard.setVisible(true);
				
				BlackJack.setPlayers(number);
				setPlayer1Name(BlackJack.getPlayers().get(0).getName());
				
				playerOptionsView.setVisible(true);
				playerOptionsView.setDisable(false);
				
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

				BlackJack.setPlayers(number);
				
				
				playerOptionsView.setVisible(true);
				playerOptionsView.setDisable(false);
				
				setPlayer3Name(BlackJack.getPlayers().get(0).getName());
				setPlayer2Name(BlackJack.getPlayers().get(1).getName());
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

				BlackJack.setPlayers(number);
				setPlayer3Name(BlackJack.getPlayers().get(0).getName());
				setPlayer1Name(BlackJack.getPlayers().get(1).getName());
				setPlayer2Name(BlackJack.getPlayers().get(2).getName());
				
				playerOptionsView.setVisible(true);
				playerOptionsView.setDisable(false);
				
				break;

			default:
				enterNumberOfPlayers.setText("Not Valid");
				break;
			}
=======
		if(!input.equals("")) {
		int number = Integer.parseInt(input);
		


		switch (number) {

		case 1:
			enterNumberOfPlayers.setDisable(true);
			enterNumberOfPlayers.setVisible(false);
			player1Board.setDisable(false);
			player1Board.setVisible(true);
			dealerBoard.setDisable(false);
			dealerBoard.setVisible(true);
			BlackJack.setPlayers(number);
			setPlayer1Name(BlackJack.getPlayers().get(0).getName());
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
			
			BlackJack.setPlayers(number);
			setPlayer3Name(BlackJack.getPlayers().get(0).getName());
			setPlayer2Name(BlackJack.getPlayers().get(1).getName());
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

			
			BlackJack.setPlayers(number);
			setPlayer3Name(BlackJack.getPlayers().get(0).getName());
			setPlayer1Name(BlackJack.getPlayers().get(1).getName());
			setPlayer2Name(BlackJack.getPlayers().get(2).getName());
			break;

		default:
			enterNumberOfPlayers.setText("Not Valid");
			break;
>>>>>>> b93ef8789b2e45108e59085395861323e09bd4eb
		}
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
	
	@FXML
	public void hit(ActionEvent event) {
		System.out.println("hit ME!");
	}
	
	@FXML
	public void stand(ActionEvent event){
		System.out.println("GG Gents, Stand");
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

	}
}