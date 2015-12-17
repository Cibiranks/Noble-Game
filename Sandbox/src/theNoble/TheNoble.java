package theNoble;

import java.util.ArrayList;
import java.util.Scanner;

public class TheNoble {

	public static ArrayList<Scenario> world = new ArrayList<Scenario>();
	public static Player player = new Player();

	/**
	 * TODO finish story line Figure out how to integrate intelligence How to
	 * display text if their choice isnt available Add a battle scene
	 **/
	public static void main(String[] args) {

		String playAgain = "";
		do {// This do loop is for the reset
			// Build your user interface
			reset();
			System.out.println(intro()); // intro in to the game giving
											// backstory
			createYourCharacter(player, 9);// Some Character stats are changed.
											// Specific player passed in along
											// with
											// how many changes available
			initializeScenarios();// Initialize our scenario descriptions and
									// the
									// choices available

			player.scenario = world.get(0); // We start off in the first world
			do {
				System.out.println(player.scenario); // Prints out the scenario
														// that
														// the player is in
				System.out.println("What would you like to do?");
				String choice = Keyboard.keyb.nextLine();
				for (Choice c : player.scenario.choices) { // The choices in the
															// current player
															// scenario
					if (c.name.equalsIgnoreCase(choice)) {
						player.points += c.points;// Add the points to the
													// players
													// points
						player.health += c.health;// " " but health
						player.money += c.money;// "" but money
						player.scenario = c.nextScenario;// but "" scenario
					}
				}
				System.out
						.println("You now have " + player.points + " points.");
				if (player.health < 100) {// Only if health changes print out
					System.out.println("Your health is " + player.health);
				}
				System.out.println("You have " + player.money + " dollars");// print
																			// out
																			// your
																			// money
				System.out
						.println("=========================================================================================================");
			} while (player.isAlive()); // do this while the player is alive

			System.out
					.println("Your choices have led you to an unfortunate death. Try again and save the princess!!!!");
			do {
				System.out.println("Play Again? (y/n)");
				playAgain = Keyboard.keyb.nextLine();
			} while (!(playAgain.equalsIgnoreCase("y") || playAgain
					.equalsIgnoreCase("n"))); // only continue if y or n are the
												// typed characters.
		} while (playAgain.equalsIgnoreCase("Y"));

	}

	/**
	 * Beginning scene in which we get the users name A short summary of the
	 * relationship between the noble and the princess
	 * 
	 * @return returning the players username, introducing him as the noble
	 */
	public static String intro() {
		System.out
				.println("\n18 years ago, she walked past me for the first time. The Princess walked past me for the first time and I fell in"
						+ " love. But she has never noticed me because I am just a lowly Noble. \nHowever, today here at the grand feast I will make sure"
						+ " she notices me. I will make sure she finds out my name. \nWhat is your name?");
		player.userName = Keyboard.keyb.nextLine(); // get name
		return "My name is " + player.userName + ", I am a Noble.";
	}

	/**
	 * Creating the stats used in some of the game mechanics in the game
	 * 
	 * @param player
	 *            Taking in the player that was created
	 * @param numOfChange
	 *            Maximum amount of adjustments we can make
	 */
	public static void createYourCharacter(Player player, int numOfChange) {
		int addInches = 0;// The variables that will adjust our player stats,
							// height
		int addWeight = 20;// weight
		int divideTen;// A unit to change our number of change
		System.out
				.println("\nWelcome to the character creation. The changes you make to your character affect your in game stats."
						+ " You have "
						+ numOfChange
						+ " number of changes available to you.");
		System.out
				.println("You are currently 6 feet and 0 inches. How many inches would you like to add. Maximum is "
						+ numOfChange);// maximum amount of adjustments you can
										// make to your character

		do {
			try {
				addInches = Integer.parseInt(Keyboard.keyb.nextLine());
			} catch (Exception e) {// To make sure they type in a number
				System.out.println(e);
				System.out.println("Please pick a number.");
				addInches = -1;// To reset the do loop
			}
		} while (addInches < 0 || addInches > numOfChange);

		player.heightInches += addInches;// adjust player height
		numOfChange -= addInches; // change our maximum amount of changes
		if (player.heightInches > 6) {// Change intimidation according to player
										// height
			player.intimidation += 50;
		} else if (player.heightInches < 6 && player.heightInches > 1) {
			player.intimidation += 30;
		} else {
			player.intimidation += (Math.random() * (20 - 1)) + 1;
		}
		System.out.println("Your player is now " + player.heightFeet
				+ " feet and " + player.heightInches + " inches");
		System.out
				.println("You are currently "
						+ player.weight
						+ "lbs. How many pounds would you like to add? You"
						+ " can only increment the weight by 10 pounds. Maximum amount of changes left is "
						+ numOfChange);
		do {
			addWeight = Integer.parseInt(Keyboard.keyb.nextLine());
			divideTen = addWeight / 10;
		} while (addWeight % 10 != 0 || divideTen < 0
				|| divideTen > numOfChange);
		player.weight += addWeight;
		numOfChange -= divideTen;
		if (player.weight >= 200) {
			player.strength += 40;
		} else if (player.weight >= 170 && player.weight < 200) {
			player.strength += 20;
		} else {
			player.strength += 10;
		}
		System.out.println("You are now " + player.weight + "lbs.");
		System.out.println("Your intimidation is now equal to "
				+ player.intimidation);
		System.out.println("Your strength is now equal to " + player.strength);
	}

