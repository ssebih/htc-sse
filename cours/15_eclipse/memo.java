
/* 1) programme permettant d'afficher la table d'ascii, les caractères codés*/
package htc.salim.addition;

public class SalimAddition {
	public static void main(String[] args) {
		System.out.println("Bonjour je révise java");
		 char a; 
		 char b;
		 int c; 
		a='b'; //a contient la lettre 'a'
		b='\u0045'; //'u0022';b contient le caractère guillemet :
		c=97; //x contient le caractère de rang 97 : a
	
	System.out.println(b);
	}
	
	

}
 /* programme permettant de comparer deux entier et de dire lquel est plus grand*/
 package htc.salim.addition;

import java.util.Scanner;

public class SalimAddition {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in); // entrée standard clavier iverse de sortie standard system.out
		System.out.println("entrez une valeur :");
		int nb1 = scanner.nextInt(); // methode blocante car elle attend la saisi de l'utilisateur
		System.out.println(nb1);
		System.out.println("entrez une autre valeur");
		int nb2 = scanner.nextInt(); // methode blocante car elle attend la saisi de l'utilisateur
		System.out.println(nb2);
		if (nb1 < nb2) {
			System.out.println("l'entier le plus grand est " + nb2);
		} else {
			System.out.println("l'entier le plus grand est " + nb1);

		}
		scanner.close();// fermeture de scanner
	}
}



