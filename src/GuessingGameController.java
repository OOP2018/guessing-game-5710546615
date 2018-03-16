import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * Controller for the GuessingGame user interface.
 * 
 * @author Visurt Anuttivong
 */
public class GuessingGameController {
	@FXML
	private TextField input;
	@FXML
	private Label hint;

	private NumberGame game;

	/**
	 * Gets the NumberGame
	 * 
	 * @return the NumberGame to use with
	 */
	public NumberGame getGame() {
		return game;
	}

	/**
	 * Set the NumberGame
	 * 
	 * @param game the NumberGame to use with
	 */
	public void setGame(NumberGame game) {
		this.game = game;
	}

	/**
	 * Guess handler is to guess a number from input field.
	 */
	public void guessHandler() {
		int guess;
		boolean correct;

		try {
			guess = Integer.parseInt(input.getText().trim());
			correct = game.guess(guess);

			hint.setText(game.getMessage());
			input.setStyle("-fx-text-fill: black;");

			if (correct) {
				input.setDisable(true);
				hint.setText("Correct!");
			}
		} catch (Exception e) {
			input.setText("Invalid");
			input.setStyle("-fx-text-fill: red;");
			hint.setText("Invalid input found, ignoring request.");
		}
	}
}
