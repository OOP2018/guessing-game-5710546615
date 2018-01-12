import java.util.Scanner;

/** 
 *  Play guessing game on the console.
 */
public class GameConsole {

	/** play the game. */
	public int play(NumberGame game) {
		Scanner console = new Scanner(System.in);
		
		// describe the game
		System.out.println( game.toString() );
		System.out.println( game.getMessage() );
		
		int guess;
		boolean correct;
		
		do {
			System.out.print("Your answer? ");
			guess = console.nextInt();
			correct = game.guess(guess);
			if(!correct) System.out.println( game.getMessage() );
		} while (!correct);
		
		return guess;
	}
	
}
