package fr.htc.op;

import java.util.Scanner;

public class Factoriel {

	public void factoriel() {

		int factoriel = 1;
		int i = 1;
		
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Bievenue à l'application qui vous calcule le factoriel de votre nombre au choix ");
		System.out.print("entrez votre nombre svp !");
		
		int n = scanner.nextInt();
		
		while (i <= n) {
			factoriel = factoriel * i;
			i++;
		}

		System.out.println("la factorielle de " + n + " est de " + factoriel);

	}
}
