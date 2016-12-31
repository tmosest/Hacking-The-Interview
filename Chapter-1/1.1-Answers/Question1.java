/**
* This class contains solutions to Question 1.1
* @author tmosest
*/
import java.util.*;

public class Question1
{

    /**
    * Tests
    */
    public static void main(String[] args)
    {
        String s1 = "abc";
        System.out.println("s1: " + s1 + " isUniqueHashMap: " + isUniqueHashMap(s1));
        s1 = "abca";
        System.out.println("s1: " + s1 + " isUniqueHashMap: " + isUniqueHashMap(s1));
    }

    /**
    * In this example we are going to use an addtional data structure
    * called a hashmap. Instead of a hashmap we could have used a set!
    *
    * A hasmap takes O(1) or O(n) depending on collision.
    * We have one for loop at O(n).
    * This mean could have O(n) to O(n^2) depending on collisions.
    * We also use additional O(n) memory.
    *
    * A potential problem is that A and a are different!
    */
    public static boolean isUniqueHashMap(String s)
    {
        HashMap<Character, Integer> letterCounts = new HashMap<Character, Integer>();
        for(int i = 0; i < s.length(); i++) {
            char letter = s.charAt(i);
            int letterCount = (letterCounts.get(letter) == null) ? 0 : letterCounts.get(letter);
            if(letterCount > 0) {
                return false;
            } else {
                letterCounts.put(letter, ++letterCount);
            }
        }
        return true;
    }

    /**
    * In this example we use a basic array to store lowercase letter frequencies.
    * The only problem here is that uppercase letters and special characters could break it.
    * An array is always O(1) lookup so that's an improvement over the hasmap.
    * This mean O(n) complexity and O(1) memory.
    *
    * A potential problem is that A and a are different!
    */
    public static boolean isUniqueSmallArray(String s)
    {
        int[] lettersCount = new int[26];
        for(int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            if(lettersCount[index] > 0) 
                return false;
            else {
                lettersCount[index]++;
            }
        }
        return true;
    }

    /**
    * In this example we use a basic array to store lowercase letter frequencies.
    * By increasing the size of the array we can store more.
    * An array is always O(1) lookup so that's an improvement over the hasmap.
    * This mean O(n) complexity and O(1) memory.
    *
    * A potential problem is that A and a are different!
    */
    public static boolean isUniqueLargeArray(String s)
    {
        int[] lettersCount = new int[280];
        for(int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            if(lettersCount[index] > 0) 
                return false;
            else {
                lettersCount[index]++;
            }
        }
        return true;
    }

} //end Question 1.1 
