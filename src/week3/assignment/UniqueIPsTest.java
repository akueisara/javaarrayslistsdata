package week3.assignment;

/**
 * Assignment: Unique IPs - UniqueIPsTest
 * 
 * @version June 22, 2016
 */

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UniqueIPsTest {

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
	public void UniqIPTest() {
		test.testUniqIP();
	}
	
	@Test
	public void printAllHigherThanNumTest() {
		test.testprintAllHigherThanNum();
	}
	
	@Test
	public void uniqueIPVisitsOnDayTest() {
		test.testuniqueIPVisitsOnDay();
	}
	
	@Test
	public void countUniqueIPsInRangeTest() {
		test.testcountUniqueIPsInRange();
	}
}
