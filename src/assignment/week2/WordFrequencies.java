package assignment.week2;

/**
 * Assignment 1: Most Frequent Word
 * 
 * @version March 15, 2016
 */

import edu.duke.*;
import java.util.ArrayList;

public class WordFrequencies
{
	private ArrayList<String> myWords;
	private ArrayList<Integer> myFreqs;

	public WordFrequencies() {
		myWords = new ArrayList<String>();
		myFreqs = new ArrayList<Integer>();
	}

	public void findUnique(){
		myWords.clear();
		myFreqs.clear();

		FileResource resource = new FileResource();

		for(String s : resource.words()){
			s = s.toLowerCase();
			int index = myWords.indexOf(s);
			if (index == -1){
				myWords.add(s);
				myFreqs.add(1);
			}
			else {
				int freq = myFreqs.get(index);
				myFreqs.set(index,freq+1);
			}
		}
	}

	public void tester(){
		findUnique();
		System.out.println("Number of unique words: " + myWords.size());
		int index = findIndexOfMax();
		for(int i=0;i<myWords.size();i++){
			System.out.println(myFreqs.get(i) + " " + myWords.get(i));
		}
		System.out.println("The word that occurs most often and its count are: "+myWords.get(index)+" "+myFreqs.get(index));
	}

	public int findIndexOfMax(){
		int max = myFreqs.get(0);
		int maxIndex = 0;
		for(int k=0; k < myFreqs.size(); k++){
			if (myFreqs.get(k) > max){
				max = myFreqs.get(k);
				maxIndex = k;
			}
		}
		return maxIndex;
	}
}
