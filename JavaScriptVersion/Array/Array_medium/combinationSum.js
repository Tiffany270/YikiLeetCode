/**
 * 39. Combination Sum
 * @param {number[]} candidates
 * @param {number} target
 * @return {number[][]}
 */
var combinationSum = function (candidates, target) {

    let res = [];
    let temp = [];
    candidates.sort();
    dfs(0, target);
    return res;

    function dfs(start, target) {
        if (target === 0) {
            return res.push(temp.slice())//slice方法返回一个新的数组对象,原始数组不会被改变,如果直接push temp的话是引用！。
        }
        if (target < 0 || start === candidates.length) {
            return
        }
        temp.push(candidates[start]);
        dfs(start, target - candidates[start]);
        temp.pop();
        dfs(start + 1, target);
    }


};

console.log(combinationSum([2, 5, 3], 7));