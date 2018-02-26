package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {

		StackPane root = new StackPane();
		Scene scene = new Scene(root, 600, 600);

		// BlackJack Button
		Button blackJack = new Button("Play BlackJack");
		
		blackJack.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				System.out.println("Playing BlackJack");

			}
		});
		
		// HiLo Button
		Button hiLo = new Button("Play HiLo");
		hiLo.relocate(200, 500);
		hiLo.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				System.out.println("Playing Hilo");
			}
		});
		root.getChildren().addAll(blackJack, hiLo);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
