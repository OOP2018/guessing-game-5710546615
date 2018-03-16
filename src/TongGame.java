import java.util.Random;

/**
 * Game of guessing a secret number.
 * 
 * @author Visurt Anuttivong
 */
public class TongGame extends NumberGame {

	/** The largest possible value. */
	private int upperBound;

	/** The secret number. */
	private int secret;

	/** The count. Default is 0. */
	private int count = 0;

	private int guessed;

	/**
	 * Initialize a new TongGame.
	 *
	 * @param upperBound the max value for the secret number (>1).
	 * 
	 */
	public TongGame(int upperBound) {
		this.upperBound = upperBound;
		long seed = System.nanoTime();
		Random rand = new Random(seed);
		this.secret = rand.nextInt(this.upperBound) + 1;
		super.setMessage("I'm thinking of a number between 1 and " + this.upperBound);
	}

	/**
	 * Evaluate a user's guess. Also set a message to help the user.
	 * 
	 * @param number the user's answer, as an integer.
	 * @return true if it is correct, false otherwise.
	 */
	public boolean guess(int number) {
		count = count + 1;
		guessed = number;
		if (number == secret) {
			setChanged();
			notifyObservers();
			return true;
		} else if (number < secret) {
			setMessage("Your answer is too small.");
		} else /* if (number > secret) */ {
			setMessage("Your answer is too large.");
		}

		setChanged();
		notifyObservers();
		return false;
	}

	/**
	 * Get the largest possible value of the solution for this game. For a guessing
	 * game, this should be the upper bound of secret.
	 * 
	 * @return the upper bound
	 */
	public int getUpperBound() {
		return upperBound;
	}

	/**
	 * Describes the game.
	 * 
	 * @return Description of the game
	 */
	public String toString() {
		return "TongGame is running ...";
	}

	/**
	 * Get the count.
	 * 
	 * @return count the count of game.
	 */
	public int getCount() {
		return count;
	}

	/**
	 * Get user's guess number.
	 * 
	 * @return guessed number
	 */
	public int getGuessed() {
		return guessed;
	}
}