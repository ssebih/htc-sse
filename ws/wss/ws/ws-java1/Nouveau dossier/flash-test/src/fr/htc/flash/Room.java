package fr.htc.flash;

import java.util.Iterator;
import java.util.Scanner;

public class Room {
	Scanner scanner = new Scanner (System.in);
	private int id;
	private float aire;
	private String name;

	
	
	public void R (int id, float aire,String name ){
		this.id = id;
		this.aire = aire;
		this.name = name;
		
		
	}
	
	public  void in() {
		System.out.print("entrez le nombre de chambre svp !");
	
		Room []tab = new Room [scanner.nextInt()];
		for (int i = 0; i < tab.length; i++) {
			System.out.println("entrez la chambre" +(i+1) );
			System.out.print("l'indetifiant : ");
			int id = scanner.nextInt();
			System.out.print("la surface : ");
			float aire=scanner.nextFloat();
			System.out.print("le nom de la chambre : ");
			String name= scanner.next();
			Room chambre1 = new Room ();
			tab [i] = chambre1;
			
		}
	}
	@Override
	public String toString() {
		return "Room [scanner=" + scanner + ", id=" + id + ", aire=" + aire + ", name=" + name + "]";
	}
	

}
