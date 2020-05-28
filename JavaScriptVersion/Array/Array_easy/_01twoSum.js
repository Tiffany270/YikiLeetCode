/**
 * 编号1
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var _01twoSum = function (nums, target) {

    let res = [];
    let map = new Map();

    for (let i = 0; i < nums.length; i++) {

        if (map.has(target - nums[i])) {
            res.push(map.get(target - nums[i]));
            res.push(i);
        }


        map.set(nums[i], i);
    }

    return res;
};

