package fr.htc.op;

import java.util.Scanner;

public class Personnes {
	public String nom ;
	public String prenom ;
	public int age = 0;
	public Personnes (String nom, String prenom, int age) {
		this.age = age;
		this.nom= nom;
		this.prenom=prenom;
		
	}
}

public class TestProg {
	

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("combien de personnes avez vous pour enregistrer ?");
		int nbre = scanner.nextInt();
		Personnes tab[];
		tab = new Personnes[nbre];
		for (int i =0; i<tab.length; i++) {
			System.out.print("entrez le nom : ");
			String nom = scanner.next();
			
			
			tab [i] = [nom, prenom, age];
			
		}
		
		
		
		System.out.println(" Bienvenue au volet de l'application qui vous \n"
				+ " permettra de rentrez la nouvelle liste de personne");
		
		
		int a = scanner.nextInt();
		Persons[] tabPerson  = new Person [a] ;
		
		for (int i = 0; i < tabPerson.length; i++) {
			firstName = scanner.next();
			lastName= scanner.next();
			age = scanner.nextInt();
			tabPerson [i] = 
		}
		

	}
}
