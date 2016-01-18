package theNoble;

public class Enemy {
	String name;
	String type;
	int attack;
	int defence;
	int health;

	public Enemy(String type) {
		if (type.equalsIgnoreCase("wanderSavannah")) {
			attack = 17;
			defence = 10;
			health = 70;
		}
		if (type.equalsIgnoreCase("wanderMarty")) {
			attack = 25;
			defence = 15;
			health = 50;
		}
		if (type.equalsIgnoreCase("wanderLeader")) {
			attack = 40;
			defence = 25;
			health = 85;
			name = "Z";
		}
	}
}
