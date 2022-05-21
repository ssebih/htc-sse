package fr.htc.flash;
import fr.htc.flash.Room;

public class MainClass {
	 
	static String str =  "flasTest";
	public static void main(String[] args) {
		
		 Room rm = new Room ();
		 rm.R(0, 0, str);
		 rm.in();
		 rm.toString();

	}

}
