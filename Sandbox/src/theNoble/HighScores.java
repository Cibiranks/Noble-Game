package theNoble;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class HighScores {

	static final String HIGHSCOREFILE = "highscores.txt";
	static HighScore[] highScores = new HighScore[3];

	public static boolean submitHighScore(Player p) {

		// Get the list of high scores
		// open the file
		PrintWriter outputStream = null;
		try {
			// Create a new file
			outputStream = new PrintWriter(new FileWriter(HIGHSCOREFILE));
			outputStream.println(TheNoble.player.userName);
			outputStream.println(TheNoble.player.points);
		} catch (IOException ex) {
			System.out.println(ex);
		}
		// Close the file if it is open
		if (outputStream != null) {
			outputStream.close();
		}
		// read in the scores
		BufferedReader inputStream = null;
		try {
			inputStream = new BufferedReader(new FileReader(HIGHSCOREFILE));
			System.out.println(inputStream.readLine());
		} catch (FileNotFoundException ex) {
			System.out.println(ex);
		} catch (IOException ex) {
			System.out.println(ex);
		}
		// Close the file if it's open
		if (inputStream != null) {
			try {
				inputStream.close();
			} catch (IOException ex) {
				System.out.println(ex);
			}
		}
		// Insert the submitted score if high enough
		if(TheNoble.player.points > 0){
			highScores[0].name = TheNoble.player.userName;
			highScores[0].score = TheNoble.player.points;
		}
		// loop through the scores and see if the player has a high score
		// if high score, update the list and return true
		// if not, return false
		return false;
	}

	// public int getHighScore() {
	// return TheNoble.player.points;
	// }
	//
	// public String getName() {
	// return TheNoble.player.userName;
	// }

	/**
	 * Read the high score data into the array
	 */
	public void loadHighScores() {

	}

}

class HighScore {
	String name;
	int score;
}
