package fr.htc.op;

import java.util.Scanner;

public class MaxArray {
	public void maxArray() {

		int i = 1, max = 0;
		Scanner scanner = new Scanner(System.in);

		System.out.println("Bievenue � l'application qui vous permet de calculer le maximum de votre s�rie de nombre ");
		System.out.print("entrez votre nombre d'�l�ments dans votre s�rie  svp !");
		int nbre = scanner.nextInt();

		int[] tab = new int[nbre];
		
		for (i = 0; i < nbre; i++) {
			System.out.print("entrez le nouveau nombre de votre s�rie svp ! : ");
			tab[i] = scanner.nextInt();

		}

		max = tab[0];

		for (i = 1; i < nbre; i++) {
			if (tab[i] > max) {
				max = tab[i];
			}
		}
	}
}