package assignment.week1;

/**
* Assignment 5: One Key
* 
* @version February 29, 2016
*/

public class OOCaesarCipher {
    private String alphabet;
    private String shiftedAlphabet;
    private int mainKey;

    public OOCaesarCipher(int key){
        //Write down the alphabet
        alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        //Compute the shifted alphabet
        shiftedAlphabet = alphabet.substring(key)+alphabet.substring(0,key);
        mainKey = key;
    }

    public String encrypt(String input) {
        //Make a StringBuilder with message (encrypted)
        StringBuilder encrypted = new StringBuilder(input);
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

    public String decrypt(String input){
        OOCaesarCipher cc = new OOCaesarCipher(26-mainKey);
        return cc.encrypt(input);
    }
}

