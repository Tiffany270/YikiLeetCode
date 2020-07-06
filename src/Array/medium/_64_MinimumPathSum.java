package Array.medium;

/*64. Minimum Path Sum最小路径和
 * Given a m x n grid filled with non-negative numbers,
 * find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 * Note: You can only move either down or right at any point in time.*/

public class _64_MinimumPathSum {

    /*思路
     * DP/动态规划
     * 新建一个二维数组dp作为保存的路径值，一一对应原grid
     * 存在dp(i,j)=min(dp[i-1][j],dp[i][j-1])+grid[i][j]
     * 详细：
     * 形如 grid                     dp
     *     1 3 1  (1)先经历       1 4 5
     *     1 5 1  两个for得到 ==> 2
     *     4 2 1  第一列和第一行   6
     *
     * (2)现在需要计算中间，中间需要辨别是加从上方下来的，还是从左边下来的
     * 所以根据公式 当前dp[i][j]这个点=min(左边的dp值，上边的dp值)
     *       grid               dp
     *       1 3 1            1      4     5
     *       1 5 1   ==>      2   [9]?【7】 ..
     *       4 2 1            6   ..
     *
     *         dp
     *  (3)   1 4 5
     *  ==>   2 7 6
     *        6 8 7
     *
     *    最后return dp[i][j]
     * */

    public int minPathSum(int[][] grid) {

        int[][] dp = grid;
        int width = grid[0].length;//行
        int height = grid.length;//列
        for (int i = 1; i < width; i++) {
            dp[0][i] = grid[0][i] + grid[0][i - 1];
        }
        for (int j = 1; j < height; j++) {
            dp[j][0] = grid[j][0] + grid[j - 1][0];
        }

        for (int i = 1; i < height; i++) {
            for (int j = 1; j < width; j++) {
                dp[i][j] = grid[i][j] + (grid[i - 1][j] > grid[i][j - 1] ? grid[i][j - 1] : grid[i - 1][j]);
            }
        }


        return dp[height - 1][width - 1];
    }

    public static void main(String[] args) {
//        int[][] dp = new int[2][3];
//        System.out.println(dp[0].length);

    }
}
