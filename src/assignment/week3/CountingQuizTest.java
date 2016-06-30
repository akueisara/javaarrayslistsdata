package assignment.week3;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CountingQuizTest {
	private CountingQuizTester test;

	@Before
	public void setUp() throws Exception {
		this.test = new CountingQuizTester();
	}

	@After
	public void tearDown() throws Exception {
		this.test = null;
	}

	@Test
	public void quizOneTest() {
		test.testQuizOne();
	}
	
	@Test
	public void quizTwoTest() {
		test.testQuizTwo();
	}
	
	@Test
	public void quizThreeTest() {
		test.testQuizThree();
	}
	
	@Test
	public void quizFourTest() {
		test.testQuizFour();
	}

}
