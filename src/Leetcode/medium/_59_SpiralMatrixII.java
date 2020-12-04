package Leetcode.medium;

import java.util.Arrays;

/* 59螺旋矩阵 II
 * 给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 *
 * Given a positive integer n,
 * generate a square matrix filled with elements from 1 to n2 in spiral order.
 * */
public class _59_SpiralMatrixII {

    /*思路
     * 二维数组+遍历旋螺填填进去
     * 一般是 → [top][i]
     *       ↓ [i][right]
     *       ← [bottom][i]
     *       ↑ [i][left]
     *  处理好边界即可
     * */


    public static int[][] generateMatrix(int n) {

        int[][] res = new int[n][n];
        int top = 0;
        int right = n - 1;
        int bottom = n - 1;
        int left = 0;
        int num = 1;

        while (left <= right && top <= bottom) {
            for (int i = left; i <= right; i++) {
                res[top][i] = num++;
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                res[i][right] = num++;
            }
            right--;
            for (int i = right; i >= left; i--) {
                res[bottom][i] = num++;
            }
            bottom--;
            for (int i = bottom; i >= top; i--) {
                res[i][left] = num++;
            }
            left++;
        }

        return res;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++)
            System.out.println(Arrays.toString(generateMatrix(3)[i]));
    }

}
