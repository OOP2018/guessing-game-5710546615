/**
 * A main class for the GuessingGame. It is responsible for creating objects,
 * connecting objects, and running the game UI.
 */
public class Main {

	/** create objects and start the game. */
	public static void main(String[] args) {
		// upper limit for secret number in guessing game
		int upperBound = 100;
		NumberGame game = new TongGame(upperBound);
//		 GameConsole ui = new GameConsole();
		GameSolver ui = new GameSolver();
		int solution = ui.play(game);

		System.out.println("Right! The secret number is " + solution + " ( " + game.getCount() + " times )");
	}
}