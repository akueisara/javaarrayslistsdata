package week2.assignment;

/**
 * Assignment 4: Codon Count
 * The program finds out how many times each codon occurs in a strand 
 * of DNA based on reading frames.
 * 
 * @author Kuei-Jung Hu
 * @since   2016-04-20
 */

import edu.duke.*;
import java.util.*;

public class CodonCount
{
    // instance variables
    private HashMap<String, Integer> DNAmap;

    /**
     * Constructor for objects of class CodonCount
     */
    public CodonCount()
    {
        // initialise instance variables
        DNAmap = new HashMap<String, Integer>();
    }

    /**
     * The method builds a new map of codons mapped to their counts from
     * the string dna with the reading frame with the position start
     * @param  start
     * @param  dna
     * @return  Nothing
     */
     private void buildCodonMap(int start, String dna)
    {
      DNAmap.clear(); // make the map is empty before building it
      String current;
      for(int i = 0;i < (dna.length() - start)/3;i++)
      {
    	  current = dna.substring(start+i*3, start+i*3+3);
          if (!DNAmap.containsKey(current)) DNAmap.put(current, 1);
          else DNAmap.put(current, DNAmap.get(current)+1);
      }
    }
    
    /**
     * This method returns a String, the codon in a reading frame that has the largest count.
     * 
     * @param Nothing 
     * @return  String
     */
    private String getMostCommonCodon()
    {
      int value = 0;  
      int largestcount = 0;
      String largestkey = null;
      for(String key : DNAmap.keySet())
      {
          value = DNAmap.get(key);
          if (largestcount < value)
          {
              largestcount = value;
              largestkey = key;
          }
      }
      return largestkey;
    }
    
    /**
     * This method prints all the codons in the HashMap along with their counts 
     * if their count is between start and end, inclusive.
     * @param start
     * @param end 
     * @return Nothing
     */
    private void printCodonCounts(int start, int end) 
    {
        int value = 0;
        for(String key : DNAmap.keySet()) 
        {
            value = DNAmap.get(key);
            if (value >= start && value <= end)
                System.out.println( key + " " + value + "\t");
        }
    }
    
    public void tester()
    {
         FileResource fr = new FileResource();
         String dna = fr.asString().trim();
         dna = dna.toUpperCase();
         int start = 1;
         int end = 5;
         
         buildCodonMap(0, dna);
         System.out.println("Reading frame starting with 0 results in "+DNAmap.size()+" unique codons"+"\t");
         String largest = getMostCommonCodon();
         System.out.println("Most common codon is "+largest+" with count "+DNAmap.get(largest)+"\t"); 
         System.out.println("Counts of codons between "+start+" and "+end+" inclusive are:"+"\t");
         printCodonCounts(start, end);
         
         buildCodonMap(1, dna);
         System.out.println("Reading frame starting with 1 results in "+DNAmap.size()+" unique codons"+"\t");
         largest = getMostCommonCodon();
         System.out.println("Most common codon is "+largest+" with count "+DNAmap.get(largest)+"\t"); 
         System.out.println("Counts of codons between "+start+" and "+end+" inclusive are:"+"\t");
         printCodonCounts(start, end);
         
         buildCodonMap(2, dna);
         System.out.println("Reading frame starting with 2 results in "+DNAmap.size()+" unique codons"+"\t");
         largest = getMostCommonCodon();
         System.out.println("Most common codon is "+largest+" with count "+DNAmap.get(largest)+"\t"); 
         System.out.println("Counts of codons between "+start+" and "+end+" inclusive are:"+"\t");
         printCodonCounts(start, end);
    }
}

