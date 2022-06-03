package fr.htc.library.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import fr.htc.library.main.Book;

public class BookTest {
	private final String  title = "Nedjma";
	private final String author = "Kateb Yacine";
	private final int editionYear = 1985;
	private final String expectedCote = "KA85-10";
	private Book book;
	

//	@BeforeClass
//	public static void setUpBeforeClass() throws Exception {
//	}
//
//	@AfterClass
//	public static void tearDownAfterClass() throws Exception {
//	}
//
//	@Before
//	public void setUp() throws Exception {
//	}
//
//	@After
//	public void tearDown() throws Exception {
//	}

	@Test
//	@Ignore
	public final void testBookStringStringInt() {
		book = new Book(title, author, editionYear);
		
		 assertNotNull("should not be null", book);
		 assertNotNull(book.getAuthor());
		 assertNotNull("Title should not be null", book.getTitle());
		 assertEquals("", title, book.getTitle());
		 assertEquals("", author, book.getAuthor());
		 assertEquals("", editionYear, book.getEditionYear());
		 assertEquals("", expectedCote, book.getCote());
		 assertTrue("- must be at 3rd position",expectedCote,book.getCote().contains("-") );
		 
		 Book book1 = new Book(title, author, editionYear);
		 assertTrue("Should increment the cote", book1.getCote().endsWith("11"));
		 
		 for (int i = 0; i < 100; i++) {
			new Book(title, author, editionYear);
		}
		 Book book112 = new Book(title, author, editionYear);
		 assertTrue("Should increment the cote large" + book112.getCote(), book112.getCote().endsWith("112"));
		 
		 Book book113 =  new Book(title, author, editionYear);
		 
		Book book15= new Book(title, author, editionYear);
		 
		 
		
	}

}
