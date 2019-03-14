/**
 * 78
 * @param {number[]} nums
 * @return {number[][]}
 */
let subsets = function (nums) {
    let res = [];
    res.push([]);
    for (let i = 0; i < nums.length; i++) {
        let size = res.length;
        for (let j = 0; j < size; j++) {
            console.log([...res[j]]);
            res.push([...res[j],nums[i]]);
        }
    }


    return res;


};
console.log(subsets([1, 2, 3]));