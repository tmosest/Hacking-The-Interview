/**
 * Determin is one string is a rotation of another using just on is subtring call.
 * Example "waterbottle" and "erbottlewat"
 */
import java.util.*;

public class StringRotation
{
    public static boolean isStringRotation(String s1, String s2)
    {
        s2 = s2 + s2;
        return s1.isSubtring(s2);
    }
}