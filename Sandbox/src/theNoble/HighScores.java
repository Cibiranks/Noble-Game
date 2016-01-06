package theNoble;

public class HighScores {
	
	static final String HIGHSCOREFILE = "highscores.txt";
	static HighScore[] highScores = new HighScore[3];

	public static boolean submitHighScore(Player p) {
		// Get the list of high scores
			// open the file
			// read in the scores
		
		// Insert the submitted score if high enough
			// loop through the scores and see if the player has a high score
			// if high score, update the list and return true
			// if not, return false
		return false;
	}
	
//	public int getHighScore() {
//		return TheNoble.player.points;
//	}
//	
//	public String getName() {
//		return TheNoble.player.userName;
//	}
	
	/**
	 * Read the high score data into the array
	 */
	public void readHighScores() {
		
	}
	
}

class HighScore {
	String name;
	int score;
}
