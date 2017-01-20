/**
 * Determine if one string is can be transformed into another using:
 * one or zero move of the following: 1) insert a character, 2) remove a character, 3) replace a character.
 */
import java.util.*;

public class OneAway
{
    /**
     * Main test
     */
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        String fromString = in.next();
        String toString = in.next();
        in.close();
        System.out.println(canBeTransformed(fromString, toString));
    }

    public static boolean canBeTransformed(String from, String to)
    {
        int[] fromCounts = new int[128];
        int[] toCounts = new int[128];
        // Count the letters in the from word.
        for(int i = 0; i < from.length(); i++) {
            fromCounts[from.charAt(i)]++;
        }
        // Count the letters in the to word.
        for(int i = 0; i < to.length(); i++) {
            toCounts[to.charAt(i)]++;
        }
        //Now we can look through the two counts and compare
        int differenceCount = 0;
        for(int i = 0; i < fromCounts.length; i++) {
            if(fromCounts[i] != toCounts[i]) {
                differenceCount += Math.abs(toCounts[i] - fromCounts[i]);
                if(differenceCount > 2) return false;
            }
        }
        return true;
    }
}