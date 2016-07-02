package assignment.week4;

import java.util.HashSet;

import edu.duke.FileResource;

public class UnknownKeyLengthQuiz {
	public static void main(String[] args) {
		// Quiz 1
		VigenereBreaker v = new VigenereBreaker();
		FileResource fr = new FileResource("./src/assignment/week4/messages/secretmessage2.txt");
		String message = fr.asString();
		FileResource fr2 = new FileResource("./src/assignment/week4/dictionaries/English");
		HashSet<String> dictionary = v.readDictionary(fr2);
		String decrypt = v.breakForLanguage(message, dictionary);
		
		// Quiz 2
		int count = v.countWords(decrypt, dictionary);
		System.out.println(count + " valid words are in the decrypted String.");
		
		// Quiz 3
		String [] lines = decrypt.split("\\r?\\n");
		System.out.println("The first line of text is " + lines[0]);
		
		// Quiz 4
		int [] key = v.tryKeyLength(message, 38, 'e');
		VigenereCipher vc = new VigenereCipher(key);
    	decrypt = vc.decrypt(message);
    	count = v.countWords(decrypt, dictionary);
    	System.out.println(count + " valid words are in the decrypted String.");
    	
	}
}
