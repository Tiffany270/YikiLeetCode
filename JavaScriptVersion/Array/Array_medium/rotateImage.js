/**
 * 48
 * @param {number[][]} matrix
 * @return {void} Do not return anything, modify matrix in-place instead.
 */
var rotate = function(matrix) {
    let left = 0;
    let right = matrix.length-1;
    while(left<=right){
        let p1 = left;
        let p2 = right;
        while(p2!==left){
            let temp = matrix[left][p1];
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
};