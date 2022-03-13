package fr.htc.op;

import java.util.Scanner;

public class Add {

	public void add() {
		Scanner scanner1 = new Scanner (System.in);
		
		System.out.print("Entrer le nombre 1 : ");
		int n1 = scanner1.nextInt();
		System.out.print("Entrer le nombre 2 : ");
		int n2 = scanner1.nextInt();
		int somm = n1 + n2;
		System.out.println("La somme des deux nombres est " + somm);
	scanner1.close();
	}
}
