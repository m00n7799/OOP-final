package controller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import application.Main;
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
import models.Dealer;
import models.Deck;
import models.Human;

public class Controller implements Initializable {

	private ArrayList<Human> players = new ArrayList<>();
	private ArrayList<Dealer> dealer = new ArrayList<>();
	private BlackJack blackJack;
	private double pool = 0;
	private int playerID = 0;

	@FXML
	void playerNumberEntered(KeyEvent event) {

		String input = enterNumberOfPlayers.getText();

		if (!input.equals("") && event.getCode().equals(KeyCode.ENTER)) {

			int number = 0;

			try {
				number = Integer.parseInt(input);
			} catch (NumberFormatException e) {
				enterNumberOfPlayers.setText("Not Valid");
			}

			switch (number) {

			case 1:

				blackJack = new BlackJack();
				clearAll();

				enterNumberOfPlayers.setDisable(true);
				enterNumberOfPlayers.setVisible(false);

				player1Board.setDisable(false);
				player1Board.setVisible(true);

				dealerBoard.setDisable(false);
				dealerBoard.setVisible(true);

				blackJack.startNewGame(number);

				dealer.add(new Dealer());
				blackJack.dealerInitialDeal(dealer.get(0));
				setDealer(dealer.get(0));

				players = blackJack.getPlayers();

				player1Name.setText(blackJack.getPlayers().get(playerID).getName());

				playerOptionsView.setVisible(true);
				playerOptionsView.setDisable(false);

				setPlayer1(0);

				promptText.setText(players.get(playerID).getName() + " Hit Or Stand?");

				break;

			case 2:

				blackJack = new BlackJack();

				clearAll();

				enterNumberOfPlayers.setDisable(true);
				enterNumberOfPlayers.setVisible(false);
				player2Board.setVisible(true);
				player2Board.setDisable(false);
				player3Board.setVisible(true);
				player3Board.setDisable(false);

				dealerBoard.setDisable(false);
				dealerBoard.setVisible(true);

				blackJack.startNewGame(number);

				dealer.add(new Dealer());
				blackJack.dealerInitialDeal(dealer.get(0));
				setDealer(dealer.get(0));

				players = blackJack.getPlayers();

				playerOptionsView.setVisible(true);
				playerOptionsView.setDisable(false);

				player3Name.setText(players.get(0).getName());
				player2Name.setText(players.get(1).getName());

				setPlayer3();
				setPlayer2(1);
				promptText.setText(players.get(playerID).getName() + " Hit Or Stand?");

				break;

			case 3:

				blackJack = new BlackJack();

				clearAll();

				enterNumberOfPlayers.setDisable(true);
				enterNumberOfPlayers.setVisible(false);

				dealerBoard.setDisable(false);
				dealerBoard.setVisible(true);

				player3Board.setVisible(true);
				player3Board.setDisable(false);
				player1Board.setDisable(false);
				player1Board.setVisible(true);
				player2Board.setVisible(true);
				player2Board.setDisable(false);

				blackJack.startNewGame(number);

				dealer.add(new Dealer());
				blackJack.dealerInitialDeal(dealer.get(0));
				setDealer(dealer.get(0));

				players = blackJack.getPlayers();

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
		pool = 0;
		
		clearAll();

		startNewRound.setVisible(false);
		startNewRound.setDisable(true);

		blackJack.startNewRound(dealer.get(0));

		blackJack.dealerInitialDeal(dealer.get(0));
		setDealer(dealer.get(0));

		playerOptionsView.setDisable(false);

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
			takeDealerTurn();
			givePayOut();
			playerOptionsView.setDisable(true);
		}
	}

	private void takeDealerTurn() {

		while (dealer.get(0).isDrawing()) {
			Deck.nextCard(dealer.get(0), false);
			setDealer(dealer.get(0));
		}
	}

	private void setDealer(Dealer dealer) {

		dealerCardTotal.setText(Integer.toString(dealer.getHandValue()));

		dealerCard1.setText(dealer.getHand().get(0).toString());
		dealerCard2.setText(dealer.getHand().get(1).toString());

		if (dealer.getHand().size() > 2) {
			dealerCard3.setText(dealer.getHand().get(2).toString());
		}
		if (dealer.getHand().size() > 3) {
			dealerCard4.setText(dealer.getHand().get(3).toString());
		}
		if (dealer.getHand().size() > 4) {
			dealerCard5.setText(dealer.getHand().get(4).toString());
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
		dealerCardTotal.setText("");

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

		dealerCard1.setText("");
		dealerCard2.setText("");
		dealerCard3.setText("");
		dealerCard4.setText("");
		dealerCard5.setText("");

		pot.setText("");

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
		pot.setText("Winnings: " + Double.toString(pool));
	}

	private void givePayOut() {

		ArrayList<Human> winners = blackJack.win();
		System.out.println("Size: " + winners.size());

		String text = "Winners: ";

		if (dealer.get(0).isBust()) {
			System.out.println("DealerBust");
			if (!winners.isEmpty()) {
				System.out.println("Not Empty");
				for (int i = 0; i < winners.size(); i++) {
					text += winners.get(i).getName() + " ";
				}
				for (Human player : players) {
					for (Human winner : winners) {
						if (player.getName().equals(winner.getName())) {
							winner.setBalance(winner.getBalance() + (pool / winners.size()));
						}
					}
				}
			}else {
				System.out.println("Empty");
				text+= "House";
			}
		} else {
			System.out.println("Not Bust");
			if (!winners.isEmpty() && winners.get(0).getHandValue() > dealer.get(0).getHandValue()) {
				System.out.println("Not Empty ");
				for (int i = 0; i < winners.size(); i++) {
					text += winners.get(i).getName() + " ";
				}
				for (Human player : players) {
					for (Human winner : winners) {
						if (player.getName().equals(winner.getName())) {
							winner.setBalance(winner.getBalance() + (pool / winners.size()));
						}
					}
				}
			} else {
				System.out.println("HandValue less than dealer");
				text += "House";
			}
		}

		promptText.setText(text);

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

		startNewRound.setVisible(true);
		startNewRound.setDisable(false);
	}

    @FXML
    void save(ActionEvent event){
    	
    	System.out.println("save");
    	try {
			
    		FileOutputStream fileOut = new FileOutputStream("./blackJack.txt");
    		ObjectOutputStream outPutStream = new ObjectOutputStream(fileOut);
    		outPutStream.writeObject(blackJack);

    		outPutStream.close();
    		fileOut.close();
		} catch (Exception e) {
			System.out.println("error");
		}
    }
    

    @FXML
    void load(ActionEvent event) {
    	
    	System.out.println("Load");
    	try {
    		FileInputStream fileIn = new FileInputStream("./blackJack.txt");
    		ObjectInputStream inputStream = new ObjectInputStream(fileIn);
    		
    		blackJack = (BlackJack) inputStream.readObject();
    		
    		fileIn.close();
    		inputStream.close();	
    		
    		playerID = 0;
    		pool = 0;
    		
    		players = blackJack.getPlayers();
    		clearAll();

    		startNewRound.setVisible(false);
    		startNewRound.setDisable(true);

    		blackJack.startNewRound(dealer.get(0));

    		blackJack.dealerInitialDeal(dealer.get(0));
    		setDealer(dealer.get(0));

    		playerOptionsView.setDisable(false);

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
    	}catch(Exception e){
    		System.out.println("Error");
    	}
    }

	@FXML
	private Label promptText;

	@FXML
	private TextField enterNumberOfPlayers;

	@FXML
	private AnchorPane player3Board;

	@FXML
	private Label player3Name;

	@FXML
	private Label p3Balance;

	@FXML
	private Label player3CardTotal;

	@FXML
	private AnchorPane player3Card1;

	@FXML
	private Label p3c1s1;

	@FXML
	private AnchorPane player3Card2;

	@FXML
	private Label p3c2s1;

	@FXML
	private AnchorPane player3Card3;

	@FXML
	private Label p3c3s1;

	@FXML
	private AnchorPane player3Card4;

	@FXML
	private Label p3c4s1;

	@FXML
	private AnchorPane player3Card5;

	@FXML
	private Label p3c5s1;

	@FXML
	private AnchorPane player1Board;

	@FXML
	private Label p1Balance;

	@FXML
	private Label player1Name;

	@FXML
	private Label player1CardTotal;

	@FXML
	private AnchorPane player1Card1;

	@FXML
	private Label p1c1s1;

	@FXML
	private AnchorPane player1Card2;

	@FXML
	private Label p1c2s1;

	@FXML
	private AnchorPane Player1Card3;

	@FXML
	private Label p1c3s1;

	@FXML
	private AnchorPane player1Card4;

	@FXML
	private Label p1c4s1;

	@FXML
	private AnchorPane player1Card5;

	@FXML
	private Label p1c5s1;

	@FXML
	private AnchorPane player2Board;

	@FXML
	private Label p2Balance;

	@FXML
	private Label player2Name;

	@FXML
	private Label player2CardTotal;

	@FXML
	private AnchorPane player2Card1;

	@FXML
	private Label p2c1s1;

	@FXML
	private AnchorPane player2Card2;

	@FXML
	private Label p2c2s1;

	@FXML
	private AnchorPane player2Card3;

	@FXML
	private Label p2c3s1;

	@FXML
	private AnchorPane player2Card4;

	@FXML
	private Label p2c4s1;

	@FXML
	private AnchorPane player2Card5;

	@FXML
	private Label p2c5s1;

	@FXML
	private AnchorPane dealerBoard;

	@FXML
	private Label dealerCardTotal;

	@FXML
	private Label dealerCard1;

	@FXML
	private Label dealerCard2;

	@FXML
	private Label dealerCard3;

	@FXML
	private Label dealerCard4;

	@FXML
	private Label dealerCard5;

	@FXML
	private AnchorPane playerOptionsView;

	@FXML
	private Label pot;

	@FXML
	private Button stand;

	@FXML
	private Button hit;

	@FXML
	private Button doubleDown;

	@FXML
	private Button startNewRound;

	@FXML
	private void exit(ActionEvent event) {
		System.exit(0);
	}
}
