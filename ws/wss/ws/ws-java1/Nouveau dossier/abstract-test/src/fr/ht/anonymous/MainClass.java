package fr.ht.anonymous;

public class MainClass {

	public static void main(String[] args) {
		new MyInterfaceSayer() {
			@Override
			public void sayHello(String param) {
				System.out.println("hello " + param);
			}
		}.sayHello("Djamel");
	}

}
