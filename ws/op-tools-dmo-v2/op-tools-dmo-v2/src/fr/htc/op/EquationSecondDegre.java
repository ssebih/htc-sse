package fr.htc.op;

import java.util.Scanner;

public class EquationSecondDegre {

	public void eqationSecondDegre() {

		Scanner scanner = new Scanner(System.in); // (il ne faut jamais le fermer sinon on sera dans une erreur et le
													// programme beugue)
		int delta = 0;

		System.out.println(
				"Bienvenue au volet qui vous permettra de trouver une solution à votre équation du ème degré ax2 + bx + c = 0 ");

		System.out.print("entrez la valeur de a svp ! ");
		int a = scanner.nextInt();

		System.out.print("entrez la valeur de b svp ! ");
		int b = scanner.nextInt();

		System.out.print("entrez la valeur de c svp ! ");
		int c = scanner.nextInt();

		if (a == 0 && b == 0) {
			System.out.println("solution impossible");
		} else if (a == 0 && b != 0) {

			float x = -c / b;
			System.out.println("la solution est x = :" + x);
		}

		if (a != 0 && b != 0) {
			delta = b * b - (4 * a * c);
		}
		if (delta < 0) {
			System.out.println("solution impossible dans la logique");

		} else if (delta == 0) {
			float x = -b / (2 * a);
			System.out.println("la solution est x = :" + x);
		} else {
			double x = (-b - Math.sqrt(delta)) / 2 * a;
			System.out.println("l'équation amdet deux solutions +x et -x" +x);

		}

	}

}
