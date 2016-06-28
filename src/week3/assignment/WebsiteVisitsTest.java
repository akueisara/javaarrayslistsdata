package week3.assignment;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class WebsiteVisitsTest {
	private Tester test;
	
	@Before
	public void setUp() throws Exception {
		test = new Tester();
	}

	@After
	public void tearDown() throws Exception {
		test = null;
	}

	@Test
	public void countVisitsPerIPTest() {
		test.testcountVisitsPerIP();
	}
	
	@Test
	public void mostNumberVisitsByIPTest() {
		test.testmostNumberVisitsByIP();
	}
	
	@Test
	public void iPsMostVisitsTest() {
		test.testiPsMostVisits();
	}

}