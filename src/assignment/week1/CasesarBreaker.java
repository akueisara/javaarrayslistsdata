package assignment.week1;

/**
 * Assignment 4: Caesar Cipher Two Keys Decrypt
 * 
 * @version February 29, 2016
 */

import edu.duke.*;

public class CasesarBreaker
{
    public int[] countLetters(String message){
        String alph = "abcdefghijklmnopqrstuvwxyz";
        int[] counts = new int[26];
        for (int k = 0; k<message.length(); k++) {
            char ch = Character.toLowerCase(message.charAt(k));
            int dex = alph.indexOf(ch);
            if (dex != -1) {
                counts[dex] += 1;
            }
        }
        return counts;
    }
    
     public int maxIndex(int[] values){
        int max=0;
        for(int i=0; i< values.length;i++){
            if(values[i] > values[max]){
                max = i;
            }  
        }    
        return max;
    }
    
    public String decrypt(String encrypted, int key){
        CaesarCipher cc = new CaesarCipher();
        String message = cc.encrypt(encrypted, 26-key);
        return message;
    }
    
    public String halfOfString(String message, int start){
        String answer = "";   
        for (int k = start; k< message.length() ; k+= 2) {
            answer = answer + message.charAt(k);    	
        }
        return answer;
    }
    
    public int getKey(String s){
        int[] letterFreqs = countLetters(s);
        int maxindex = maxIndex(letterFreqs);
        int dkey = maxindex - 4;
        if (maxindex < 4) {
            dkey = 26 - (4-maxindex);
        }
        return dkey;
    }
    
   public void decryptTwoKeys(String encrypted){
         String s1 = halfOfString(encrypted, 0);
         String s2 = halfOfString(encrypted, 1);
         System.out.println(s1);
         System.out.println(s2);
         int key1 = getKey(s1);
         int key2 = getKey(s2);
         System.out.println("Two keys found: key1= " + key1 + ", key2= " + key2);
         CaesarCipher cc = new CaesarCipher();
         System.out.println(cc.encryptTwoKeys(encrypted, 26-key1, 26-key2));
    }
    
    public void testDecrypt() {
        String encrypted1 = "Ghdu Rzhq, Qr pdwwhu zkdw brx pdb kdyh khdug, wkhuh lv qr fdnh lq wkh frqihuhqfh urrp. Wkh fdnh lv d olh. Sohdvh nhhs zrunlqj rq Frxuvhud ylghrv. Wkdqnv, Guhz";
        String encrypted2 = "Stpg Dltc, Cd bpiitg lwpi ndj bpn wpkt wtpgs, iwtgt xh cd rpzt xc iwt rdcutgtcrt gddb. Iwt rpzt xh p axt. Eatpht ztte ldgzxcv dc Rdjghtgp kxstdh. Iwpczh, Sgtl";
        System.out.println("Encrypted message:\n" + encrypted2);
        System.out.println("\nkey:" + getKey(encrypted2));
        System.out.println("\nDecrypted message:\n" + decrypt(encrypted2,getKey(encrypted2)));
        System.out.println("\nEncrypted message:\n" + encrypted1);
        System.out.println("\nkey:" + getKey(encrypted1));
        System.out.println("\nDecrypted message:\n" + decrypt(encrypted1,getKey(encrypted1)));
        decryptTwoKeys("Akag tjw Xibhr awoa aoee xakex znxag xwko");
        
        FileResource fr = new FileResource();
        String message = fr.asString();
         String s1 = halfOfString(message, 0);
         String s2 = halfOfString(message, 1);
         System.out.println(s1);
         System.out.println(s2);
         int key1 = getKey(s1);
         int key2 = getKey(s2);
         System.out.println("Two keys found: key1= " + key1 + ", key2= " + key2);
         CaesarCipher cc = new CaesarCipher();
         System.out.println(cc.encryptTwoKeys(message, 26-key1, 26-key2));
    }
    
   
}
