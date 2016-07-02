package assignment.week4;

/**
 * Assignment: English Language, Known Key Length / English Language, Unknown Key Length
 * 
 * @version June 30, 2016
 */

import java.util.*;
import edu.duke.*;

public class VigenereBreaker {
	
	/** The method returns a String consisting of every totalSlices-th character from message, 
	 *  starting at the whichSlice-th character.
	 */
    public String sliceString(String message, int whichSlice, int totalSlices) {
    	StringBuilder s = new StringBuilder();
    	for ( int i = whichSlice; i< message.length() ; i+= totalSlices) {
    		s.append(message.charAt(i));
    	}
        return s.toString();
    }

    /** The method finds the shift for each index in the key */
    public int[] tryKeyLength(String encrypted, int klength, char mostCommon) {
        int[] key = new int[klength];
        CaesarCracker cc = new CaesarCracker(mostCommon);
        for (int i = 0; i < klength ; i++) {
        	String s = sliceString(encrypted, i, klength);
        	int dkey = cc.getKey(s);
        	key[i] = dkey;
        }
        return key;
    }

    public void breakVigenere () {
    	FileResource fr = new FileResource();
    	String message = fr.asString();
    	int [] key = tryKeyLength(message, 5, 'e');
    	VigenereCipher vc = new VigenereCipher(key);
    	String decrypt = vc.decrypt(message);
    	System.out.println(decrypt);
    }
    
    /**  The method returns the HashSet representing the words in a dictionary */
    public HashSet<String> readDictionary(FileResource fr){
    	HashSet<String> vocabularySet = new HashSet<String>();
    	for (String line: fr.lines()) {
    	   line = line.toLowerCase();
    	   vocabularySet.add(line);
    	}
    	return vocabularySet;
    }
    
    /** The method returns the integer count of how many valid words in dictionary it found from message */
    public int countWords(String message, HashSet<String> dictionary){
    	int count = 0;
    	for (String word: message.split("\\W+")) {
    		word = word.toLowerCase();
    		 if (dictionary.contains(word))
    			 count++;
    	}
    	return count;
    }
    
    /** This method should figure out which decryption gives the largest count of real words, 
     * and return that String decryption.
     */
    public String breakForLanguage(String encrypted, HashSet<String> dictionary) {
    	int[] wordcount = new int[100];
    	for (int i = 0; i < 100; i++) {
            int[] key = tryKeyLength(encrypted, i+1, 'e');
            VigenereCipher vc = new VigenereCipher(key);
            String result = vc.decrypt(encrypted);
            wordcount[i] = countWords(result, dictionary);
        }
    	
    	int largest = 0;
    	int index = 0;
    	for (int i = 0; i < 100; i++) {
            if (wordcount[i] > largest) {
                largest = wordcount[i];
                index = i;
            }
        }
    	
    	 int truekey = index + 1;
         int[] key = tryKeyLength(encrypted, truekey, 'e');
         System.out.print("The keys are ");
         for (int i = 0; i < key.length; i++) {
             System.out.print(key[i] + " ");
         }
         System.out.println("\nThe key length is "+key.length);
         VigenereCipher vc = new VigenereCipher(key);
         return vc.decrypt(encrypted);
    }
    
    /** The method finds out which character, of the letters in the English alphabet, 
     *  appears most often in the words in dictionary 
     */
    public String mostCommonCharIn(HashSet<String> dictionary){
    	HashMap<String, Integer> map = new HashMap<String, Integer>();
    	
    	for (char ch = 'a'; ch <= 'z'; ++ch) 
    		  map.put(String.valueOf(ch), 0); 
    	
    	for(String word: dictionary) {
    		word = word.toLowerCase();
    		String[] letters = word.split("");
            for (String letter: map.keySet()) {
                for (String s: letters) {
                    if (s.equals(letter)) 
                    	map.put(letter, map.get(letter)+1);
                }
            }
    	}
    	
    	int max = 0;
    	String result ="";
         
    	for (Map.Entry<String, Integer> e : map.entrySet()) {
    	    if (max < e.getValue()) {
                max = e.getValue();
                result = e.getKey();
            }
    	}
      
        return result;
    }
    
    public void breakVigenere2 () {
    	FileResource fr = new FileResource();
    	String message = fr.asString();
    	FileResource fr2 = new FileResource("./src/assignment/week4/dictionaries/English");
    	HashSet<String> dictionary = readDictionary(fr2);
    	String decrypt = breakForLanguage(message, dictionary);
    	System.out.println(decrypt);
    }
    
    public void breakForAllLanguages(String encrypted, HashMap<String, HashSet<String>> languages){
    	
    }
    
}
