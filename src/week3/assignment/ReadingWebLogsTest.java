package week3.assignment;

import org.junit.*;

public class ReadingWebLogsTest {
	
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
	public void LogEntryTest() {
		test.testLogEntry();
	}
	
	@Test
	public void LogAnalyzerTest() {
		test.testLogAnalyzer();
	}

}
