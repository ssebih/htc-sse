package fr.ht.gof.builder;

public class MainUseBuilder {

	public static void main(String[] args) {
		System.out.println();
		ConnectionBuilder.build()
		.acceptSSL()
		.addDBName("db")
		.addPwd("pwd")
		.addLogin("login")
		.addUrl("URL");

		ConnectionBuilder cb = new ConnectionBuilder;
		
	}

}
