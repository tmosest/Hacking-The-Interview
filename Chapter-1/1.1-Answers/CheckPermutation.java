/**
 * A class by tmosest to check if two strings are permutations of one another.
 * Two strings are a permutation of one another if they both contain the same count for each letters.
 */
import java.utils.*;

public class CheckPermutation
{
    /**
     * Main method to test this class.
     */ 
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        String s1 = in.next();
        String s2 = in.next();
        in.close;
        
        // method 1:
        System.out.println("Brute force: ");
        System.out.println(isPermuationBruteForce(s1, s2));

        // method 2
    }

    /**
     * Method one.
     * Extreme bad brute force.
     * n:s1.length() and m:s2.lenght()
     * m extra storage
     * O(n * m) complexity.
     * 
     * We could have also just used an integer instead of an array or a long.
     */
    public static boolean isPermuationBruteForce(String s1, String s2)
    {
        int n = s1.length();
        int m = s2.length();
        // Deal with strings of different lenght.
        if(n != m) return false;
        // Create a boolean array to determine which letters have been used.
        boolean[] s2Used = new boolean[m];
        // O(m * n) loop
        for(int i = 0; i < n; i++) {
            char s1Letter = s1.charAt(i);
            for(int j = 0; j < m; j++) {
                char s2letter = s2.charAt(j);
                // If letters match and it hasn't already been used then mark it off
                if(s1Letter == s2Letter && !s2Used[j]) {
                    s2Used[j] == true;
                    break; //break out of this for loop.
                } else {
                // We couldn't find the letter or we ran out of them so we mark it off.
                    return false;
                }
            }
        }

        return true;
    }

    /**
     * Method two.
     * HashMap method.
     * n:s1.length() and m:s2.length()
     * n extra space or less.
     * O(n)
     * 
     * Another approach would be to store the char counts in a 128 array.
     * Or however many characters you need and then increment or decrement that.
     */
    public static boolean isPermuationHashMap(String s1, String s2)
    {
        int n = s1.length();
        int m = s2.length();
        if(n != m) return false;
        // Create a hashmap
        HashMap letterCounts = new HashMap();
        // Loop through s1.
        for(int i = 0; i < n; i++) {
            char letter = s1.charAt(i);
            int count = (letterCounts.get(letter) == null) ? 0 : letterCounts.get(letter);
            letterCounts.put(letter, ++count);
        }
        // Loop through s2.
        for(int i = 0; i < m; i++) {
            char letter = s2.charAt(i);
            int count = (letterCounts.get(letter) == null) ? 0 : letterCounts.get(letter);
            letterCounts.put(letter, --count);
        }
        // Loop through hasmap values
        for(int count : letterCounts.values()) {
            if(count != 0) return false; // There was a left over letter.
        }
        // No left over letters.
        return true;
    }
}