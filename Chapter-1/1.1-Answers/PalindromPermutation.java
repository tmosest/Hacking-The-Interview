/**
 * File to check if a String is permutation of a palindrome.
 */
import java.util.*;

public class PalindromePermutation
{
    /**
     * Test
     */ 
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        in.close();
        System.out.println(isPermutationOfPalindrome(s));
    }

    /**
     * Could also do this one with an array instead.
     */
    public static boolean isPermutationOfPalindrome(String s)
    {
        HashMap<Character, Integer> letterCounts = new HashMap<Character, Integer> ();
        int length = 0;

        for(int i = 0; i < s.length(); i++) {
            char letter = s.charAt(i);
            if(letter != ' ') {
                length++;
                int count = (letterCounts.get(letter) == null) ? 0 : letterCounts.get(letter);
                letterCounts.put(letter, ++count);
            }
        }

        // Logic: if string is odd it is allow to have one odd character.
        int oddCount = 0;
        boolean sIsOdd = length % 2 == 1;
        for(int count : letterCounts.values()) {
            if(count % 2 == 1) {
                if(sIsOdd) oddCount++;
                if(!sIsOdd || oddCount > 1) return false;
            } 
        }

        return true;
    }
}