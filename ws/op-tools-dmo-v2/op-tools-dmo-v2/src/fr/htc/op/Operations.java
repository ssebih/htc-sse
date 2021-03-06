package fr.htc.op;

import java.util.Scanner;

public class Operations {
	Scanner scan = new Scanner(System.in);
	private static EquationSecondDegre Eq = new EquationSecondDegre();
	private static Factoriel Fact = new Factoriel();
	private static MaxArray Max = new MaxArray();
	private static AvgEquartType Aveq = new AvgEquartType();
	private static Add Ad = new Add();
	private static Pgdc Pgdc = new Pgdc();
	
	
	
	public void EquationSecondDegre() {
		Eq.eqationSecondDegre();
		
		
	}

	public void factoriel() {
		System.out.println("FACTORIEL");
		Fact.factoriel();
	}

	public void pgcd() {
		System.out.println("PGCD");
		Pgdc.pgdc();
	}

	public void maxArray() {
		System.out.println("MAX_ARRAY");
		Max.maxArray();
	}

	public void avgAndEquartType() {
		System.out.println("AVG_EQUART_TYPE");
		Aveq.avgequartype();
	}

	public void personList() {
		Person persons[] = getArrayWithUserSize();
		setUpPersonArrayList(persons);
		printPersonList(persons);
	}

	private void printPersonList(Person[] persons) {
		String s = persons.length == 1 ? "" : "s";
		System.out.println("Voici la liste de" + s + " personne" + s + " : ");
		for (Person p : persons)
		
			System.out.println(p);
		
	}

	private void setUpPersonArrayList(Person[] persons) {
		for (int i = 0; i < persons.length; i++) {
			System.out.println("Entrer la personne N? " + (i + 1));
			Person p = new Person();
			System.out.print("Prenom : ");
			p.setFirstName(scan.next());
			System.out.print("Nom : ");
			p.setLastName(scan.next());
			System.out.print("Age : ");
			p.setAge(scan.nextInt());

			persons[i] = p;
		}
	}

	private Person[] getArrayWithUserSize() {
		System.out.print("PERSON_LIST \n "
				+ "Entrer le nombre de personnes : ");
		return new Person[scan.nextInt()];
	}

	public void add() {
		System.out.println("ADD : 2 numbers ");
		Ad.add();
	}

	public void exit() {
		System.out.println("Good bye !!!");
		scan.close();
	}

}
