/**
 * Automatically find the secret to any NumberGame.
 */
public class GameSolver {

	/**
	 * Play a NumberGame and return the solution. The NumberGame object must provide
	 * messages (getMessage) containing the phrase "too small" if a guess is too
	 * small and "too large" if a guess is too large, for efficient solution.
	 *
	 * @param game
	 *            the NumberGame to solve
	 * @return guess the correct number.
	 */
	public int play(NumberGame game) {

		int guess = 0;
		boolean correct = false;
		int max = game.getUpperBound();
		int min = 1;
		String msg;

		// describe the game
		System.out.println(game.toString());
		System.out.println(game.getMessage());

		while (!correct) {
			guess = min + (max - min)/2;
			
			System.out.print("Your answer? " + guess + "\n");
			correct = game.guess(guess);
			msg = game.getMessage();

			if (!correct) {
				System.out.println(msg);
				if (msg.contains("small")) {
					min = guess + 1;
				} else /* if (msg.contains("large") */ {
					max = guess - 1;
				}
			}
		}
		return guess;
	}
}