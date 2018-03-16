import java.util.Scanner;

/**
 * Play guessing game on the console.
 * 
 * @author Visurt Anuttivong
 */
public class GameConsole {

	/**
	 * The play method plays a game using input from a user.
	 *
	 * @param game the NumberGame to solve.
	 * @return guess the correct number.
	 */
	public int play(NumberGame game) {
		Scanner console = new Scanner(System.in);

		// describe the game
		System.out.println(game.toString());
		System.out.println(game.getMessage());

		int guess;
		boolean correct;

		do {
			System.out.print("Your answer? ");
			guess = console.nextInt();
			correct = game.guess(guess);

			if (!correct)
				System.out.println(game.getMessage());
		} while (!correct);

		return guess;
	}
}
