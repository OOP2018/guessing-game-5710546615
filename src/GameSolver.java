
public class GameSolver {
	public int play (NumberGame game) {
		System.out.println( game.toString() );
		System.out.println( game.getMessage() );
		
		int guess = 0;
		boolean correct = false;
		int up = game.getUpperBound();
		int down = 1;
		String msg = "";
		
		for(int i=0;i<game.getUpperBound();i++) {
			
			if(correct) {
				break;
			} 
			
			guess = (up + down)/2;
			System.out.print("Your answer? " + guess + "\n");
			correct = game.guess(guess);
			
			msg = game.getMessage();
			if(msg.contains("small")) {
				down = guess;
			} else if (msg.contains("large")) {
				up = guess;
			}
			if(!correct) System.out.println(msg);
		
		}
		return guess;
	}
}
