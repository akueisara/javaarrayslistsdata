package assignment.week1;

/**
 * Assignment 2: Caesar Cipher
 * 
 * @version February 29, 2016
 */

import edu.duke.*;

public class CaesarCipher {
 
	/** This method returns a String that has been encrypted using the Caesar Cipher algorithm */
    public String encrypt(String input, int key) {
        //Make a StringBuilder with message (encrypted)
        StringBuilder encrypted = new StringBuilder(input);
        //Write down the alphabet
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        //Compute the shifted alphabet
        String shiftedAlphabet = alphabet.substring(key)+alphabet.substring(0,key);
        //Count from 0 to < length of encrypted, (call it i)
        for(int i = 0; i < encrypted.length(); i++) {
            //Look at the ith character of encrypted (call it currChar)
            char currChar = encrypted.charAt(i);
            //Find the index of currChar in the alphabet (call it idx)
            int idx = alphabet.indexOf(Character.toUpperCase(currChar));
            //If currChar is in the alphabet
            if(idx != -1){
                //Get the idxth character of shiftedAlphabet (newChar)
                if (currChar == Character.toUpperCase(currChar)){
                    char newChar = shiftedAlphabet.charAt(idx);
                    //Replace the ith character of encrypted with newChar
                    encrypted.setCharAt(i, newChar);
                }
                else{
                   char newChar = shiftedAlphabet.charAt(idx);
                    //Replace the ith character of encrypted with newChar
                    encrypted.setCharAt(i, Character.toLowerCase(newChar)); 
                }
            }
            //Otherwise: do nothing
        }
        //Your answer is the String inside of encrypted
        return encrypted.toString();
    }
    
    /** 
     * This method returns a String that has been encrypted using the following algorithm 
     * key1 is used to encrypt every other character with the Caesar Cipher algorithm, starting with the first character
     * key2 is used to encrypt every other character, starting with the second character
     * */
    public String encryptTwoKeys(String input, int key1, int key2) {
         //Make a StringBuilder with message (encrypted)
        StringBuilder encrypted = new StringBuilder(input);
        //Write down the alphabet
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        //Compute the shifted alphabet
        String shiftedAlphabet1 = alphabet.substring(key1)+alphabet.substring(0,key1);
        String shiftedAlphabet2 = alphabet.substring(key2)+alphabet.substring(0,key2);
        //Count from 0 to < length of encrypted, (call it i)
        for(int i = 0; i < encrypted.length(); i++) {
            //Look at the ith character of encrypted (call it currChar)
            char currChar = encrypted.charAt(i);
            //Find the index of currChar in the alphabet (call it idx)
            int idx = alphabet.indexOf( Character.toUpperCase(currChar));
            //If currChar is in the alphabet
            if(idx != -1 && i%2 ==0){
                //Get the idxth character of shiftedAlphabet (newChar)
                if (currChar == Character.toUpperCase(currChar)){
                    char newChar = shiftedAlphabet1.charAt(idx);
                    //Replace the ith character of encrypted with newChar
                    encrypted.setCharAt(i, newChar);
                }
                else{
                   char newChar = shiftedAlphabet1.charAt(idx);
                    //Replace the ith character of encrypted with newChar
                    encrypted.setCharAt(i, Character.toLowerCase(newChar)); 
                }
            }
            else if (idx != -1 && i%2 ==1){
                //Get the idxth character of shiftedAlphabet (newChar)
                if (currChar == Character.toUpperCase(currChar)){
                    char newChar = shiftedAlphabet2.charAt(idx);
                    //Replace the ith character of encrypted with newChar
                    encrypted.setCharAt(i, newChar);
                }
                else{
                   char newChar = shiftedAlphabet2.charAt(idx);
                    //Replace the ith character of encrypted with newChar
                    encrypted.setCharAt(i, Character.toLowerCase(newChar)); 
                }
            }
            //Otherwise: do nothing
        }
        //Your answer is the String inside of encrypted
        return encrypted.toString();
    }

    public void testCaesar() {
        int key = 3;
        FileResource fr = new FileResource();
        String message = fr.asString();
        String encrypted = encrypt(message, key);
        System.out.println("key is " + key + "\n" + encrypted);
        String decrypted = encrypt(encrypted, 26-key);
        System.out.println(decrypted);
    }
}

