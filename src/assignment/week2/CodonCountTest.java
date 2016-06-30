package assignment.week2;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CodonCountTest {
	private CodonCount cc;

	@Before
	public void setUp() throws Exception {
		this.cc = new CodonCount();
	}

	@After
	public void tearDown() throws Exception {
		this.cc = null;
	}

	@Test
	public void test() {
		cc.tester();
	}

}
