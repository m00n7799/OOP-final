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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import models.Deck;
import models.Human;

public class Controller implements Initializable {

	private ArrayList<Human> players = new ArrayList<>();
	private double pool = 0;
	private int playerID = 0;

	@FXML
	void playerNumberEntered(KeyEvent event) {

		String input = enterNumberOfPlayers.getText();

		if (!input.equals("") && event.getCode().equals(KeyCode.ENTER)) {

			int number = Integer.parseInt(input);

			switch (number) {

			case 1:

				clearAll();

				enterNumberOfPlayers.setDisable(true);
				enterNumberOfPlayers.setVisible(false);
				
				player1Board.setDisable(false);
				player1Board.setVisible(true);
				// dealerBoard.setDisable(false);
				// dealerBoard.setVisible(true);

				BlackJack.startNewGame(number);
				players = BlackJack.getPlayers();

				player1Name.setText(BlackJack.getPlayers().get(playerID).getName());

				playerOptionsView.setVisible(true);
				playerOptionsView.setDisable(false);

				setPlayer1(0);

				promptText.setText(players.get(playerID).getName() + " Hit Or Stand?");

				break;

			case 2:

				clearAll();

				enterNumberOfPlayers.setDisable(true);
				enterNumberOfPlayers.setVisible(false);
				player2Board.setVisible(true);
				player2Board.setDisable(false);
				player3Board.setVisible(true);
				player3Board.setDisable(false);
				// dealerBoard.setDisable(false);
				// dealerBoard.setVisible(true);

				BlackJack.startNewGame(number);

				players = BlackJack.getPlayers();

				playerOptionsView.setVisible(true);
				playerOptionsView.setDisable(false);

				player3Name.setText(players.get(0).getName());
				player2Name.setText(players.get(1).getName());

				setPlayer3();
				setPlayer2(1);
				promptText.setText(players.get(playerID).getName() + " Hit Or Stand?");

				break;

			case 3:

				clearAll();

				enterNumberOfPlayers.setDisable(true);
				enterNumberOfPlayers.setVisible(false);
				// dealerBoard.setDisable(false);
				// dealerBoard.setVisible(true);
				
				player3Board.setVisible(true);
				player3Board.setDisable(false);
				player1Board.setDisable(false);
				player1Board.setVisible(true);
				player2Board.setVisible(true);
				player2Board.setDisable(false);

				BlackJack.startNewGame(number);

				players = BlackJack.getPlayers();

				player3Name.setText(players.get(0).getName());
				player1Name.setText(players.get(1).getName());
				player2Name.setText(players.get(2).getName());

				playerOptionsView.setVisible(true);
				playerOptionsView.setDisable(false);

				setPlayer3();
				setPlayer1(1);
				setPlayer2(2);

				promptText.setText(players.get(playerID).getName() + " Hit Or Stand?");

				break;

			default:
				enterNumberOfPlayers.setText("Not Valid");
				break;
			}
		}
	}

