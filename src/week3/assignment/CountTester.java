package week3.assignment;

import java.util.*;

public class CountTester {


	public void testCounts() {
		LogAnalyzer la = new LogAnalyzer();
		la.readFile("./weblog/short-test_log");
		HashMap<String, Integer> counts = la.countVisitsPerIP();
		System.out.println(counts);
	}
}
