import java.net.URL;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * A main class for the GuessingGame. It is responsible for creating objects,
 * connecting objects, and running the game UI.
 * 
 * @author Visurt Anuttivong
 */
public class Main extends Application {

	/** 
	 * create objects and start the game.
	 * 
	 * @param args not used
	 */
	public static void main(String[] args) {
		launch(args);
	}

	/**
	 * Start the application.
	 * 
	 * @param primaryStage the stage for showing scene
	 */
	public void start(Stage primaryStage) {
		int upperBound = 100;
		NumberGame game = new TongGame(upperBound);

		try {
			URL url = getClass().getResource("GuessingGameUI.fxml");
			if (url == null) {
				System.out.println("Couldn't find file: GuessingGameUI.fxml");
				Platform.exit();
			}
			FXMLLoader loader = new FXMLLoader(url);
			Parent root = loader.load();

			GuessingGameController controller = loader.getController();
			controller.setGame(game);

			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.sizeToScene();
			primaryStage.setTitle("Guessing Game");
			primaryStage.show();
		} catch (Exception e) {
			System.out.println("Exception creating scene: " + e.getMessage());
		}

		GuessView guess = new GuessView(game);
		game.addObserver(guess);
		guess.run();

		CounterView count = new CounterView(game);
		game.addObserver(count);
		count.run();
	}
}