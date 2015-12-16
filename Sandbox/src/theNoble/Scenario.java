package theNoble;

import java.util.ArrayList;
import java.util.Scanner;

public class Scenario {

	public String name;// each scenario has a name
	public String description;// a description
	public ArrayList<Choice> choices = new ArrayList<Choice>();// And choices
																// created by an
																// array list

	public String toString() {
		String result = description + "\n"; // Return the description as a
											// string
		for (Choice c : choices) {
			result += c.description + "\n"; // Return the choices description as
											// a string
		}
		return result;
	}

}
