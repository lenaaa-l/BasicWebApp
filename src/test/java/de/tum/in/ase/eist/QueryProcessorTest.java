package de.tum.in.ase.eist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueryProcessorTest {

	private final QueryProcessor queryProcessor = new QueryProcessor();

	@Test
	void testEmptyStringIfCannotProcessQuery() {
		assertEquals("", queryProcessor.process("test"));
	}

	@Test
	void testKnowsAboutShakespeare() {
		String actual = queryProcessor.process("Shakespeare");
		if (!actual.contains("playwright")) {
			fail("The QueryProcessor does not know about Shakespeare.");
		}
	}

	@Test
	void isNotCaseSensitive() {
		String actual = queryProcessor.process("shakespeare");
		if (!actual.contains("playwright")) {
			fail("Your QueryProcessor should not be case sensitive.");
		}
	}

	@Test
	void nameCorrect(){
		assertTrue(queryProcessor.process("name").contains("Lena"));
	}

	@Test
	void addCorrect1(){
		assertTrue(queryProcessor.process("what is 4 plus 18").contains("22"));
	}

	@Test
	void addCorrect2(){
		assertTrue(queryProcessor.process("9ca4d780: what is 12 plus 15").contains("27"));
	}

}