	@FXML
	private void returnMain(ActionEvent event) {

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
	private void doubleDown(ActionEvent event) {

		Deck.nextCard(players.get(playerID), true);

		if (players.size() == 1) {
			setPlayer1(playerID);

		} else if (players.size() == 2) {

			if (playerID == 0) {
				setPlayer3();
			} else {
				setPlayer2(playerID);
			}
		} else if (players.size() == 3) {
			if (playerID == 0) {
				setPlayer3();
			} else if (playerID == 1) {
				setPlayer1(playerID);
			} else {
				setPlayer2(playerID);
			}
		}

		if (players.get(playerID).isBust()) {
			if ((playerID + 1) >= players.size()) {
				promptText.setText("Who is the Winner? The House");
			} else {
				promptText.setText(players.get(playerID).getName() + " Has Bust, " + players.get(playerID + 1).getName()
						+ " is Up");
			}
			passTurn();
		} else if (players.get(playerID).getHand().size() == 5) {
			if ((playerID + 1) >= players.size()) {
				promptText.setText("Who is the winner");
			} else {
				promptText.setText(players.get(playerID).getName() + " reached 5 Card Limit "
						+ players.get(playerID + 1).getName() + " is Up");
			}
			passTurn();
		}
	}

	@FXML
	private void hit(ActionEvent event) {

		Deck.nextCard(players.get(playerID), false);

		if (players.size() == 1) {
			setPlayer1(playerID);

		} else if (players.size() == 2) {

			if (playerID == 0) {
				setPlayer3();
			} else {
				setPlayer2(playerID);
			}
		} else if (players.size() == 3) {
			if (playerID == 0) {
				setPlayer3();
			} else if (playerID == 1) {
				setPlayer1(playerID);
			} else {
				setPlayer2(playerID);
			}
		}

		if (players.get(playerID).isBust()) {
			if (!((playerID + 1) >= players.size())) {
				promptText.setText(players.get(playerID).getName() + " Has Bust, " + players.get(playerID + 1).getName()
						+ " is Up");
			}
			passTurn();
		} else if (players.get(playerID).getHand().size() == 5) {
			if (!((playerID + 1) >= players.size())) {
				promptText.setText(players.get(playerID).getName() + " reached 5 Card Limit "
						+ players.get(playerID + 1).getName() + " is Up");
			}
			passTurn();
		}
	}

	@FXML
	private void newRound(ActionEvent event) {

		playerID = 0;
		BlackJack.startNewRound();

		hit.setDisable(false);
		stand.setDisable(false);

		if (players.size() == 1) {

			setPlayer1(0);

		} else if (players.size() == 2) {

			setPlayer3();
			setPlayer2(1);

		} else if (players.size() == 3) {

			setPlayer3();
			setPlayer1(1);
			setPlayer2(2);
		}
	}

	private void passTurn() {

		pay();
		playerID++;

		if (playerID >= players.size()) {
			givePayOut();
			playerOptionsView.setDisable(true);
		}
	}

	private void setPlayer1(int i) {

		player1CardTotal.setText(Integer.toString(players.get(i).getHandValue()));
		p1Balance.setText(Double.toString(players.get(i).getBalance()));

		p1c1s1.setText(players.get(i).getHand().get(0).toString());
		p1c2s1.setText(players.get(i).getHand().get(1).toString());

		if (players.get(i).getHand().size() > 2) {

			p1c3s1.setText(players.get(i).getHand().get(2).toString());
		}
		if (players.get(i).getHand().size() > 3) {

			p1c4s1.setText(players.get(i).getHand().get(3).toString());
		}
		if (players.get(i).getHand().size() > 4) {
			p1c5s1.setText(players.get(i).getHand().get(4).toString());
		}
	}

	private void clearAll() {

		player3CardTotal.setText("");
		player2CardTotal.setText("");
		player1CardTotal.setText("");

		p3Balance.setText("");
		p2Balance.setText("");
		p1Balance.setText("");

		p1c1s1.setText("");
		p1c2s1.setText("");
		p1c3s1.setText("");
		p1c4s1.setText("");
		p1c5s1.setText("");
		p2c1s1.setText("");
		p2c2s1.setText("");
		p2c3s1.setText("");
		p2c4s1.setText("");
		p2c5s1.setText("");
		p2c1s1.setText("");
		p3c2s1.setText("");
		p3c3s1.setText("");
		p3c4s1.setText("");
		p3c5s1.setText("");

	}

	private void setPlayer3() {

		p3Balance.setText(Double.toString(players.get(0).getBalance()));
		player3CardTotal.setText(Integer.toString(players.get(0).getHandValue()));

		p3c1s1.setText(players.get(0).getHand().get(0).toString());
		p3c2s1.setText(players.get(0).getHand().get(1).toString());

		if (players.get(0).getHand().size() > 2) {
			p3c3s1.setText(players.get(0).getHand().get(2).toString());

		}
		if (players.get(0).getHand().size() > 3) {
			p3c4s1.setText(players.get(0).getHand().get(3).toString());
		}
		if (players.get(0).getHand().size() > 4) {
			p3c5s1.setText(players.get(0).getHand().get(4).toString());
		}
	}

	private void setPlayer2(int ID) {

		player2CardTotal.setText(Integer.toString(players.get(ID).getHandValue()));
		p2Balance.setText(Double.toString(players.get(ID).getBalance()));

		p2c1s1.setText(players.get(ID).getHand().get(0).toString());
		p2c2s1.setText(players.get(ID).getHand().get(1).toString());

		if (players.get(ID).getHand().size() > 2) {
			p2c3s1.setText(players.get(ID).getHand().get(2).toString());
		}

		if (players.get(ID).getHand().size() > 3) {
			p2c4s1.setText(players.get(ID).getHand().get(3).toString());
		}

		if (players.get(ID).getHand().size() > 4) {
			p2c5s1.setText(players.get(ID).getHand().get(4).toString());
		}
	}

	@FXML
	private void stand(ActionEvent event) {
		promptText.setText(players.get(playerID).getName() + " Passes turn");
		passTurn();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

	}

	private void pay() {
		players.get(playerID).setBalance(players.get(playerID).getBalance() - 100);
		pool += 100;
		pot.setText(Double.toString(pool));
	}

	private void givePayOut() {
		
		ArrayList<Human> winners = BlackJack.win();

		System.out.println(winners.size());
		String text = "Winners: ";

		if (!winners.isEmpty()) {
			for (int i = 0; i < winners.size(); i++) {
				text += winners.get(i).getName() + " ";
			}
		}else {
			text += "House";
		}

		promptText.setText(text);

//		ArrayList<Human> wina = new ArrayList<>();
//		if (winners.size() == 1) {
//			
//			wina.add(winners.get(0));
//
//		} else if (winners.size() == 2) {
//
//			wina.add(winners.get(0));
//			wina.add(winners.get(1));
//
//		} else if (winners.size() == 3) {
//
//			wina.add(winners.get(0));
//			wina.add(winners.get(1));
//			wina.add(winners.get(2));
//		}
		for (Human player : players) {
			for (Human winner : winners) {
				if (player.getName().equals(winner.getName())) {
					winner.setBalance(winner.getBalance() + (pool / winners.size()));
				}
			}
		}
	}

	@FXML
	private Label p3Balance;

	@FXML
	private Label p2Balance;;

	@FXML
	private Label p1Balance;

	@FXML
	private Label p1c1n1;

	@FXML
	private Label p1c1s1;

	@FXML
	private Label p1c2n1;

	@FXML
	private Label p1c2s1;

	@FXML
	private Label p1c3n1;

	@FXML
	private Label p1c3s1;

	@FXML
	private Label p1c4n1;

	@FXML
	private Label p1c4s1;

	@FXML
	private Label p1c5n1;

	@FXML
	private Label p1c5s1;

	@FXML
	private Label p1c1n2;

	@FXML
	private Label p1c1s2;

	@FXML
	private Label p1c2n2;

	@FXML
	private Label p1c2s2;

	@FXML
	private Label p1c3n2;

	@FXML
	private Label p1c3s2;

	@FXML
	private Label p1c4n2;

	@FXML
	private Label p1c4s2;

	@FXML
	private Label p1c5n2;

	@FXML
	private Label p1c5s2;

	@FXML
	private Label p2c1n1;

	@FXML
	private Label p2c1s1;

	@FXML
	private Label p2c2n1;

	@FXML
	private Label p2c2s1;

	@FXML
	private Label p2c3n1;

	@FXML
	private Label p2c3s1;

	@FXML
	private Label p2c4n1;

	@FXML
	private Label p2c4s1;

	@FXML
	private Label p2c5n1;

	@FXML
	private Label p2c5s1;

	@FXML
	private Label p2c1n2;

	@FXML
	private Label p2c1s2;

	@FXML
	private Label p2c2n2;

	@FXML
	private Label p2c2s2;

	@FXML
	private Label p2c3n2;

	@FXML
	private Label p2c3s2;

	@FXML
	private Label p2c4n2;

	@FXML
	private Label p2c4s2;

	@FXML
	private Label p2c5n2;

	@FXML
	private Label p2c5s2;

	@FXML
	private Label p3c1n1;

	@FXML
	private Label p3c1s1;

	@FXML
	private Label p3c2n1;

	@FXML
	private Label p3c2s1;

	@FXML
	private Label p3c3n1;

	@FXML
	private Label p3c3s1;

	@FXML
	private Label p3c4n1;

	@FXML
	private Label p3c4s1;

	@FXML
	private Label p3c5n1;

	@FXML
	private Label p3c5s1;

	@FXML
	private Label p3c1n2;

	@FXML
	private Label p3c1s2;

	@FXML
	private Label p3c2n2;

	@FXML
	private Label p3c2s2;

	@FXML
	private Label p3c3n2;

	@FXML
	private Label p3c3s2;

	@FXML
	private Label p3c4n2;

	@FXML
	private Label p3c4s2;

	@FXML
	private Label p3c5n2;

	@FXML
	private Label p3c5s2;

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
	private Label player2CardTotal;

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

	@FXML
	private Label promptText;
	
    @FXML
    private Button doubleDown;

	public void playBlackJack(ActionEvent event) {
		CardGames.runBlackjack();
	}

	@FXML
	public void playHiLo(ActionEvent event) {
		CardGames.runHiLo();
	}

	@FXML
	private void exit(ActionEvent event) {
		System.exit(0);
	}
}
