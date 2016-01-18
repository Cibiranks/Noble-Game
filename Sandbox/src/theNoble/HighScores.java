package theNoble;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class HighScores {

	static final String HIGHSCOREFILE = "highscores.txt";
	public HighScore[] highScores = new HighScore[3];
	
	HighScores() {
		loadHighScores();
	}

	public boolean submitHighScore(Player p) {
		boolean newHighScore = false;
		// Get the list of high scores
		// open the file
		PrintWriter outputStream = null;
		try {
			// Create a new file
			outputStream = new PrintWriter(new FileWriter(HIGHSCOREFILE));
			// insert the player's score into the highscores variable
			if (TheNoble.player.points > highScores[0].score) {
				highScores[2].name = highScores[1].name;
				highScores[2].score = highScores[1].score;
				highScores[1].name = highScores[0].name;
				highScores[1].score = highScores[0].score;
				highScores[0].name = TheNoble.player.userName;
				highScores[0].score = TheNoble.player.points;
				newHighScore = true;
			} else if (TheNoble.player.points < highScores[0].score
					&& TheNoble.player.points > highScores[1].score) {
				highScores[2].name = highScores[1].name;
				highScores[2].score = highScores[1].score;
				highScores[1].name = TheNoble.player.userName;
				highScores[1].score = TheNoble.player.points;
				newHighScore = true;
			} else if (TheNoble.player.points < highScores[1].score
					&& TheNoble.player.points > highScores[2].score) {
				highScores[2].name = TheNoble.player.userName;
				highScores[2].score = TheNoble.player.points;
				newHighScore = true;
			}
			// loop through the highscores and output to the file
			for (HighScore h : highScores) {
				outputStream.println(h.name);
				outputStream.println(h.score);
			}
		} catch (IOException ex) {
			System.out.println("ERR:" + ex);
		}
		// Close the file if it is open
		if (outputStream != null) {
			outputStream.close();
		}
//		// read in the scores
//		try {
		return newHighScore;
//			inputStream = new BufferedReader(new FileReader(HIGHSCOREFILE));
//			System.out.println(inputStream.readLine());
//		} catch (FileNotFoundException ex) {
//			System.out.println(ex);
//		} catch (IOException ex) {
//			System.out.println(ex);
//		}
//		// Close the file if it's open
//		if (inputStream != null) {
//			try {
//				inputStream.close();
//			} catch (IOException ex) {
//				System.out.println(ex);
//			}
//		}
		// Insert the submitted score if high enough

		// loop through the scores and see if the player has a high score
		// if high score, update the list and return true
		// if not, return false

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
		for (int i = 0; i < highScores.length; i++) {
			highScores[i] = new HighScore();
		}
		BufferedReader inputStream = null;
		String line = "";
		try {
			if (!HIGHSCOREFILE.trim().equals("")) {
				// Attempt to open the file
				inputStream = new BufferedReader(new FileReader(HIGHSCOREFILE));
				// Loop until the line read from the file
				// is null, which means the end of the file
				for (int i = 0; i < highScores.length; i++) {
					line = inputStream.readLine();
					highScores[i].name = line;
					line = inputStream.readLine();
					highScores[i].score = Integer.parseInt(line);

				}
				inputStream.close();
			}
		} catch (Exception ex) {
			// For now, just output the error message
			System.out.println("ERROR:" + ex);
		}
	}
}

class HighScore {
	String name;
	int score;
}
