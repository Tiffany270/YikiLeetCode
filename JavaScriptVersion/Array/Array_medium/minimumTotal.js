/**
 * 120
 * @param {number[][]} triangle
 * @return {number}
 */
var minimumTotal = function (triangle) {
    let k = triangle.length;//高
    let len = triangle[k-1].length;//底长
    let minPath = [];
    for (let i = 0; i < len; i++) {
        minPath[i] = triangle[k - 1][i];
    }
    for (let i = k - 2; i >= 0; i--) {
        let temp  = triangle[i];
        for (let j = 0; j < temp.length; j++) {
            minPath[j] = Math.min(minPath[j], minPath[j + 1]) + temp[j];
        }
    }

    return minPath[0];
    
};
let arr=[ [ 2], [ 3, 8 ], [ 6,5,7], [ 4, 1, 8, 3 ] ];
minimumTotal(arr);