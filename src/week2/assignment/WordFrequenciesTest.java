package week2.assignment;

/**
 * Assignment 1: Most Frequent Word
 * 
 * @version March 15, 2016
 */

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class WordFrequenciesTest {
	private WordFrequencies wf;

	@Before
	public void setUp() throws Exception {
		this.wf = new WordFrequencies();
	}

	@After
	public void tearDown() throws Exception {
		this.wf = null;
	}

	@Test
	public void test() {
		wf.tester();
	}

}
