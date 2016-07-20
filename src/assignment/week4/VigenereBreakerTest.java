package assignment.week4;

/**
 * Assignment:
 * English Language, Known Key Length 
 * English Language, Unknown Key Length 
 * Multiple Languages
 * 
 * @version June 30, 2016
 */

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashSet;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.duke.FileResource;

public class VigenereBreakerTest {
	private VigenereBreaker v;

	@Before
	public void setUp() throws Exception {
		this.v = new VigenereBreaker();
		
	}

	@After
	public void tearDown() throws Exception {
		this.v = null;
	}

	@Test
	public void sliceStringTest() {
		assertEquals("adgjm",v.sliceString("abcdefghijklm", 0, 3));
		assertEquals("behk",v.sliceString("abcdefghijklm", 1, 3));
		assertEquals("cfil",v.sliceString("abcdefghijklm", 2, 3));
		assertEquals("aeim",v.sliceString("abcdefghijklm", 0, 4));
		assertEquals("bfj",v.sliceString("abcdefghijklm", 1, 4));
		assertEquals("cgk",v.sliceString("abcdefghijklm", 2, 4));
		assertEquals("dhl",v.sliceString("abcdefghijklm", 3, 4));
		assertEquals("afk",v.sliceString("abcdefghijklm", 0, 5));
		assertEquals("bgl",v.sliceString("abcdefghijklm", 1, 5));
		assertEquals("chm",v.sliceString("abcdefghijklm", 2, 5));
		assertEquals("di",v.sliceString("abcdefghijklm", 3, 5));
		assertEquals("ej",v.sliceString("abcdefghijklm", 4, 5));
	}
	
	@Test
	public void tryKeyLengthTest() {
		FileResource fr = new FileResource("./VigenereTestData/athens_keyflute.txt");
		String message = fr.asString();
		int [] key = v.tryKeyLength(message, 5, 'e');
		assertArrayEquals(new int[]{5, 11, 20, 19, 4}, key);
	}
	
	@Test
	public void breakVigenereTest() {
		PrintStream original = System.out;
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		// read athens_keyflute.txt
		v.breakVigenere();
		String [] lines = outContent.toString().split("\\r?\\n");
		assertEquals("SCENE II. Athens. QUINCE'S house.", lines[0]);
		System.setOut(original);  // reset to standard output
	}
	
	@Test
	public void breakForLanguageTest() {
		FileResource fr = new FileResource("./VigenereTestData/athens_keyflute.txt");
		String message = fr.asString();
		FileResource fr2 = new FileResource("./src/assignment/week4/dictionaries/English");
		HashSet<String> dictionary = v.readDictionary(fr2);
		String decrypt = v.breakForLanguage(message, dictionary);
		String[] lines = decrypt.split("\\r?\\n");
		assertEquals("SCENE II. Athens. QUINCE'S house.", lines[0]);
	}
	
	@Test
	public void breakVigenere2Test() {
		PrintStream original = System.out;
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		// read athens_keyflute.txt
		v.breakVigenere2();
		String [] lines = outContent.toString().split("\\r?\\n");
		assertEquals("The keys are 5 11 20 19 4 ", lines[0]);
		assertEquals("The key length is 5", lines[1]);
		assertEquals("SCENE II. Athens. QUINCE'S house.", lines[2]);
		System.setOut(original);  // reset to standard output
	}
	
	@Test
	public void mostCommonCharInTest() {
		FileResource fr = new FileResource("./src/assignment/week4/dictionaries/English");
        HashSet<String> result = new HashSet<String>();
        for (String line: fr.lines()) {
            line = line.toLowerCase();
            result.add(line);
        }
        assertEquals("e",v.mostCommonCharIn(result));      
	}
	
	@Test
	public void breakVigenere3Test() {
		// 1. read athens_keyflute.txt
		// 2. choose all the dictionaries
		v.breakVigenere3();
	}
	
}

