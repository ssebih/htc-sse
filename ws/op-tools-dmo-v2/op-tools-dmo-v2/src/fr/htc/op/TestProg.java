package fr.htc.op;

import java.util.Scanner;

public class TestProg {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println(
				" Bienvenue au volet de l'application qui vous permettra de calculer /n"
				+ "le Plus Grand Dénominateur Commun de deux nombres (PGCD)");
		
		System.out.print("Entrez le premier nombre s'il vous plait ! ");
		int nbre = scanner.nextInt();
		
		
		System.out.print("Entrez le deuxieme nombre s'il vous plait ! ");
		int nbree = scanner.nextInt() ;
		if (nbree = 0) {
			System.out.println("Le PGCD est " +nbre);
		}
		else {
			int rest = 0;
			while (nbree !=0) {
				if ( nbree > nbre) {
					rest = nbree;
					rest = Math.floorMod(nbree, nbre);
					
				}
				else {
					
					
				}
				
			}
			
		}
		
		

		
	}

}
