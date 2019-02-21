/**
 * 26
 * @param {number[]} nums
 * @return {number}
 */
var removeDuplicates = function (nums) {

    let i = 0;
    for (let j = i + 1; j < nums.length; j++) {
        if (nums[j] !== nums[i]) {
            nums[++i] = nums[j];
        }
    }

    return i + 1;
};