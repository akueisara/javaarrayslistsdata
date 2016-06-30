package week3.assignment;

import java.util.ArrayList;
import java.util.HashMap;

public class CountingQuizTester {
	
	public void testQuizOne() {
		LogAnalyzer la = new LogAnalyzer();
		la.readFile("./weblog/weblog1_log");
		HashMap<String, Integer> counts = la.countVisitsPerIP();
		System.out.println(la.mostNumberVisitsByIP(counts));
	}
	
	public void testQuizTwo() {
		LogAnalyzer la = new LogAnalyzer();
		la.readFile("./weblog/weblog1_log");
		HashMap<String, Integer> counts = la.countVisitsPerIP();
		System.out.println(la.iPsMostVisits(counts));
	}
	
	public void testQuizThree() {
		LogAnalyzer la = new LogAnalyzer();
		la.readFile("./weblog/weblog1_log");
		HashMap<String, ArrayList<String>> map = la.iPsForDays();
		System.out.println(la.dayWithMostIPVisits(map));
	}
	
	public void testQuizFour() {
		LogAnalyzer la = new LogAnalyzer();
		la.readFile("./weblog/weblog1_log");
		HashMap<String, ArrayList<String>> map = la.iPsForDays();
		System.out.println(la.iPsWithMostVisitsOnDay(map, "Mar 17"));
	}

}
