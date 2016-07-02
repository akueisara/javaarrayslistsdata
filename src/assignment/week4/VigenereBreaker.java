package assignment.week4;

import java.io.File;

/**
 * Assignment:
 * English Language, Known Key Length 
 * English Language, Unknown Key Length 
 * Multiple Languages
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
//         int[] key = tryKeyLength(encrypted, truekey, 'e'); // for English
    	 char mostCommonChar = mostCommonCharIn(dictionary).charAt(0);
    	 int[] key = tryKeyLength(encrypted, truekey, mostCommonChar);
         System.out.print("The keys are ");
         for (int i = 0; i < key.length; i++) {
             System.out.print(key[i] + " ");
         }
         System.out.println("\nThe key length is "+key.length);
         VigenereCipher vc = new VigenereCipher(key);
         return vc.decrypt(encrypted);
    }
    
    public void breakVigenere2 () {
    	FileResource fr = new FileResource();
    	String message = fr.asString();
    	FileResource fr2 = new FileResource("./src/assignment/week4/dictionaries/English");
    	HashSet<String> dictionary = readDictionary(fr2);
    	String decrypt = breakForLanguage(message, dictionary);
    	System.out.println(decrypt);
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
    
    public HashMap<String, String> breakForAllLanguages(String encrypted, HashMap<String, HashSet<String>> languages){
    	 HashMap<String, String> decrpytedMessages = new HashMap<String, String>();
    	 String language = "";
    	 int wordcount = 0;
         for (String lang: languages.keySet()) {
             System.out.println("Currently breaking into "+lang);
             String decrypted_string = breakForLanguage(encrypted, languages.get(lang));
             //System.out.println(decrypted_string);
             int count = countWords(decrypted_string, languages.get(lang));
             if (wordcount < count) {
            	 wordcount = count;
            	 language = lang;
             }
             //System.out.println(count + " valid words\n");
             System.out.println();
             decrpytedMessages.put(lang, decrypted_string);
         }
         System.out.println("The language of this message is " + language);
         System.out.println(wordcount + " valid words\n");
         return decrpytedMessages;
    }
    
    public void breakVigenere3() {
    	FileResource fr = new FileResource();
        String message = fr.asString();
    	HashMap<String, HashSet<String>> languages = new HashMap<String, HashSet<String>>();
    	DirectoryResource dr = new DirectoryResource();
    	for (File d: dr.selectedFiles()) {
    		FileResource fr2 = new FileResource(d.toString());
    		HashSet<String> result = new HashSet<String>();
            for (String line: fr2.lines()) {
                line = line.toLowerCase();
                result.add(line);
            }
            languages.put(d.getName(), result);
            //System.out.println("Finished reading "+f.getName());
    	}
    	HashMap<String, String> decrypted = breakForAllLanguages(message, languages);
        //System.out.println(decrypted.get("English"));
    }
    
}
