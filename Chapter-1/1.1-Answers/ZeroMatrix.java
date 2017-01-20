/**
 * Loops through a matrix and if an entry is zero then set all of the rows and columns to zero.
 */
import java.util.*;

public class ZeroMatrix
{
    /**
     * This is one way to do it but it is probably the worst way to do it.
     */
    public static int[][] createZeroMatrix(int[][] matrix) 
    {
        int m = matrix.length;
        int n = matrix[0].length;
        // extra m * n storage to know which ones to mark.
        boolean[][] zeroMatrix = new boolean[m][n];
        // Loop through and mark ones to set to zero.
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(matrix[i][j] == 0) zeroMatrix[i][j] = true;
            }
        }
        // Actually set the correct values.
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(zeroMatrix[i][j]) {
                    // loop through rows
                    for(int row = 0; row < m; row++) {
                        matrix[row][j] = 0;
                        zeroMatrix[row][j] = false;
                    }
                    // loop through columns
                    for(int col = 0; col < n; col++) {
                        matrix[i][col] = 0;
                        zeroMatrix[i][col] = false;
                    }
                }
            }
        }
        return matrix;
    }
}