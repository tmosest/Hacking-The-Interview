/**
 * Turn a string into a url by replacing ' ' with '%20'
 * You are given the true length of the string.
 */

public class URLify
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        String s = in.next();

        in.close;

    }

    public static String urlify(String s, int n)
    {
        char[] c = new char[s.length()];
        int cIndex = 0;
        for(int i = 0; i < n; i++) {
            char letter = s.charAt(i);
            if(letter == ' ') {
                c[cIndex++] = '\%'; // /% or %?
                c[cIndex++] = '2';
                c[cIndex++] = '0';
            } else {
                c[cIndex++] = letter;
            }
        }
        return c.toString();
    }
}
