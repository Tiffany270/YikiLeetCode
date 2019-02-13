/**
 * 118杨辉三角
 * @param {number} numRows
 * @return {number[][]}
 */
var generate = function (numRows) {

    let res = [], inner = [];
    for (let i = 0; i < numRows; i++) {
        let prev = 1, temp;
        for (let j = 1; j < inner.length; j++) {
            temp = inner[j];
            inner[j] = temp + prev;
            prev = temp;
        }
        inner.push(1);
        let arr = inner.slice();
        res.push(arr);
    }
    return res;
};