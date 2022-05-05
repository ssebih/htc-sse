package fr.htc.oprations.menu;

import java.util.Scanner;

public class OperationsArithmetiques {
        
        
        public void somme() {
                System.out.println("  *******  ADDITION  *******  ");
                Scanner clavier = new Scanner(System.in);
                System.out.print("Entrer le premier nombre : ");
                int a = clavier.nextInt();
                System.out.print("Entrer le deuxieme nombre : ");
                int b = clavier.nextInt();
                int somme = a + b;
                System.out.println("La somme de deux nombre est : " + somme);
 
        }
        public void sustraction() {
            System.out.println("  *******  soustraction  *******  ");
            Scanner clavier = new Scanner(System.in);
            System.out.print("Entrer le premier nombre : ");
            int a = clavier.nextInt();
            System.out.print("Entrer le deuxieme nombre : ");
            int b = clavier.nextInt();
            int soustraction = a - b;
            System.out.println("La somme de deux nombre est : " + soustraction);

    }
        
}
