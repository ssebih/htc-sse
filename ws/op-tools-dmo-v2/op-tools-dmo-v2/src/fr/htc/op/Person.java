package fr.htc.op;

public class Person {

	private String firstName = "";
	private String lastName = "";
	private int age;

//	public void print() {
//		System.out.println("Person [Nom = " + lastName + ", Prenom = " + firstName + ", Age = " + age + "]");
//	}

	void methode() {
		System.out.println("La vie de mam mere je fais rien !!!!");
	}

	public int methode(int a) {
		System.out.println("La vie de mam mere je fais rien !!!!");
		return 0;
	}

	public int methode(String a) {
		System.out.println("La vie de mam mere je fais rien !!!!");
		return 0;
	}

	public int methode(String a, int b) {
		System.out.println("La vie de mam mere je fais rien !!!!");
		return 0;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + "]";
	}
}
