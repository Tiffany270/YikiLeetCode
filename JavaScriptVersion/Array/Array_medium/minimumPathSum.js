/**
 * 64
 * @param {number[][]} grid
 * @return {number}
 */
var minPathSum = function (grid) {
    let dp = grid;
    let width = grid[0].length;//行
    let height = grid.length;//列
    for (let i = 1; i < width; i++) {
        dp[0][i] = grid[0][i] + grid[0][i - 1];
    }
    for (let j = 1; j < height; j++) {
        dp[j][0] = grid[j][0] + grid[j - 1][0];
    }

    for (let i = 1; i < height; i++) {
        for (let j = 1; j < width; j++) {
            dp[i][j] = grid[i][j] + (grid[i - 1][j] > grid[i][j - 1] ? grid[i][j - 1] : grid[i - 1][j]);
        }
    }


    return dp[height - 1][width - 1];
};