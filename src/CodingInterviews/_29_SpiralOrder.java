package CodingInterviews;

import java.util.Arrays;

/*
*
* 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。

        示例 1：
        输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
        输出：[1,2,3,6,9,8,7,4,5]
        示例 2：
        输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
        输出：[1,2,3,4,8,12,11,10,9,5,6,7]

* */
public class _29_SpiralOrder {
    /*
    * Solution:
    * 四个方向，打印外圈后依次内圈
    * 开始的地方为对角线那个数字
    * */

    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }
        int rows = matrix.length;
        int columns = matrix[0].length;
        int[] res = new int[rows * columns];
        int index = 0;
        int left = 0, right = columns - 1, top = 0, bottom = rows - 1;

        while (left <= right && top <= bottom) {

            for (int column = left; column <= right; column++) {
                res[index++] = matrix[top][column];// left -> right
            }
            for (int row = top + 1; row <= bottom; row++) {
                res[index++] = matrix[row][right];// top -> bottom
            }

            // 防止越界
            if (left < right && top < bottom) {

                for (int column = right - 1; column > left; column--) {//right-1为了避开已经打印的元素
                    res[index++] = matrix[bottom][column];
                }

                for (int row = bottom; row > top; row--) {
                    res[index++] = matrix[row][left];
                }

            }


            left++;
            right--;
            top++;
            bottom--;
        }


        return res;
    }

    public static void main(String[] args) {
        _29_SpiralOrder func = new _29_SpiralOrder();
        int[][] arr = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        System.out.println(Arrays.toString(func.spiralOrder(arr)));
    }
}
