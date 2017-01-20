/**
 * Given an int[][] rotate it 90 degrees can you do it without using extra storage?
 */

import java.util.*;

public class RotateMatrix
{
    public static void main(String[] args)
    {

    }

    /**
     * Turn 
     * 1 2 3 4
     * 5 6 7 8
     * 9 10 11 12
     * 13 14 15 16
     * 
     * into
     * 
     * 13 9 5 1
     * 14 10 6 2
     * 15 11 7 3
     * 16 12 8 4 
     */
    public static int[][] rotateMatrix(int[][] matrix)
    {
        int n = matix.length();
        if(n == 1) return matrix;
        for(int layer = 0; layer < n /2; layer++) {
            int first = layer;
            int last = n - 1 - layer;
            for(int i = first; i < last; i++) {
                int offset = i - first;
                int top = matrix[first][i];
                // left -> top
                matrix[first][i] = matrix[las-offset][first];
                // bottom -> left
                matrix[last-offset][first] = matrix[last][last-offset];
                // right -> bottom
                maxtrix[last][last - offset] = matrix[i][last];
                // top -> right
                matrix[i][last] = top; // right <- saved top.
            }
        }
        return matrix;
    }
}