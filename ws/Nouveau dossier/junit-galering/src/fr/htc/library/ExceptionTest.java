package fr.htc.library;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import fr.htc.library.main.Book;

public class ExceptionTest {
	private final String  title = "Nedjma";
	private final String author = "Kateb Yacine";
	private final int editionYear = 1985;
	private final String expectedCote = "KA85-10";
	private Book book;
	

	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();
	 
	@Test
	public void whenExceptionThrown_thenRuleIsApplied() {
	    exceptionRule.expect(NumberFormatException.class);
	    exceptionRule.expectMessage("For input string");
	    Integer.parseInt("1a");
	}
//	
}
