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

		while (!correct) {
			guess = min + (max - min)/2;
			
			correct = game.guess(guess);

			if (!correct) {
				if (game.getMessage().contains("small")) {
					min = guess + 1;
				} else /* if (msg.contains("large") */ {
					max = guess - 1;
				}
			}
		}
		return guess;
	}
}