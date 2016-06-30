package assignment.week1;

/**
 * Assignment 1: Word Play - JUnit Test
 * 
 * @version February 23, 2016
 */

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class WordPlayTest {
	private WordPlay wordplay;
	
	@Before
	public void setUp() throws Exception {
		this.wordplay = new WordPlay();
	}

	@After
	public void wordplay() throws Exception {
		this.wordplay = null;
	}

	@Test
	public void isVowelTest() {
		assertFalse(wordplay.isVowel('F'));
		assertTrue(wordplay.isVowel('a'));
	}
	
	@Test
	public void replaceVowelsTest() {
		assertEquals("H*ll* W*rld", wordplay.replaceVowels("Hello World", '*'));
	}
	
	@Test
	public void emphasizeTest() {
		assertEquals("dn* ctg+*+ctg+", wordplay.emphasize("dna ctgaaactga", 'a'));
		assertEquals("M+ry Bell+ +br*c*d*br+", wordplay.emphasize("Mary Bella Abracadabra", 'a'));
	}

}
