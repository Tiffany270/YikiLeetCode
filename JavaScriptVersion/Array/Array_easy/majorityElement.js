/**
 * 编号169
 * @param {number[]} nums
 * @return {number}
 */
var majorityElement = function (nums) {
    let major = nums[0];
    let count = 0;

    nums.forEach(x => {
        if (count === 0) {
            major = x;
        }
        if (major === x) {
            count++;
        } else {
            count--;
        }

    });
    return major;

};