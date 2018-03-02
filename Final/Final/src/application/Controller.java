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
	private AnchorPane player1Card1;

	@FXML
	private AnchorPane player1Card2;

	@FXML
	private AnchorPane Player1Card3;

	@FXML
	private AnchorPane player1Card4;

	@FXML
	private AnchorPane player1Card5;

	@FXML
	private AnchorPane player2Board;

	@FXML
	private Label player2Name;

	@FXML
	private Label player2CcardTotal;

	@FXML
	private AnchorPane player2Card1;

	@FXML
	private AnchorPane player2Card2;

	@FXML
	private AnchorPane player2Card3;

	@FXML
	private AnchorPane player2Card4;

	@FXML
	private AnchorPane player2Card5;

	@FXML
	private AnchorPane dealerBoard;

	@FXML
	private Label DealCardTotal;

	@FXML
<<<<<<< HEAD
	private AnchorPane dealerCard1;

	@FXML
	private AnchorPane dealerCard2;

	@FXML
	private AnchorPane dealerCard3;

	@FXML
	private AnchorPane dealerCard4;

	@FXML
	private AnchorPane dealerCard5;

	@FXML
	public String getEnterNumberOfPlayers() {
		return enterNumberOfPlayers.getText();
	}

	@FXML
	public Label getPlayer3Name() {
		return player3Name;
	}

	@FXML
	public Label getPlayer3CardTotal() {
		return player3CardTotal;
=======
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
>>>>>>> 4002ccf4230151554fbaff805be625acaa655fe9
	}

	@FXML
	public AnchorPane getPlayer3Card1() {
		return player3Card1;
	}

	@FXML
	public AnchorPane getPlayer3Card2() {
		return player3Card2;
	}

