package hr.fer.oop.lab4.prob1;
/**
 * Demonstracija prvog zadatka 4. lab vjezbe iz OOP2015.
 *
 */
public class Demonstration {
	public static void main(String[] args) {

		System.out.println("Stvaranje novog igraèa...");
		FootballPlayer pikso = null;
		try {
			pikso = new FootballPlayer("Pikso", "Croatia", 67, -1, PlayingPosition.FW);
		} catch (IllegalArgumentException e) {
			System.out.println("Greška: " + e.toString() + "\nOporavak od pogreške..");
			pikso = new FootballPlayer("Pikso", "Croatia", 77, 85, PlayingPosition.FW);
		}
		System.out.println("Stvaranje novog trenera...");
		Coach klopp = null;
		try {
			klopp = new Coach(null, "Germany", 99, 85, Formation.F442);
		} catch (IllegalArgumentException e) {
			System.out.println("Greška: " + e.toString() + "\nOporavak od pogreške..");
			klopp = new Coach("Klopp", "Germany", 99, 85, Formation.F442);
		}

		Person[] persons = { pikso, klopp };
		System.out.println("Country, Name, Emotion");
		for (Person person : persons) {
			System.out.println(person.getCountry() + ", " + person.getName() + ", " + person.getEmotion());
		}

	}
}