	/**
	 * Create the scenario and choices.
	 */
	public static void initializeScenarios() {
		int count = 10; // amount of scenarios we can have
		Choice c1, c2, c3, c4, c5, c6; // the possible choices we have
		Scenario[] s = new Scenario[count]; // An array that creates scenarios
											// based on our count variable
		for (int i = 0; i < count; i++) {
			s[i] = new Scenario();
		}
		// The First Scenario
		s[0].description = "\n----------- \n|The Noble|\n----------\n"
				+ "Would you like to start the game (type -play-) or view the information (type -info-)?";// The
																											// scenario
																											// that
																											// will
																											// give
																											// the
																											// player
																											// choices
		c1 = new Choice("\n\"Play\"", "play", 0, s[2], 0, 0);// A choice that
																// has the
																// description,
																// what they
																// need to type,
																// amount of
																// points they
																// will recieve,
																// theyre next
																// scenario,
																// health and
																// money
		c2 = new Choice("\"Info\"", "info", 0, s[1], 0, 0);
		s[0].choices.add(c1);// adding choices to the world
		s[0].choices.add(c2);
		world.add(s[0]);// Add the scenario to the world

		// The Second Scenario
		s[1].description = "\nYou are playing as a Noble who finds out your one love, the Queen, has been kidnaped by an unknown"
				+ " group. Your goal is to save the Queen and in the process not kill yourself. \nEach of the choices you make in "
				+ "this game are worth points. Some choices are worth more than the others. Make the right decision.\n"
				+ "Any words in between two \"-\" signs are your options. You must type in one of the options to advance. \n"
				+ "Would you like to return? (type -yes- to return)";
		c1 = new Choice("\n\"Yes\"", "yes", 0, s[0], 0, 0);
		s[1].choices.add(c1);
		world.add(s[1]);

		// The Third Scenario
		s[2].description = "\n*Roof Breaking sound* \nAHHHHHHHHHHHHHHHHHHHHHHHHHHHH \nWhat was that? Who screamed?"
				+ "          \n- Crowd Mumbling";
		c1 = new Choice("\n\"Investigate\"", "investigate", 2, s[3], 0, 0);
		c2 = new Choice("\"Ask \"", "ask", 1, s[4], 0, 0);
		s[2].choices.add(c1);
		s[2].choices.add(c2);
		world.add(s[2]);

		// The Fourth Scenario
		s[3].description = "\n"
				+ player.userName
				+ " runs to where the scream came from... \n You comes across a door in which he can"
				+ " hear screams. You try to open the door, but it is locked. \" STAY OUT SCUM! \" someone yells from the other side.";
		c1 = new Choice("\n\"Call\" the gatekeeper", "call", 2, s[5], 0, 0);
		c2 = new Choice("\"Bash\" the door by running at it", "bash", 1, s[6],
				-20, 0);
		s[3].choices.add(c1);
		s[3].choices.add(c2);
		world.add(s[3]);

		// The Fifth Scenario
		s[4].description = "\nYou start to ask around, but everyone is just as confused as you. \n\"Hey, are you wondering where that"
				+ " scream came from? You should check upstairs. That is where I think it came from.\"";
		c1 = new Choice("\n\"Run\" to where the scream came from", "run", 0,
				s[3], 0, 0);
		s[4].choices.add(c1);
		world.add(s[4]);

		// The Sixth Scenario, introduction to the enemy
		s[5].description = "\n\"GATTEEEKEEPPPER. I need the keys to the master bed room upstairs in the palace. Someone needs help!\""
				+ "-"
				+ player.userName
				+ "\n You may take them. Return the keys in the same condition they are in right now. \n You run back to the room and"
				+ " open the door with the key. Two people in black cloaks and one in purple look right at you with someone tied up. \n\"HOW DID HE GET IN HERE MARTY?\" -???"
				+ "\n\"I don't know savannah!\" -Marty\n\"It doesn't matter. He doesn't know who we are anyways. Lets get out of here.\" -Savannah"
				+ "\n\"HEEEELLLPPPP\" - The Princess \n\"Is that the princess!?\" -"
				+ player.userName
				+ "\n\"SHUT UP. YOU CANT HELP HER!\" -Savannah"
				+ "\n\"LET HER GO RIGHT NOW!\" -"
				+ player.userName
				+ "\n\"Remember us. We are the Wanderers.\" - Man in Purple Cloak"
				+ "\nThey took the princess and leaped out of the window on to an air ballon. \n\"STOP LET HER GO\" -"
				+ player.userName + "\n\"HELP ME PLEASE NOBLE\" - The Princess";
		c1 = new Choice("\n\"Jump\" for the balloon", "jump", 0, s[0], -100, 0);
		c2 = new Choice("\"Look\" to where they head off to", "look", 2, s[7],
				0, 0);
		s[5].choices.add(c1);
		s[5].choices.add(c2);
		world.add(s[5]);

		s[6].description = "\nYou back up and charge in to the door.\nYou wake up an hour later with an head injury in the infirmary.";
		c1 = new Choice("\n\"Ask\" the doctor about what happened", "ask", 2,
				s[8], 0, 0);
		c2 = new Choice("\"Walk\" out of the infirmary", "walk", 1, s[8], 0, 0);
		s[6].choices.add(c1);
		s[6].choices.add(c2);
		world.add(s[6]);

		//s[7].description = "\n\"
	}

	/**
	 * To reset the player variables
	 */
	public static void reset() {
		player.points = 0;
		player.health = 100;
		player.heightInches = 0;
		player.money = 0;
		player.strength = 10;
		player.weight = 130;
		player.intimidation = 50;
	}
}
