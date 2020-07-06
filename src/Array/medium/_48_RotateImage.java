package Array.medium;

/*
 * You are given an n x n 2D matrix representing an image.
 * Rotate the image by 90 degrees (clockwise).
 * 48. Rotate Image/旋转图像
 * Note:
 * You have to rotate the image in-place,
 * which means you have to modify the input 2D matrix directly.
 * DO NOT allocate another 2D matrix and do the rotation.
 * 其他
 * 看清楚：输入的是个二维数组，示例明明有歧义- -...
 * */

public class _48_RotateImage {

    /*思路
     * 循环四个点作为一圈顺时针交换元素
     * 结束后收缩外圈进入下一圈
     * 1 2 3     7 8 9     7 4 1
     * 4 5 6  => 4 5 6  => 8 5 2
     * 7 8 9     1 2 3     9 6 3
     * 边界问题：
     * 可以用for也可以用while
     * 如果是用点标记，[p1++][p2--] 固定值可以 left=0,right=len-1
     * 以此来组合旋转点
     * 当p1==right或者p2==left的时候
     * 就是中心点到了，停止循环。
     * */

    public void rotate(int[][] matrix) {
        int left = 0;
        int right = matrix.length-1;
        while(left<=right){
            int p1 = left;
            int p2 = right;
            while(p2!=left){
                int temp = matrix[left][p1];
                matrix[left][p1] = matrix[p2][left];
                matrix[p2][left] = matrix[right][p2];
                matrix[right][p2]=matrix[p1][right];
                matrix[p1][right]=temp;
                p1= p1+1;
                p2 = p2-1;
            }
            left = left+1;
            right = right -1;
        }
    }

    

}
