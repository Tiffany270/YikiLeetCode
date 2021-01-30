package Leetcode.medium;
/*
         Given a sorted array nums,
        remove the duplicates in-place such that duplicates appeared at most twice and return the new length.
        Do not allocate extra space for another array;
        you must do this by modifying the input array in-place with O(1) extra memory.

            Example 1:
            Input: nums = [1,1,1,2,2,3]
            Output: 5, nums = [1,1,2,2,3]

            Example 2:
            Input: nums = [0,0,1,1,1,1,2,3,3]
            Output: 7, nums = [0,0,1,1,2,3,3]

            most twice = 最多两次

* */

public class _80_RemoveDuplicatesFromSortedArrayII {
    // 就删掉，用count计算 没什么含量
    public int removeDuplicates(int[] nums) {
        int i = 1;
        int count = 1;
        int len = nums.length;

        while (i < len) {
            if (nums[i] == nums[i - 1]) {
                count++;
                if (count > 2) {
                    for (int t = i + 1; t < len; t++) {
                        nums[t - 1] = nums[t];
                    }
                    i--;
                    len--;
                }
            } else {
                count = 1;
            }
            i++;
        }

        return len;
    }
}
