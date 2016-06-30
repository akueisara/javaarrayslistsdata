package assignment.week3;

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
		System.out.println("UniqIPTest");
		test.testUniqIP();
		System.out.println("");
	}
	
	@Test
	public void printAllHigherThanNumTest() {
		System.out.println("printAllHigherThanNumTest");
		test.testprintAllHigherThanNum();
		System.out.println("printAllHigherThanNumTest2");
		test.testprintAllHigherThanNum2();
		System.out.println("");
	}
	
	@Test
	public void uniqueIPVisitsOnDayTest() {
		System.out.println("uniqueIPVisitsOnDayTest");
		test.testuniqueIPVisitsOnDay();
		System.out.println("uniqueIPVisitsOnDayTest2");
		test.testuniqueIPVisitsOnDay2();
		System.out.println("");
	}
	
	@Test
	public void countUniqueIPsInRangeTest() {
		System.out.println("countUniqueIPsInRangeTest");
		test.testcountUniqueIPsInRange();
		System.out.println("countUniqueIPsInRangeTest2");
		test.testcountUniqueIPsInRange2();
		System.out.println("");
	}
}
