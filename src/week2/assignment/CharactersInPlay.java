package week2.assignment;

/**
 * Assignment 2: Most Frequent Word
 * 
 * @version March 15, 2016
 */

import edu.duke.*;
import java.util.ArrayList;

public class CharactersInPlay
{
    // instance variables
    private ArrayList<String> myCharacters;
    private ArrayList<Integer> myCharacterFreqs;

    /**
     * Constructor for objects of class CharactersInPlay
     */
    public CharactersInPlay()
    {
        // initialise instance variables
        myCharacters = new ArrayList<String>();
        myCharacterFreqs = new ArrayList<Integer>();
    }
    
    public void update(String person){
        person = person.trim();
        int index = myCharacters.indexOf(person);
        if (index == -1){
                myCharacters.add(person);
                myCharacterFreqs.add(1);
            }
            else {
                int freq = myCharacterFreqs.get(index);
                myCharacterFreqs.set(index,freq+1);
            }
    }

    public void findAllCharacters(){
        FileResource resource = new FileResource();
        for(String line : resource.lines()){
            int periodInLine = line.indexOf(".");
            if(periodInLine != -1){
                String possibleName = line.substring(0, periodInLine);
                update(possibleName);
            }
        }
    }
    
    public void tester(){
        findAllCharacters();
        int index = findMax();
        for(int i=0;i<myCharacters.size();i++){
        System.out.println(myCharacters.get(i) + " " + myCharacterFreqs.get(i));
        }
        System.out.println("Character with most speaking parts: " + myCharacters.get(index)+" "+myCharacterFreqs.get(index) + "\n");
        charactersWithNumPart(10, 15);
    }
    
    public int findMax(){
        int max = myCharacterFreqs.get(0);
        int maxIndex = 0;
        for(int k=0; k < myCharacterFreqs.size(); k++){
            if (myCharacterFreqs.get(k) > max){
                max = myCharacterFreqs.get(k);
                maxIndex = k;
            }
        }
        return maxIndex;
    }
    
     public void charactersWithNumPart(int num1, int num2){
         for (int k=0; k < myCharacterFreqs.size(); k++) {
            if (myCharacterFreqs.get(k) >= num1 && myCharacterFreqs.get(k) <= num2) {
                System.out.println(myCharacters.get(k)+ " " + myCharacterFreqs.get(k));
            }
        }
     }
}