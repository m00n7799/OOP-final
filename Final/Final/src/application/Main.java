package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

public class Main extends Application{
	@Override
	public void start(Stage primaryStage) {

		Pane root = new Pane();
		Scene scene = new Scene(root, 400, 400);

		root.setPrefSize(400, 400);
		
		//Title
		Label title = new Label();
		title.setText("Card Games");
		title.relocate(150, 50);
		title.setPrefSize(200,100);

		// BlackJack Button
		Button blackJack = new Button("Play BlackJack");
		blackJack.relocate(150,200);
		blackJack.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				System.out.println("Playing BlackJack");

			}
		});
		
		// HiLo Button
		Button hiLo = new Button("Play HiLo");
		hiLo.relocate(160,250);
		hiLo.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.out.println("Playing Hilo");
			}
		});
		
		
		root.getChildren().addAll(blackJack, hiLo,title);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
