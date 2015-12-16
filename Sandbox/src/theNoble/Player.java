package theNoble;

//The Player has these variables that will effect how the game plays
public class Player {
	Scenario scenario;
	int points;
	double money;
	double health = 100;
	String userName;
	int heightFeet = 6;
	int heightInches;
	int intimidation = 50;
	int weight = 130;
	int strength = 10;
	int intelligence;

	public boolean isAlive() {
		return health > 0;
	}
}
