package fr.htc.op;

import java.util.Scanner;

public class AvgEquartType {

	public void avgequartype() {
		Scanner scanner = new Scanner(System.in);

		System.out.println(
				" Bienvenue au volet de l'application qui vous permettra de calculer la moyenne et l'écartype");
		System.out.print("le calcul concernera combien de valeurs exactement ? ");

		int nbre = scanner.nextInt();
		int tab[] = new int[nbre];

		for (int i = 0; i < nbre; i++) {
			System.out.println("Entrez la nouvelle valeur de votre série");
			tab[i] = scanner.nextInt();
		}
		float som = 0;

		for (int i = 0; i < nbre; i++) {
			som = som + tab[i];
		}
		double m = som / nbre;
		System.out.println("la moyenne de ces nombres est : " + m);

		double somm = 0;
		double somme = 0;

		for (int i = 0; i < nbre; i++) {

			somm = somm + Math.pow((tab[i]), 2);
			somme = Math.pow((somme + tab[i]) / nbre, 2);
		}
		double eca = Math.pow(((somme, nbre) / nbre) - somme, 1/2);
		System.out.println("l'écartype est : " + eca);
	}
}
