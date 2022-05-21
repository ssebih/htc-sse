package Salim_htc1;

public class HelloWorld {
	public static void main(String[] args) {
		

		

		int n1 = Integer.parseInt(args[0]);
		int n2 = Integer.parseInt(args[1]);
		int n3 = Integer.parseInt(args[2]);

		int n4 = Integer.parseInt(args[3]);

		int n5 = Integer.parseInt(args[4]);
		int somme = n1 + n2 + n3 + n4 + n5;
		int moy = somme/5;
		System.out.println("La somme de (" + n1 + " ," + n2 + " ," + n3 + ") est : " + somme);

		System.out.println("La moyenne de (" + n1 + " ," + n2 + " ," + n3 + ","+ n4 +","+ n5+ ") est : " + moy);
		 



	}
}