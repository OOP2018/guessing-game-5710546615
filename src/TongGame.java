import java.util.Random;

public class TongGame extends NumberGame {
	private int upperBound;
	private int secret;
	private int count = 0;

	public TongGame(int upperBound) {
		this.upperBound = upperBound;
		long seed = System.nanoTime();
		Random rand = new Random(seed);
		this.secret = rand.nextInt(this.upperBound) + 1;
		super.setMessage("I'm thinking of a number betwenn 1 and " + this.upperBound);
	}

	public boolean guess(int number) {
		count++;
		if (number == secret) {
			return true;
		} else if (number < secret) {
			setMessage("Your answer is too small.");
		} else /* if (number > secret) */ {
			setMessage("Your answer is too large.");
		}
		return false;
	}

	public int getUpperBound() {
		return upperBound;
	}

	public String toString() {
		return "TongGame is running ...";
	}
	
	public int getCount() {
		return count;
	}

}
