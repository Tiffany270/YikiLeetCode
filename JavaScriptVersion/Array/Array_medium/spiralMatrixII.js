/**
 * 59 螺旋矩阵II
 * @param {number} n
 * @return {number[][]}
 */
var generateMatrix = function (n) {
    let res = [];
    let top = 0;
    let right = n - 1;
    let bottom = n - 1;
    let left = 0;
    let num = 1;
    for (let i = 0; i < n; i++)
        res.push([]);

    while (left <= right && top <= bottom) {
        for (let i = left; i <= right; i++) {
            res[top][i] = num++;
        }
        top++;
        for (let i = top; i <= bottom; i++) {
            res[i][right] = num++;
        }
        right--;
        for (let i = right; i >= left; i--) {
            res[bottom][i] = num++;
        }
        bottom--;
        for (let i = bottom; i >= top; i--) {
            res[i][left] = num++;
        }
        left++;
    }

    return res;

};