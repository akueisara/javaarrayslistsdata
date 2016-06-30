package week3.assignment;

/**
 * Assignment: Reading Web Logs / Unique IPs - LogAnalyzer
 * 
 * @version June 22, 2016
 */

import java.util.*;
import edu.duke.*;

public class LogAnalyzer {
	private ArrayList<LogEntry> records;
	
	public LogAnalyzer() {
		this.records = new ArrayList<LogEntry>();
	}
	
	public void readFile(String filename) {
		FileResource f = new FileResource(filename);
		for (String line: f.lines()) {
			LogEntry log = WebLogParser.parseEntry(line);
			records.add(log);
		}
	}
	
	public int countUniqueIPs() {
		// alternate way
		// HashMap<String, Integer> counts = countVisitsPerIP();
		// return counts.size();
		ArrayList<String> uniqueIPs = new ArrayList<String>();
		for (LogEntry le: records) {
			String ipAddress = le.getIpAddress();
			if (!uniqueIPs.contains(ipAddress)) {
				uniqueIPs.add(ipAddress);
			}
		}
		return uniqueIPs.size();
	}
	
	public void printAll() {
		for (LogEntry le: records) {
			System.out.println(le);
		}
	}
	
	public void printAllHigherThanNum (int num) {
		for (LogEntry le: records) {
			if (le.getStatusCode() > num)
				System.out.println(le);
		}
	}
	
	public ArrayList<String> uniqueIPVisitsOnDay(String someday) {
		ArrayList<String> uniqueIPs = new ArrayList<String>();
		for (LogEntry le: records) {
			String ipAddress = le.getIpAddress();
			String accessTime = le.getAccessTime().toString();
			if (someday.equals(accessTime.substring(4, 10))) {
				if (!uniqueIPs.contains(ipAddress)) {
					uniqueIPs.add(ipAddress);
				}
			}
		}
		return uniqueIPs;
	}
	
	public int countUniqueIPsInRange(int low, int high) {
		ArrayList<String> UniqueIPsInRange = new ArrayList<String>();
		for (LogEntry le: records) {
			String ipAddress = le.getIpAddress();
			if(le.getStatusCode() >= low && le.getStatusCode()<= high) {
				if (!UniqueIPsInRange.contains(ipAddress)) {
					UniqueIPsInRange.add(ipAddress);
				}
			}
		}
		return UniqueIPsInRange.size();
	}
	
	public HashMap<String, Integer> countVisitsPerIP() {
		// Make an empty HashMap<String, Integer> counts
		HashMap<String,Integer> counts = new HashMap<String, Integer>();
		// For each le in records
		for(LogEntry le: records) {
			// ip is le's ipAddress
			String ip = le.getIpAddress();
			//check if ip is in counts
			if(!counts.containsKey(ip)) {
				// If not: put ip in with a value of 1
				counts.put(ip, 1);
			}
			    // If so: update the value to be 1 more
			else {
				counts.put(ip, counts.get(ip)+1);
			}
		}
		return counts;
	}
	
	public int mostNumberVisitsByIP(HashMap<String, Integer> map) {
		return Collections.max(map.values());
	}
	
	public ArrayList<String> iPsMostVisits(HashMap<String, Integer> map) {
		ArrayList<String> ipAddress = new ArrayList<String>();
		int max = mostNumberVisitsByIP(map);
		Iterator it = map.entrySet().iterator();
	    while (it.hasNext()) {
	        Map.Entry pair = (Map.Entry)it.next();
	        if (max == (int)pair.getValue()) {
	        	ipAddress.add((String)pair.getKey());
	        }
	        it.remove();
	    }
	    return ipAddress;
	}
	
	public HashMap<String, ArrayList<String>> iPsForDays() {
		HashMap<String,ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
		for(LogEntry le: records) {
			String ip = le.getIpAddress();
			String date = le.getAccessTime().toString().substring(4, 10);
			ArrayList<String> ipAddressList = new ArrayList<String>();
			if (!map.containsKey(date)) {
				ipAddressList.add(ip);
				map.put(date, ipAddressList);
			}
			else {
				ArrayList<String> currentipAddress = map.get(date);
				currentipAddress.add(ip);
				map.put(date, currentipAddress);
			}
		}
		return map;
	}
	
	public String dayWithMostIPVisits(HashMap<String, ArrayList<String>> map) {
		String day ="";
		int size = 0;
		for (Map.Entry<String, ArrayList<String>> e : map.entrySet()) {
			if (size < e.getValue().size()){
				size = e.getValue().size();
				day = e.getKey();
			}
		}
		return day;
	}
	
	public ArrayList<String> iPsWithMostVisitsOnDay(HashMap<String, ArrayList<String>> map, String day) {
		ArrayList<String> list = map.get(day);
		HashMap<String, Integer> countIP = new HashMap<String, Integer>();
		for (String ip: list){
			if (!countIP.containsKey(ip))
				countIP.put(ip, 1);
			else
				countIP.put(ip, countIP.get(ip)+1);
		}
		ArrayList<String> ipMostVisits = iPsMostVisits(countIP);
		return ipMostVisits;
	}
}
