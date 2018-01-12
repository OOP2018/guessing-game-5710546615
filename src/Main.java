/**
 * A main class for the GuessingGame.
 * It is responsible for creating objects, 
 * connecting objects, and running the game UI.
 */
public class Main {
	public static void main(String[] args) {
		// upper limit for secret number in guessing game
		int upperBound = 20;
		NumberGame game = new TongGame(upperBound);
		GameSolver ui = new GameSolver();
		int solution = ui.play( game );
		
		System.out.println("Right! The secret number is " + solution + " ( " + game.getCount() + " times )");
	}
}
