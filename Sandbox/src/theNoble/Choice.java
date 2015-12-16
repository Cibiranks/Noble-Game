package theNoble;

/**
 * Each choice has these variables that must be declared in TheNoble
 * m bnmjbhjmghj
 * @author 499224001
 *
 */
public class Choice {

	String description;
	String name;
	int points;
	Scenario nextScenario;
	int health;
	int money;

	public Choice(String description, String name, int points,
			Scenario nextScenario, int health, int money) {
		this.description = description;
		this.name = name;
		this.points = points;
		this.nextScenario = nextScenario;
		this.health = health;
		this.money = money;
	}

	public String toString() {
		return description;
	}

}
