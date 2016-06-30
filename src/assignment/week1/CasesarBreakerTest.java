package assignment.week1;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CasesarBreakerTest {
	private CasesarBreaker cb;

	@Before
	public void setUp() throws Exception {
		this.cb = new CasesarBreaker();
	}

	@After
	public void tearDown() throws Exception {
		this.cb = null;
	}

	@Test
	public void halfOfStringTest() {
		assertEquals("Qk gs", cb.halfOfString("Qbkm Zgis",0));
		assertEquals("bmZi", cb.halfOfString("Qbkm Zgis",1));
	}

}
