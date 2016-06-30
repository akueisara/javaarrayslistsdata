package assignment.week1;


import java.util.Arrays;

import edu.duke.*;

public class CryptographyQuiz {

	public static void main(String[] args) {
		// Question 1
		// Encrypt the following phrase with the Caesar Cipher algorithm, using key 15.
		// "Can you imagine life WITHOUT the internet AND computers in your pocket?"
		// What is the encrypted string?
		OOCaesarCipher o1 = new OOCaesarCipher(15);
		System.out.println(o1.encrypt("Can you imagine life WITHOUT the internet AND computers in your pocket?"));
		
		// Question 2
		// Encrypt the following phrase with the algorithm described for using two Caesar Cipher keys, with key1 = 21 and key2 = 8.
        // Can you imagine life WITHOUT the internet AND computers in your pocket?
        // What is the encrypted string?
		OOCaesarCipherTwo o2 = new OOCaesarCipherTwo(21, 8);
		System.out.println("\n" + o2.encrypt("Can you imagine life WITHOUT the internet AND computers in your pocket?" + "\n"));
		
		// Question 4
		// Consider the file errors.txt.
        // What is the most common word length (ignoring the punctuation of the first and last character of each group of characters)?
		WordLengths w = new WordLengths();
		FileResource resource = new FileResource("./data/errors.txt");
		int[] counts = new int[31];
		w.countWordLengths(resource, counts);
		System.out.println(w.indexOfMax(counts) +"\n");
		
		// Question 5
		// Consider the file manywords.txt.
        // What is the most common word length (ignoring the punctuation of the first and last character of each group of characters)?
		resource = new FileResource("./data/manywords.txt");
		int[] counts2 = new int[31];
		w.countWordLengths(resource, counts);
		System.out.println(w.indexOfMax(counts));
		
		// Question 6
		// The following phrase was encrypted with the two-key encryption method we discussed using the two keys 14 and 24. What is the decrypted message?
		// "Hfs cpwewloj loks cd Hoto kyg Cyy."
		OOCaesarCipherTwo o3 = new OOCaesarCipherTwo(14, 24);
		System.out.println("\n" + o3.decrypt("Hfs cpwewloj loks cd Hoto kyg Cyy."));
		
		// Question 7
		// The following phrase was encrypted with the two-key encryption method described in this course. You will need to figure out which keys were used to encrypt it.
		// "Aal uttx hm aal Qtct Fhljha pl Wbdl. Pvxvxlx!"
		// What is the original message?
		CasesarBreaker c = new CasesarBreaker();
		c.decryptTwoKeys("Aal uttx hm aal Qtct Fhljha pl Wbdl. Pvxvxlx!");
		
	    // Question 8
		// Decrypt the encrypted file mysteryTwoKeysQuiz.txt.
		// This file is encrypted with the two-key encryption method we discussed. You�ll need to decrypt the complete file by figuring out which keys were used to decrypt it.
		// What are the first five decrypted words?
		FileResource fr = new FileResource("./data/mysteryTwoKeysQuiz.txt");
        String message = fr.asString();
        String s1 = c.halfOfString(message, 0);
        String s2 = c.halfOfString(message, 1);
        int key1 = c.getKey(s1);
        int key2 = c.getKey(s2);
        System.out.println("\nTwo keys found: key1= " + key1 + ", key2= " + key2);
        CaesarCipher cc = new CaesarCipher();
        System.out.println(cc.encryptTwoKeys(message, 26-key1, 26-key2));
        
        
	}

}
