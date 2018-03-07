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
import javafx.scene.image.ImageView;
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

				setPlayer1Name(BlackJack.getPlayers().get(playerID).getName());

				playerOptionsView.setVisible(true);
				playerOptionsView.setDisable(false);

				setPlayer1CardTotal(Integer.toString(BlackJack.getPlayers().get(playerID).getHandValue()));
				setPlayer1Hand();

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

				setPlayer3Name(BlackJack.getPlayers().get(0).getName());
				setPlayer2Name(BlackJack.getPlayers().get(1).getName());

				setPlayer3CardTotal(Integer.toString(BlackJack.getPlayers().get(0).getHandValue()));
				setPlayer2CardTotal(Integer.toString(BlackJack.getPlayers().get(1).getHandValue()));

				setPlayer3Hand();
				playerID++;
				setPlayer2Hand();
				playerID = 0;

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

				setPlayer3Name(BlackJack.getPlayers().get(0).getName());
				setPlayer1Name(BlackJack.getPlayers().get(1).getName());
				setPlayer2Name(BlackJack.getPlayers().get(2).getName());

				playerOptionsView.setVisible(true);
				playerOptionsView.setDisable(false);
				
				setPlayer3Hand();
				playerID++;
				setPlayer1Hand();
				playerID++;
				setPlayer2Hand();
				playerID = 0;

				setPlayer3CardTotal(Integer.toString(BlackJack.getPlayers().get(0).getHandValue()));
				setPlayer1CardTotal(Integer.toString(BlackJack.getPlayers().get(1).getHandValue()));
				setPlayer2CardTotal(Integer.toString(BlackJack.getPlayers().get(2).getHandValue()));

				break;

			default:
				enterNumberOfPlayers.setText("Not Valid");
				break;
			}
		}
	}

	boolean isDrawing;

	private void setPlayer2CardTotal(String handValue) {
		player2CcardTotal.setText(handValue);
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
	private ImageView suit1;

	ArrayList<Player> players = new ArrayList<>();

	@FXML
	public void hit(ActionEvent event) {

		Deck.nextCard(players.get(playerID));
		if (players.size() == 1) {

			setPlayer1CardTotal(Integer.toString(players.get(playerID).getHandValue()));
			setPlayer1Hand();

		} else if (players.size() == 2) {

			if (playerID == 0) {
				setPlayer3CardTotal(Integer.toString(players.get(playerID).getHandValue()));
				setPlayer3Hand();

			} else {
				setPlayer2CardTotal(Integer.toString(players.get(playerID).getHandValue()));
				setPlayer2Hand();
			}
		} else if (players.size() == 3) {
			if (playerID == 0) {
				setPlayer3CardTotal(Integer.toString(players.get(playerID).getHandValue()));
				setPlayer3Hand();

			} else if (playerID == 1) {
				setPlayer1CardTotal(Integer.toString(players.get(playerID).getHandValue()));
				setPlayer1Hand();

			} else {
				setPlayer2CardTotal(Integer.toString(players.get(playerID).getHandValue()));
				setPlayer2Hand();
			}
		}
		if(players.get(playerID).isBust() || players.get(playerID).getHand().size() == 5) {
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

			System.out.println("Winning?");
			playerID = 0;
			ArrayList<Player> w = BlackJack.win();

			for (Player player : w) {
				System.out.println("Winner:"+player.getName());
			}
			ArrayList<Human> wina = new ArrayList<>();
			if (w.size() == 1) {
				wina.add((Human) w.get(0));
			}else if(w.size() == 2){
				wina.add((Human) w.get(0));
				wina.add((Human) w.get(1));
			}else if(w.size() == 3){
				wina.add((Human) w.get(0));
				wina.add((Human) w.get(1));
				wina.add((Human) w.get(2));
			}
			for (Human d : huma) {
				for(Human win:wina) {
					if (d.getName().equals(win.getName())) {
						d.setBalance(d.getBalance() + (pool/w.size()));
					}
				}

				System.out.println(d.getName() + ": " + d.getBalance());
			}
			pool = 100;
			
			setPlayer3CardTotal("");
			setPlayer2CardTotal("");
			setPlayer1CardTotal("");
			BlackJack.startNewRound();
			huma.clear();
		}
		if (players.size() == 1) {

			setPlayer1CardTotal(Integer.toString(players.get(0).getHandValue()));

		} else if (players.size() == 2) {

			setPlayer3CardTotal(Integer.toString(players.get(2).getHandValue()));

			setPlayer2CardTotal(Integer.toString(players.get(1).getHandValue()));

		} else if (players.size() == 3) {

			setPlayer3CardTotal(Integer.toString(players.get(0).getHandValue()));
			setPlayer1CardTotal(Integer.toString(players.get(1).getHandValue()));
			setPlayer2CardTotal(Integer.toString(players.get(2).getHandValue()));

		}
	}

	public void setPlayer1Hand() {

		p1c1n1.setText(Integer.toString(players.get(playerID).getHand().get(0).getCardValue()));
		p1c1s1.setText(players.get(playerID).getHand().get(0).getSuit().toString());
		// p1c1n2.setText(Integer.toString(players.get(playerID).getHand().get(0).getCardValue()));
		// p1c1s2.setText(players.get(playerID).getHand().get(0).getSuit().toString());

		p1c2n1.setText(Integer.toString(players.get(playerID).getHand().get(1).getCardValue()));
		p1c2s1.setText(players.get(playerID).getHand().get(1).getSuit().toString());
		// p1c2n2.setText(Integer.toString(players.get(playerID).getHand().get(1).getCardValue()));
		// p1c2s2.setText(players.get(playerID).getHand().get(1).getSuit().toString());

		if (players.get(playerID).getHand().size() > 2) {

			p1c3n1.setText(Integer.toString(players.get(playerID).getHand().get(2).getCardValue()));
			p1c3s1.setText(players.get(playerID).getHand().get(2).getSuit().toString());
			// p1c3n2.setText(Integer.toString(players.get(playerID).getHand().get(2).getCardValue()));
			// p1c3s2.setText(players.get(playerID).getHand().get(2).getSuit().toString());
		}
		if (players.get(playerID).getHand().size() > 3) {
			p1c4n1.setText(Integer.toString(players.get(playerID).getHand().get(3).getCardValue()));
			p1c4s1.setText(players.get(playerID).getHand().get(3).getSuit().toString());
			// p1c4n2.setText(Integer.toString(players.get(playerID).getHand().get(3).getCardValue()));
			// p1c4s2.setText(players.get(playerID).getHand().get(3).getSuit().toString());
		}

		if (players.get(playerID).getHand().size() > 4) {
			p1c5n1.setText(Integer.toString(players.get(playerID).getHand().get(4).getCardValue()));
			p1c5s1.setText(players.get(playerID).getHand().get(4).getSuit().toString());
			// p1c5n2.setText(Integer.toString(players.get(playerID).getHand().get(4).getCardValue()));
			// p1c5s2.setText(players.get(playerID).getHand().get(4).getSuit().toString());
		}
	}

	public void setPlayer3Hand() {

		p3c1n1.setText(Integer.toString(players.get(playerID).getHand().get(0).getCardValue()));
		p3c1s1.setText(players.get(playerID).getHand().get(0).getSuit().toString());
		// p3c1n2.setText(Integer.toString(players.get(playerID).getHand().get(0).getCardValue()));
		// p3c1s2.setText(players.get(playerID).getHand().get(0).getSuit().toString());

		p3c2n1.setText(Integer.toString(players.get(playerID).getHand().get(1).getCardValue()));
		p3c2s1.setText(players.get(playerID).getHand().get(1).getSuit().toString());
		// p3c2n2.setText(Integer.toString(players.get(playerID).getHand().get(1).getCardValue()));
		// p3c2s2.setText(players.get(playerID).getHand().get(1).getSuit().toString());

		if (players.get(playerID).getHand().size() > 2) {
			p3c3n1.setText(Integer.toString(players.get(playerID).getHand().get(2).getCardValue()));
			p3c3s1.setText(players.get(playerID).getHand().get(2).getSuit().toString());
			// p3c3n2.setText(Integer.toString(players.get(playerID).getHand().get(2).getCardValue()));
			// p3c3s2.setText(players.get(playerID).getHand().get(2).getSuit().toString());
		}

		if (players.get(playerID).getHand().size() > 3) {
			p3c4n1.setText(Integer.toString(players.get(playerID).getHand().get(3).getCardValue()));
			p3c4s1.setText(players.get(playerID).getHand().get(3).getSuit().toString());
			// p3c4n2.setText(Integer.toString(players.get(playerID).getHand().get(3).getCardValue()));
			// p3c4s2.setText(players.get(playerID).getHand().get(3).getSuit().toString());
		}

		if (players.get(playerID).getHand().size() > 4) {
			p3c5n1.setText(Integer.toString(players.get(playerID).getHand().get(4).getCardValue()));
			p3c5s1.setText(players.get(playerID).getHand().get(4).getSuit().toString());
			// p3c5n2.setText(Integer.toString(players.get(playerID).getHand().get(4).getCardValue()));
			// p3c5s2.setText(players.get(playerID).getHand().get(4).getSuit().toString());
		}
	}

	public void setPlayer2Hand() {
		p2c1n1.setText(Integer.toString(players.get(playerID).getHand().get(0).getCardValue()));
		p2c1s1.setText(players.get(playerID).getHand().get(0).getSuit().toString());
		// p2c1n2.setText(Integer.toString(players.get(playerID).getHand().get(0).getCardValue()));
		// p2c1s2.setText(players.get(playerID).getHand().get(0).getSuit().toString());

		p2c2n1.setText(Integer.toString(players.get(playerID).getHand().get(1).getCardValue()));
		p2c2s1.setText(players.get(playerID).getHand().get(1).getSuit().toString());
		// p2c2n2.setText(Integer.toString(players.get(playerID).getHand().get(1).getCardValue()));
		// p2c2s2.setText(players.get(playerID).getHand().get(1).getSuit().toString());

		if (players.get(playerID).getHand().size() > 2) {
			p2c3n1.setText(Integer.toString(players.get(playerID).getHand().get(2).getCardValue()));
			p2c3s1.setText(players.get(playerID).getHand().get(2).getSuit().toString());
			// p2c3n2.setText(Integer.toString(players.get(playerID).getHand().get(2).getCardValue()));
			// p2c3s2.setText(players.get(playerID).getHand().get(2).getSuit().toString());
		}
		if (players.get(playerID).getHand().size() > 3) {
			p2c4n1.setText(Integer.toString(players.get(playerID).getHand().get(3).getCardValue()));
			p2c4s1.setText(players.get(playerID).getHand().get(3).getSuit().toString());
			// p2c4n2.setText(Integer.toString(players.get(playerID).getHand().get(3).getCardValue()));
			// p2c4s2.setText(players.get(playerID).getHand().get(3).getSuit().toString());
		}

		if (players.get(playerID).getHand().size() > 4) {
			p2c5n1.setText(Integer.toString(players.get(playerID).getHand().get(4).getCardValue()));
			p2c5s1.setText(players.get(playerID).getHand().get(4).getSuit().toString());
			// p2c5n2.setText(Integer.toString(players.get(playerID).getHand().get(4).getCardValue()));
			// p2c5s2.setText(players.get(playerID).getHand().get(4).getSuit().toString());
		}
	}

	@FXML
	public void stand(ActionEvent event) {
		passTurn();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

	}

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

	public void setPlayer3CardTotal(String value) {
		player3CardTotal.setText(value);
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

	public String getPlayer1CardTotal() {
		return player1CardTotal.getText();
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

	public void setPlayer1CardTotal(String hand) {
		player1CardTotal.setText(hand);
	}
}