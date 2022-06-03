package fr.htc.library.main;

import java.util.ArrayList;
import java.util.List;

public class Member {
	public static final int MAX_CHECKOUT_BOOK = 3;

	private static int matSeq = 100;
	private String matricule;
	private String firstName;
	private String lastName;
	private int age;
	private List<Book> borrowedBooks = new ArrayList<Book>();

	// **** constructors
	public Member() {

	}

	public Member(String firstName, String lastName, int age) {
		this(firstName, lastName);
		this.age = age;
	}

	public Member(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.matricule = this.generateMatricule();
	}

	private String generateMatricule() {
		String matricule = this.firstName.substring(0, 1).toUpperCase() + this.lastName.substring(0, 1).toUpperCase()
				+ matSeq++;

		return matricule;
	}

	// **** getters and setters

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMatricule() {
		return matricule;
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

	public List<Book> getBorrowedBooks() {
		return borrowedBooks;
	}

	@Override
	public String toString() {
		return "Member [matricule=" + matricule + ", firstName=" + firstName + ", lastName=" + lastName + ", age=" + age
				+ "]";
	}

	public boolean canCheckout() {
		if (this.borrowedBooks.size() < MAX_CHECKOUT_BOOK) {
			return true;
		}
		return false;
	}

	public void removeBook(Book book) {
		Book toRemove = null;
		for (Book elt : borrowedBooks) {
			if (elt.getCote().equals(book.getCote())) {
				toRemove = elt;
				break;
			}
		}
		borrowedBooks.remove(toRemove);

	}

}
