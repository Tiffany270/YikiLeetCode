package Leetcode.medium;

/*
* Given an m x n matrix. If an element is 0, set its entire row and column to 0. Do it in-place.
Follow up:
A straight forward solution using O(mn) space is probably a bad idea.
A simple improvement uses O(m + n) space, but still not the best solution.
Could you devise a constant space solution?

                   Input: matrix =
                        [[1,1,1],
                        [1,0,1],
                        [1,1,1]]
                   Output:
                        [[1,0,1],
                        [0,0,0],
                        [1,0,1]]

* */


import java.util.HashSet;
import java.util.Set;

public class _73_SetMatrixZeroes {

    /*Solution 1
     * store check flag to two sets
     * */
    public void setZeroes0(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        Set<Integer> rows = new HashSet<Integer>();
        Set<Integer> cols = new HashSet<Integer>();

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (matrix[i][j] == 0) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (rows.contains(i) || cols.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    /*Approach 2: O(1) Space, Efficient Solution
     *
                if cell[i][j] == 0 {
                cell[i][0] = 0
                cell[0][j] = 0
            }
     * */
    public void setZeroes(int[][] matrix) {
        Boolean isCol = false;
        int r = matrix.length;
        int c = matrix[0].length;

        for (int i = 0; i < r; i++) {
            if (matrix[i][0] == 0) {
                isCol = true;
            }

            for (int j = 1; j < c; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        for (int i = 1; i < r; i++) {
            for (int j = 1; j < c; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        // See if the first row needs to be set to zero as well
        if (matrix[0][0] == 0) {
            for (int j = 0; j < c; j++) {
                matrix[0][j] = 0;
            }
        }

        // See if the first column needs to be set to zero as well
        if (isCol) {
            for (int i = 0; i < r; i++) {
                matrix[i][0] = 0;
            }
        }

    }
}
