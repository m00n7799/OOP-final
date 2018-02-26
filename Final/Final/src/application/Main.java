package application;
	
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {

			StackPane root = new StackPane();
			Scene scene = new Scene(root,1000,400);
			Button blackJack = new Button("Play BlackJack");
			Button hiLo = new Button("Play HiLo");
			
			blackJack.setOnAction(new EventHandler<ActionEvent>() {
				
				@Override
				public void handle(ActionEvent event) {
					System.out.println("Playing BlackJack");
					
				}
			});
			
			hiLo.setOnAction(new EventHandler<ActionEvent>(){
				
				@Override
				public void handle(ActionEvent event) {
					System.out.println("Playing Hilo");
				}
			});
			root.getChildren().addAll(blackJack,hiLo);
			primaryStage.setScene(scene);
			primaryStage.show();		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
