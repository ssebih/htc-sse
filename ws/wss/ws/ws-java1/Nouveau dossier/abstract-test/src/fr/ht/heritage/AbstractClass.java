package fr.ht.heritage;

public abstract class AbstractClass  implements AbstractSayHello{
	protected String name;

	// abstract
	@Override
	public abstract String sayHello(String from);

	public AbstractClass() {
	}

	public AbstractClass(String name) {
		this.name = name;
	}


	@Override
	public abstract String sayHello();

	//// Getters & setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
