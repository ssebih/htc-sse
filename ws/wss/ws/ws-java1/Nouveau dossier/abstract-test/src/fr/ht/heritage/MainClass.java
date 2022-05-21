package fr.ht.heritage;

public class MainClass {

	public static void main(String[] args) {
		
		FilleExtendAbstract fea = new FilleExtendAbstract("Djamel");
		
		System.out.println(fea.sayHello());
		System.out.println(fea.sayHello("Salim"));

	}

}
