/**
 * 编号1
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var _01twoSum = function (nums, target) {

    var res = [];
    var map = new Map();

    for (var i = 0; i < nums.length; i++) {

        // 往前找，找到了把前一个push，再push自己
        if (map.has(target - nums[i])) {
            res.push(map.get(target - nums[i]));
            res.push(i);
        }


        map.set(nums[i], i);
    }

    return res;
};

var test = [22,7,2,15];
var res = _01twoSum(test,9);
console.log((res));

