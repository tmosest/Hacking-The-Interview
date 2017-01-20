/**
 * Take some thing abbccc and converts it to a1b2c3 unless the second string is longer.
 */
import java.util.*;

public class StringCompression
{
    private static boolean debugMode = false;

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        in.close();
        System.out.println(compressString(s));
    }

    /**
     * This is a pretty good solution however the only downside is that it doesn't check to see if
     * we need StringBuilder upfront or not.
     */
    public static String compressString(String input)
    {
        StringBuilder sb = new StringBuilder();
        int n = input.length();
        int i = 0;
        do {
            int j = i, count = 0;
            char letter = input.charAt(i), letter2 = input.charAt(j);
            if(debugMode)
                System.out.println("letter: " + letter + " letter2: " + letter2);
            while(j < n && letter == letter2) {
                ++j;
                count++;
                if(j < n)
                    letter2 = input.charAt(j);
                else
                    letter2 = '?';
                if(debugMode)
                    System.out.println("letter: " + letter + " letter2: " + letter2);
            }
            i = j;
            sb.append(letter);
            sb.append(String.valueOf(count));
        } while(i < n);
        return (sb.toString().length() > n) ? input : sb.toString();
    }
}