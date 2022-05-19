package fr.htc.library;

public class Adherent {
	String nom;
	String prenom;
	int age;
	String matricule;
	int a  = 100;
	
	
	private Adherent(String nom, String prenom, int age, String matricule ) {
		this.nom = nom;
		this.prenom = prenom;
		this.age =age;
		this.matricule = generateMatricule();
	}


	private  String generateMatricule() {
		
		char inom = this.nom.charAt(1);
		char iprenom = this.prenom.charAt(1);
		int num = a++;
				
		
	return matricule;
	
	}

}
