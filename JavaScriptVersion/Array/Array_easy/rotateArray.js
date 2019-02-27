/**
 * 189
 * @param {number[]} nums
 * @param {number} k
 * @return {void} Do not return anything, modify nums in-place instead.
 */

reverse = function (nums, start, end) {
    console.log(start, end);

    while (start < end) {
        let temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
        start++;
        end--;
    }
    console.log(nums);

};

var rotate = function (nums, k) {
    k = k % nums.length;
    if (nums.length <= 1) {
        return;
    }
    reverse(nums, 0, nums.length - 1);
    reverse(nums, 0, k - 1);
    reverse(nums, k, nums.length - 1);
};

let arr = [1, 2];
rotate(arr, 3);
console.log(arr);


