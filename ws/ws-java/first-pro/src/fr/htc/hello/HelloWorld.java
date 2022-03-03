package fr.htc.hello;

public class HelloWorld {
	public static void main(String[] args) {
		System.out.println("Application Addition ...");

		if (args.length != 3) {
			System.out.println("Missing arguments...quit");
			return;
		}

		int n1 = Integer.parseInt(args[0]);
		int n2 = Integer.parseInt(args[1]);
		int n3 = Integer.parseInt(args[2]);
		int somme = n1 + n2 + n3;
		System.out.println("La somme de (" + n1 + " ," + n2 + " ," + n3 + ") est : " + somme);
	}
}