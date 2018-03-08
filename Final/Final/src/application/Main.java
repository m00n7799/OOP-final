package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application{

	private static Stage pStage;
	
	public void start(Stage primaryStage) {
		
		setPrimaryStage(primaryStage);
		
		AnchorPane root = new AnchorPane();
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("/MainMenu.fxml"));
		
		try {
			root = loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	private void setPrimaryStage(Stage primaryStage) {
		this.pStage = primaryStage; 
	}

	public static Stage getStage() {
		return pStage;
	}

	public static void main(String[] args) {
		launch(args);
	}
}
