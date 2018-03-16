import java.util.Observable;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * A Controller for a window that shows the value of a user guess.
 *
 *@author Visurt Anuttivong
 */
public class GuessView extends Stage implements java.util.Observer {
	/** the stage (top-level window) for showing scene */
	private Stage stage;
	/** a NumberGame to show value of user guess*/
	private NumberGame ui;
	/** the label that shows the user guess number. */
	private Label label;

	/**
	 * Initialize a GuessView, which shows a number of user guess.
	 * 
	 * @param ui the NumberGame to show.
	 */
	public GuessView(NumberGame ui) {
		this.ui = ui;
		initComponents();
	}

	/**
	 * Initializes the components using JavaFX
	 */
	private void initComponents() {
		stage = this;
		HBox root = new HBox();
		root.setPadding(new Insets(10));
		root.setAlignment(Pos.CENTER);
		label = new Label("   ");
		label.setPrefWidth(196);
		label.setFont(new Font("Arial", 80.0));
		label.setAlignment(Pos.CENTER);
		root.getChildren().add(label);
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Guess");
		stage.sizeToScene();
	}

	/** 
	 * Show the window and update the number. 
	 */
	public void run() {
		stage.show();
		displayGuess();
	}

	/**
	 * Set the label to an updated data.
	 */
	public void displayGuess() {
		label.setText(String.format("%2d", ui.getGuessed()));
	}

	/**
	 * Update the number of user guess
	 * 
	 * @param o not used
	 * @param arg not used
	 */
	public void update(Observable o, Object arg) {
		displayGuess();
	}
}
