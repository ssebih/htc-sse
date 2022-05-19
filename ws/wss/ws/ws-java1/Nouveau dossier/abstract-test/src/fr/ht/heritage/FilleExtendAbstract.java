package fr.ht.heritage;

public  class  FilleExtendAbstract extends AbstractClass {

	public FilleExtendAbstract() {
	}

	public FilleExtendAbstract(String name) {
		super(name);
	}

	@Override
	public String sayHello(String from) {
		return "Azul " + this.name + " sghur " + from;
	}

	@Override
	public String sayHello() {
		// TODO Auto-generated method stub
		return null;
	}
}
