package fr.htc.salim.generic;

public class GenericMain {

	public static void main(String[] args) {
		Column<String> sColumn = new Column<String>();
		sColumn.setValue("Bonjour tout le monde !");
		System.out.println(sColumn.getValue());

		Column<Integer> iColumn = new Column<Integer>();
		iColumn.setValue(1000);
		System.out.println(iColumn.getValue());

		Column<Boolean> bColumn = new Column<Boolean>();
		bColumn.setValue(true);
		System.out.println(bColumn.getValue());

		Column<User> uColumn = new Column<User>();
		uColumn.setValue(new User("salim", 34));
		System.out.println(uColumn.getValue());

	}

}
