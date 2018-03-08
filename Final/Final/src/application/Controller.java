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
import models.Player;

public class Controller implements Initializable {

	private int playerID = 0;

	@FXML
	void playerNumberEntered(KeyEvent event) {

		String input = enterNumberOfPlayers.getText();

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

				BlackJack.startNewGame(number);
				players = BlackJack.getPlayers();

				player1Name.setText(BlackJack.getPlayers().get(playerID).getName());

				playerOptionsView.setVisible(true);
				playerOptionsView.setDisable(false);

				player1CardTotal.setText(Integer.toString(players.get(playerID).getHandValue()));
				setPlayer1Hand(0);

				p1Balance.setText(Double.toString(players.get(playerID).getBalance()));
				promptText.setText(players.get(playerID).getName() + " Hit Or Stand?");

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

				BlackJack.startNewGame(number);

				players = BlackJack.getPlayers();

				playerOptionsView.setVisible(true);
				playerOptionsView.setDisable(false);

				player3Name.setText(players.get(0).getName());
				player2Name.setText(players.get(1).getName());

				player3CardTotal.setText(Integer.toString(players.get(0).getHandValue()));
				player2CardTotal.setText(Integer.toString(players.get(1).getHandValue()));

				p3Balance.setText(Double.toString(players.get(0).getBalance()));
				p2Balance.setText(Double.toString(players.get(1).getBalance()));

				setPlayer3Hand();
				playerID++;
				setPlayer2Hand(1);
				playerID = 0;
				promptText.setText(players.get(playerID).getName() + " Hit Or Stand?");

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

				BlackJack.startNewGame(number);

				players = BlackJack.getPlayers();

				player3Name.setText(players.get(0).getName());
				player1Name.setText(players.get(1).getName());
				player2Name.setText(players.get(2).getName());

				playerOptionsView.setVisible(true);
				playerOptionsView.setDisable(false);

				setPlayer3Hand();
				setPlayer1Hand(1);
				setPlayer2Hand(2);
				playerID = 0;

				p3Balance.setText(Double.toString(players.get(playerID).getBalance()));
				p1Balance.setText(Double.toString(players.get(playerID + 1).getBalance()));
				p2Balance.setText(Double.toString(players.get(playerID + 2).getBalance()));

				player3CardTotal.setText(Integer.toString(players.get(playerID).getHandValue()));
				player1CardTotal.setText(Integer.toString(players.get(playerID + 1).getHandValue()));
				player2CardTotal.setText(Integer.toString(players.get(playerID + 2).getHandValue()));

				promptText.setText(players.get(playerID).getName() + " Hit Or Stand?");

				break;

			default:
				enterNumberOfPlayers.setText("Not Valid");
				break;
			}
		}
	}

	boolean isDrawing;

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

	ArrayList<Human> players = new ArrayList<>();

	@FXML
	public void hit(ActionEvent event) {

		Deck.nextCard(players.get(playerID));
		if (players.size() == 1) {

			player1CardTotal.setText(Integer.toString(players.get(playerID).getHandValue()));
			setPlayer1Hand(0);
			p1Balance.setText(Double.toString(players.get(playerID).getBalance()));

		} else if (players.size() == 2) {

			if (playerID == 0) {
				player3CardTotal.setText(Integer.toString(players.get(playerID).getHandValue()));
				setPlayer3Hand();
				p3Balance.setText(Double.toString(players.get(playerID).getBalance()));

			} else {
				player2CardTotal.setText(Integer.toString(players.get(playerID).getHandValue()));
				setPlayer2Hand(1);
				p2Balance.setText(Double.toString(players.get(playerID).getBalance()));
			}
		} else if (players.size() == 3) {
			if (playerID == 0) {
				player3CardTotal.setText(Integer.toString(players.get(playerID).getHandValue()));
				setPlayer3Hand();
				p3Balance.setText(Double.toString(players.get(playerID).getBalance()));

			} else if (playerID == 1) {
				player1CardTotal.setText(Integer.toString(players.get(playerID).getHandValue()));
				setPlayer1Hand(1);
				p1Balance.setText(Double.toString(players.get(playerID).getBalance()));

			} else {
				player2CardTotal.setText(Integer.toString(players.get(playerID).getHandValue()));
				setPlayer2Hand(2);
				p2Balance.setText(Double.toString(players.get(playerID).getBalance()));
			}
		}
		if (players.get(playerID).isBust()) {
			if ((playerID + 1) >= players.size()) {
				promptText.setText("Who is the Winner");
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

	ArrayList<Human> huma = new ArrayList<>();
	double pool = 100;

	private void passTurn() {

		Human h = (Human) players.get(playerID);
		h.setBalance(h.getBalance() - 100);
		pool += 100;
		huma.add(h);
		playerID++;

		if (playerID >= players.size()) {

			playerID = 0;
			ArrayList<Player> w = BlackJack.win();

			for (Player player : w) {
				promptText.setText("Winner: " + player.getName());
			}

			ArrayList<Human> wina = new ArrayList<>();
			if (w.size() == 1) {
				wina.add((Human) w.get(0));
			} else if (w.size() == 2) {
				wina.add((Human) w.get(0));
				wina.add((Human) w.get(1));
			} else if (w.size() == 3) {
				wina.add((Human) w.get(0));
				wina.add((Human) w.get(1));
				wina.add((Human) w.get(2));
			}
			for (Human d : huma) {
				for (Human win : wina) {
					if (d.getName().equals(win.getName())) {
						d.setBalance(d.getBalance() + (pool / w.size()));
					}
				}
				System.out.println(d.getName() + ": " + d.getBalance());
			}
			pool = 100;

			clearAll();

			BlackJack.startNewRound();

			huma.clear();

			if (players.size() == 1) {

				player1CardTotal.setText(Integer.toString(players.get(0).getHandValue()));
				setPlayer1Hand(0);
				p1Balance.setText(Double.toString(players.get(0).getBalance()));


			} else if (players.size() == 2) {

				player3CardTotal.setText(Integer.toString(players.get(0).getHandValue()));
				setPlayer3Hand();
				p3Balance.setText(Double.toString(players.get(0).getBalance()));
				
				player2CardTotal.setText(Integer.toString(players.get(1).getHandValue()));
				setPlayer2Hand(1);
				p2Balance.setText(Double.toString(players.get(1).getBalance()));


			} else if (players.size() == 3) {

				player3CardTotal.setText(Integer.toString(players.get(0).getHandValue()));
				setPlayer3Hand();
				p3Balance.setText(Double.toString(players.get(0).getBalance()));

				player1CardTotal.setText(Integer.toString(players.get(1).getHandValue()));
				setPlayer1Hand(1);
				p1Balance.setText(Double.toString(players.get(1).getBalance()));

				player2CardTotal.setText(Integer.toString(players.get(2).getHandValue()));
				setPlayer2Hand(2);
				p2Balance.setText(Double.toString(players.get(2).getBalance()));
			}
		}
	}

	public void setPlayer1Hand(int ID) {

		p1c1n1.setText(Integer.toString(players.get(ID).getHand().get(0).getCardValue()));
		p1c1s1.setText(players.get(ID).getHand().get(0).getSuit().toString());
		// p1c1n2.setText(Integer.toString(players.get(playerID).getHand().get(0).getCardValue()));
		// p1c1s2.setText(players.get(playerID).getHand().get(0).getSuit().toString());

		p1c2n1.setText(Integer.toString(players.get(ID).getHand().get(1).getCardValue()));
		p1c2s1.setText(players.get(ID).getHand().get(1).getSuit().toString());
		// p1c2n2.setText(Integer.toString(players.get(playerID).getHand().get(1).getCardValue()));
		// p1c2s2.setText(players.get(playerID).getHand().get(1).getSuit().toString());

		if (players.get(ID).getHand().size() > 2) {

			p1c3n1.setText(Integer.toString(players.get(ID).getHand().get(2).getCardValue()));
			p1c3s1.setText(players.get(ID).getHand().get(2).getSuit().toString());
			// p1c3n2.setText(Integer.toString(players.get(playerID).getHand().get(2).getCardValue()));
			// p1c3s2.setText(players.get(playerID).getHand().get(2).getSuit().toString());
		}
		if (players.get(ID).getHand().size() > 3) {
			p1c4n1.setText(Integer.toString(players.get(ID).getHand().get(3).getCardValue()));
			p1c4s1.setText(players.get(ID).getHand().get(3).getSuit().toString());
			// p1c4n2.setText(Integer.toString(players.get(playerID).getHand().get(3).getCardValue()));
			// p1c4s2.setText(players.get(playerID).getHand().get(3).getSuit().toString());
		}

		if (players.get(ID).getHand().size() > 4) {
			p1c5n1.setText(Integer.toString(players.get(ID).getHand().get(4).getCardValue()));
			p1c5s1.setText(players.get(ID).getHand().get(4).getSuit().toString());
			// p1c5n2.setText(Integer.toString(players.get(playerID).getHand().get(4).getCardValue()));
			// p1c5s2.setText(players.get(playerID).getHand().get(4).getSuit().toString());
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

		p1c1n1.setText("");
		p1c2n1.setText("");
		p1c3n1.setText("");
		p1c4n1.setText("");
		p1c5n1.setText("");
		p2c1n1.setText("");
		p2c2n1.setText("");
		p2c3n1.setText("");
		p2c4n1.setText("");
		p2c5n1.setText("");
		p2c1n1.setText("");
		p3c2n1.setText("");
		p3c3n1.setText("");
		p3c4n1.setText("");
		p3c5n1.setText("");

	}

	public void setPlayer3Hand() {

		p3c1n1.setText(Integer.toString(players.get(0).getHand().get(0).getCardValue()));
		p3c1s1.setText(players.get(0).getHand().get(0).getSuit().toString());
		// p3c1n2.setText(Integer.toString(players.get(playerID).getHand().get(0).getCardValue()));
		// p3c1s2.setText(players.get(playerID).getHand().get(0).getSuit().toString());

		p3c2n1.setText(Integer.toString(players.get(0).getHand().get(1).getCardValue()));
		p3c2s1.setText(players.get(0).getHand().get(1).getSuit().toString());
		// p3c2n2.setText(Integer.toString(players.get(playerID).getHand().get(1).getCardValue()));
		// p3c2s2.setText(players.get(playerID).getHand().get(1).getSuit().toString());

		if (players.get(0).getHand().size() > 2) {
			p3c3n1.setText(Integer.toString(players.get(0).getHand().get(2).getCardValue()));
			p3c3s1.setText(players.get(0).getHand().get(2).getSuit().toString());
			// p3c3n2.setText(Integer.toString(players.get(playerID).getHand().get(2).getCardValue()));
			// p3c3s2.setText(players.get(playerID).getHand().get(2).getSuit().toString());
		}

		if (players.get(0).getHand().size() > 3) {
			p3c4n1.setText(Integer.toString(players.get(0).getHand().get(3).getCardValue()));
			p3c4s1.setText(players.get(0).getHand().get(3).getSuit().toString());
			// p3c4n2.setText(Integer.toString(players.get(playerID).getHand().get(3).getCardValue()));
			// p3c4s2.setText(players.get(playerID).getHand().get(3).getSuit().toString());
		}

		if (players.get(0).getHand().size() > 4) {
			p3c5n1.setText(Integer.toString(players.get(0).getHand().get(4).getCardValue()));
			p3c5s1.setText(players.get(0).getHand().get(4).getSuit().toString());
			// p3c5n2.setText(Integer.toString(players.get(playerID).getHand().get(4).getCardValue()));
			// p3c5s2.setText(players.get(playerID).getHand().get(4).getSuit().toString());
		}
	}

	public void setPlayer2Hand(int ID) {
		p2c1n1.setText(Integer.toString(players.get(ID).getHand().get(0).getCardValue()));
		p2c1s1.setText(players.get(ID).getHand().get(0).getSuit().toString());
		// p2c1n2.setText(Integer.toString(players.get(ID).getHand().get(0).getCardValue()));
		// p2c1s2.setText(players.get(ID).getHand().get(0).getSuit().toString());

		p2c2n1.setText(Integer.toString(players.get(ID).getHand().get(1).getCardValue()));
		p2c2s1.setText(players.get(ID).getHand().get(1).getSuit().toString());
		// p2c2n2.setText(Integer.toString(players.get(ID).getHand().get(1).getCardValue()));
		// p2c2s2.setText(players.get(ID).getHand().get(1).getSuit().toString());

		if (players.get(ID).getHand().size() > 2) {
			p2c3n1.setText(Integer.toString(players.get(ID).getHand().get(2).getCardValue()));
			p2c3s1.setText(players.get(ID).getHand().get(2).getSuit().toString());
			// p2c3n2.setText(Integer.toString(players.get(ID).getHand().get(2).getCardValue()));
			// p2c3s2.setText(players.get(ID).getHand().get(2).getSuit().toString());
		}
		if (players.get(ID).getHand().size() > 3) {
			p2c4n1.setText(Integer.toString(players.get(ID).getHand().get(3).getCardValue()));
			p2c4s1.setText(players.get(ID).getHand().get(3).getSuit().toString());
			// p2c4n2.setText(Integer.toString(players.get(ID).getHand().get(3).getCardValue()));
			// p2c4s2.setText(players.get(ID).getHand().get(3).getSuit().toString());
		}

		if (players.get(ID).getHand().size() > 4) {
			p2c5n1.setText(Integer.toString(players.get(ID).getHand().get(4).getCardValue()));
			p2c5s1.setText(players.get(ID).getHand().get(4).getSuit().toString());
			// p2c5n2.setText(Integer.toString(players.get(ID).getHand().get(4).getCardValue()));
			// p2c5s2.setText(players.get(ID).getHand().get(4).getSuit().toString());
		}
	}

	@FXML
	public void stand(ActionEvent event) {
		promptText.setText(players.get(playerID).getName() + " Passes turn");
		passTurn();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

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
}
