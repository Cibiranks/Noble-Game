package theNoble;

public class Enemy {
	String name;
	String type;
	int attack;
	int defence;
	int health;
	
	public Enemy(String type) {
		if(type.equalsIgnoreCase("wizard")){
			attack = 8;
			defence = 2;
			health = 20;
		}
		if(type.equalsIgnoreCase("brawler")){
			attack = 4;
			defence = 4;
			health = 40;
		}
		if(type.equalsIgnoreCase("juggernaut")){
			attack = 2;
			defence = 8;
			health = 60;
		}
		if(type.equalsIgnoreCase("wanderSavannah")){
			attack = 17;
			defence = 10;
			health = 70;
		}
		if(type.equalsIgnoreCase("wanderMarty")){
			attack = 25;
			defence = 15;
			health = 50;
		}
		if(type.equalsIgnoreCase("wanderLeader")){
			attack = 40;
			defence = 25;
			health = 85;
		}
	}
}
