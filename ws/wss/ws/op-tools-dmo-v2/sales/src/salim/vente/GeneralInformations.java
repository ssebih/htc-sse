package salim.vente;

import java.io.InputStream;
import java.util.Scanner;

public class GeneralInformations {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Bonjour combien de ventes voulez vous enregistrer ?");
		Sales[] tabSales;
		//int a = scan.nextInt();
		tabSales = new Sales[scan.nextInt()];
		
		for (int i = 0; i < tabSales.length; i++) {
			System.out.println("entrez la vente n�" +(i+1));
			System.out.print("nom du produit : ");
			String productName = scan.next();  
			System.out.println("le prix du produit ");
			int price = scan.nextInt() ; 
		
			System.out.println("entrez le le client : ");
			String customerName= scan.next(); 
			Sales sales1 = new Sales (customerName, price, productName);
			tabSales[i] = sales1;
		}
		for (int j = 0; j < tabSales.length; j++) {
			System.out.println(tabSales[j]);
		}
		scan.close();
	}

}
