package fr.htc.op;

import java.sql.Date;
import java.util.Scanner;

public class MenuLuncher {

	static Scanner scanner = new Scanner(System.in);
	static Scanner scannerWait = new Scanner(System.in);
	private static Operations op = new Operations();
	static final int EQUTION_SECOND_DEGRE = 1;
	static final int FACTORIEL = 2;
	static final int PGCD = 3;
	static final int MAX_ARRAY = 4;
	static final int AVG_EQUART_TYPE = 5;
	static final int PERSON_LIST = 6;
	static final int ADD = 7;
	static final int EXIT = 0;
	static final int DATE = 8;

	public static void main(String[] toto) {
		int choice = -1;
		do {
			printMenu();
			// choix de l'utilisateur
			choice = scanner.nextInt();
			// Swithc
			switch (choice) {
			case EQUTION_SECOND_DEGRE:
				op.EquationSecondDegre();
				break;
			case FACTORIEL:
				op.factoriel();
				break;
			case PGCD:
				op.pgcd();
				break;
			case MAX_ARRAY:
				op.maxArray();
				break;
			case AVG_EQUART_TYPE:
				op.avgAndEquartType();
				break;
				
			case PERSON_LIST:
				op.personList();
				break;
			case ADD:
				op.add();
				break;
			case DATE:
				System.out.println("date");
				//op.date()
			case EXIT:
				op.exit();
				break;
			default:
				System.out.println("UNKNOWN CHOICE !!!");
			}
			waitAndSee(choice);
		} while (choice != 0);
		scanner.close();
		scannerWait.close();
	}

	private static void printMenu() {
		System.out.println("\n********************************************");
		System.out.println("Bienvenue à l’application : ‘’ Opérations Mathématiques ‘’");
		System.out.println("");
		System.out.println("\t- Equation 2 Deg.                 \t\t\tTapez 1");
		System.out.println("\t- Factoriel                       \t\t\tTapez 2");
		System.out.println("\t- PGCD                            \t\t\tTapez 3");
		System.out.println("\t- Grande valeur d'un tableau      \t\t\tTapez 4");
		System.out.println("\t- Moyenne_ecart type              \t\t\tTapez 5");
		System.out.println("\t- List of Persons                 \t\t\tTapez 6");
		System.out.println("\t- ADD                             \t\t\tTapez 7");
		System.out.println("\t- DATE                            \t\t\tTapez 8");
		System.out.println("\t- Quitter                         \t\t\tTapez 0");
		System.out.print("\t\t\tFaites votre choix : ");
	}

	private static void waitAndSee(int choice) {
		if (choice != 0) {
			System.out.println("Press any key to continue...");
			scannerWait.nextLine();
		}
	}

}
