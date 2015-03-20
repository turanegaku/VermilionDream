package VermilionDream;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class VermilionDream extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("VermilionDream.fxml"));
		primaryStage.setScene(new Scene(root));
		primaryStage.setTitle("Vermilion Dream");
		primaryStage.show();
	}
	
	@Override
	public void stop() throws Exception{
		VermilionControler.stop();
		super.stop();
	}

	

	public static void main(String[] args) {
		launch(args);
	}
	
}