<<<<<<< HEAD
	@FXML
	public AnchorPane getPlayer3Card3() {
		return player3Card3;
	}

	@FXML
	public AnchorPane getPlayer3Card4() {
		return player3Card4;
	}

	@FXML
	public AnchorPane getPlayer3Card5() {
		return player3Card5;
	}

	@FXML
	public Label getPlayer1Name() {
		return player1Name;
=======
	public void setPlayer3Board(AnchorPane player3Board) {
		this.player3Board = player3Board;
	}

	public Label getPlayer3Name() {
		return player3Name;
	}

	public void setPlayer3Name(Label player3Name) {
		this.player3Name = player3Name;
	}

	public Label getPlayer3CardTotal() {
		return player3CardTotal;
	}

	public void setPlayer3CardTotal(Label player3CardTotal) {
		this.player3CardTotal = player3CardTotal;
>>>>>>> 4002ccf4230151554fbaff805be625acaa655fe9
	}

	@FXML
	public Label getPlayer1CardTotal() {
		return player1CardTotal;
	}

	@FXML
	public AnchorPane getPlayer1Card1() {
		return player1Card1;
	}

	@FXML
	public AnchorPane getPlayer1Card2() {
		return player1Card2;
	}

	@FXML
	public AnchorPane getPlayer1Card3() {
		return Player1Card3;
	}

	@FXML
	public AnchorPane getPlayer1Card4() {
		return player1Card4;
	}

	@FXML
	public AnchorPane getPlayer1Card5() {
		return player1Card5;
	}

	@FXML
	public Label getPlayer2Name() {
		return player2Name;
	}

	@FXML
	public Label getPlayer2CcardTotal() {
		return player2CcardTotal;
	}

	@FXML
	public AnchorPane getPlayer2Card1() {
		return player2Card1;
	}

	@FXML
	public AnchorPane getPlayer2Card2() {
		return player2Card2;
	}

	@FXML
	public AnchorPane getPlayer2Card3() {
		return player2Card3;
	}

<<<<<<< HEAD
	@FXML
	public AnchorPane getPlayer2Card4() {
		return player2Card4;
	}

	@FXML
	public AnchorPane getPlayer2Card5() {
		return player2Card5;
	}

	@FXML
	public Label getDealCardTotal() {
		return DealCardTotal;
	}

	@FXML
	public AnchorPane getDealerCard1() {
		return dealerCard1;
	}

	@FXML
	public AnchorPane getDealerCard2() {
		return dealerCard2;
	}

	@FXML
	public AnchorPane getDealerCard3() {
		return dealerCard3;
	}

	@FXML
	public AnchorPane getDealerCard4() {
		return dealerCard4;
	}

	@FXML
	public AnchorPane getDealerCard5() {
		return dealerCard5;
	}

	public void setEnterNumberOfPlayers(String enterNumberOfPlayers) {
		this.enterNumberOfPlayers.setText(enterNumberOfPlayers);
	}

	public void setPlayer3Name(Label player3Name) {
		this.player3Name = player3Name;
	}

	public void setPlayer3CardTotal(Label player3CardTotal) {
		this.player3CardTotal = player3CardTotal;
	}

	public void setPlayer3Card1(AnchorPane player3Card1) {
		this.player3Card1 = player3Card1;
	}

	public void setPlayer3Card2(AnchorPane player3Card2) {
		this.player3Card2 = player3Card2;
	}

	public void setPlayer3Card3(AnchorPane player3Card3) {
		this.player3Card3 = player3Card3;
	}

	public void setPlayer3Card4(AnchorPane player3Card4) {
		this.player3Card4 = player3Card4;
	}

	public void setPlayer3Card5(AnchorPane player3Card5) {
		this.player3Card5 = player3Card5;
=======
	public void setPlayer1Board(AnchorPane player1Board) {
		this.player1Board = player1Board;
	}

	public String getPlayer1Name() {
		return player1Name.getText();
>>>>>>> 4002ccf4230151554fbaff805be625acaa655fe9
	}

	public void setPlayer1Name(String playerName) {
		player1Name.setText(playerName);
	}

<<<<<<< HEAD
	public void setPlayer1CardTotal(Label player1CardTotal) {
		this.player1CardTotal = player1CardTotal;
	}

	public void setPlayer1Card1(AnchorPane player1Card1) {
		this.player1Card1 = player1Card1;
=======
	public Label getPlayer1CardTotal() {
		return player1CardTotal;
	}

	public void setPlayer1CardTotal(Label player1CardTotal) {
		this.player1CardTotal = player1CardTotal;
>>>>>>> 4002ccf4230151554fbaff805be625acaa655fe9
	}

	public void setPlayer1Card2(AnchorPane player1Card2) {
		this.player1Card2 = player1Card2;
	}

<<<<<<< HEAD
	public void setPlayer1Card3(AnchorPane player1Card3) {
		Player1Card3 = player1Card3;
	}

	public void setPlayer1Card4(AnchorPane player1Card4) {
		this.player1Card4 = player1Card4;
	}

	public void setPlayer1Card5(AnchorPane player1Card5) {
		this.player1Card5 = player1Card5;
	}


	public void setPlayer2Name(Label player2Name) {
		this.player2Name = player2Name;
=======
	public void setPlayer2Board(AnchorPane player2Board) {
		this.player2Board = player2Board;
	}

	public Label getPlayer2Name() {
		return player2Name;
	}

	public void setPlayer2Name(Label player2Name) {
		this.player2Name = player2Name;
	}

	public Label getPlayer2CcardTotal() {
		return player2CcardTotal;
>>>>>>> 4002ccf4230151554fbaff805be625acaa655fe9
	}

	public void setPlayer2CcardTotal(Label player2CcardTotal) {
		this.player2CcardTotal = player2CcardTotal;
<<<<<<< HEAD
	}

	public void setPlayer2Card1(AnchorPane player2Card1) {
		this.player2Card1 = player2Card1;
	}

	public void setPlayer2Card2(AnchorPane player2Card2) {
		this.player2Card2 = player2Card2;
	}

	
	public void setPlayer2Card3(AnchorPane player2Card3) {
		this.player2Card3 = player2Card3;
	}

	
	public void setPlayer2Card4(AnchorPane player2Card4) {
		this.player2Card4 = player2Card4;
	}

	
	public void setPlayer2Card5(AnchorPane player2Card5) {
		this.player2Card5 = player2Card5;
	}

	
	public void setDealCardTotal(Label dealCardTotal) {
		DealCardTotal = dealCardTotal;
	}

	
	public void setDealerCard1(AnchorPane dealerCard1) {
		this.dealerCard1 = dealerCard1;
=======
>>>>>>> 4002ccf4230151554fbaff805be625acaa655fe9
	}

	
	public void setDealerCard2(AnchorPane dealerCard2) {
		this.dealerCard2 = dealerCard2;
	}

	
	public void setDealerCard3(AnchorPane dealerCard3) {
		this.dealerCard3 = dealerCard3;
	}

<<<<<<< HEAD
	
	public void setDealerCard4(AnchorPane dealerCard4) {
		this.dealerCard4 = dealerCard4;
	}

	
	public void setDealerCard5(AnchorPane dealerCard5) {
		this.dealerCard5 = dealerCard5;
=======
	public void setDealerBoard(AnchorPane dealerBoard) {
		this.dealerBoard = dealerBoard;
	}

	public Label getDealCardTotal() {
		return DealCardTotal;
	}

	public void setDealCardTotal(Label dealCardTotal) {
		DealCardTotal = dealCardTotal;
>>>>>>> 4002ccf4230151554fbaff805be625acaa655fe9
	}

	
	@FXML
	void playerNumberEntered(KeyEvent event) {
		
		String input = enterNumberOfPlayers.getText();
<<<<<<< HEAD
		if (!input.equals("")) {

			int number = Integer.parseInt(input);
			ArrayList<Player> players = new ArrayList<>();

			switch (number) {

			case 1:
				BlackJack jack = new BlackJack();
				enterNumberOfPlayers.setDisable(true);
				enterNumberOfPlayers.setVisible(false);
				player1Board.setDisable(false);
				player1Board.setVisible(true);
				dealerBoard.setDisable(false);
				dealerBoard.setVisible(true);

//				players.add(new Player("P1"));
//				setPlayer1Name(players.get(0).getName());
				jack.setPlayers(players);
//				setPlayer1Name("p1");
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

				players.add(new Player("P1"));
				players.add(new Player("P2"));

				setPlayer1Name(players.get(0).getName());
//				setPlayer2Name(players.get(1).getName());

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

				players.add(new Player("P1"));
				players.add(new Player("P2"));
				players.add(new Player("P3"));

//				setPlayer1Name(players.get(0).getName());
//				setPlayer2Name(players.get(1).getName());
//				setPlayer3Name(players.get(2).getName());

				break;

			default:
				enterNumberOfPlayers.setText("Not Valid");
				break;
			}
=======
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
			break;

		default:
			enterNumberOfPlayers.setText("Not Valid");
			break;
>>>>>>> 4002ccf4230151554fbaff805be625acaa655fe9
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

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

	}
}
