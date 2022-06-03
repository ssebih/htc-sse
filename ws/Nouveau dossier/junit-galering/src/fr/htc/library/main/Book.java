package fr.htc.library.main;

public class Book {
	private static int coteSeq = 10;
	private String cote;
	private String title;
	private String author;
	private int editionYear;
	private Member borrower;


	// *** Constructors
	public Book() {
	}

	public Book(String title, String author, int editionYear) {
		this.title = title;
		this.author = author;
		this.editionYear = editionYear;
		this.cote = this.generateCote();
	}

	private String generateCote() {

		String cote = this.author.substring(0, 2).toUpperCase() + "-" +this.editionYear%100  + coteSeq++;
		return cote;
	}

	// *** gettes & setters

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getEditionYear() {
		return editionYear;
	}

	public void setEditionYear(int editionYear) {
		this.editionYear = editionYear;
	}

	public String getCote() {
		return cote;
	}

	public Member getBorrower() {
		return borrower;
	}

	public void setBorrower(Member borrower) {
		this.borrower = borrower;
	}
	@Override
	public String toString() {
		return "Book [cote=" + cote + ", title=" + title + ", author=" + author + ", editionYear=" + editionYear + "]";
	}

	public boolean isAvailable() {
		if(this.borrower == null) {
			return true;
		}
		return false;
	}
	
}
