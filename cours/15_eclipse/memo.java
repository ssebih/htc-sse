
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
 /*2) programme permettant de comparer deux entier et de dire lquel est plus grand*/
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

/* 3)Programme permmetant de calculer la factorielle d'un entier rentré par un utilisateur (boucle while)*/

package htc.salim.java.factoriel;

import java.util.Scanner;

public class Factoriel {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		long n, result = 1, i;
		System.out.println("entrez la valeur de n pour caclculer sa factorielle");
		n = scanner.nextInt();

		i = n;
		while (i > 1) {
			result = result * i;
			i--; // décrémentation de 1
		}
		System.out.println("la fact de 5" + n + " vaut " + result);
		scanner.close();

	}

}

/* 4)Programme permmetant de calculer la factorielle d'un entier rentré par un utilisateur (boucle while)*/


package htc.salim.java.factoriel;

import java.util.Scanner;

public class Factoriel {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		long n, result = 1 , i;
		System.err.println("entrez la valeur de n pour caclculer sa factorielle");
		n = scanner.nextInt();

		for (i = 1 ; i <= (n-1); i++) // boucle for, ++i veut dire incrémentation de 1
		{result = result * (i +1);
			
		}
		System.out.println("la fact de " + n + " vaut " + result);
		scanner.close();

	}

}


/* 5) afficher les nombres de 1 à 10 (boucle for) */
package htc.salim.java.factoriel;

import java.util.Scanner;

public class Factoriel {

	public static void main(String[] args) {
		
		for (int i = 1 ; i<= 10; i++) { // pour changer le pas d'incrémentation il faut écrire i+= 2 (pas 2)
		
		System.out.println(i);
		}

	}

} 

/* 6) afficher les nombres de 1 à 10 (boucle while) */

package htc.salim.java.factoriel;

import java.util.Scanner;

public class Factoriel {

	public static void main(String[] args) {

		int i = 1;
		while (i <= 10) {

			System.out.println(i);
			i++; // incrémentation (pour changer le pas d'incrémentation il faut mettre i+=2 (pas =2)
		}
	}

}
