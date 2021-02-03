package Leetcode.medium;

/*
        * You are given an integer array nums sorted in ascending order (with distinct values),
        * and an integer target.
        Suppose that nums is rotated at some pivot unknown to you beforehand
        (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
        If target is found in the array return its index, otherwise, return -1.
            Example 1:
            Input: nums = [4,5,6,7,0,1,2], target = 0
            Output: 4
            找0的索引

            Example 2:
            Input: nums = [4,5,6,7,0,1,2], target = 3
            Output: -1

            Example 3:
            Input: nums = [1], target = 0
            Output: -1
 */
public class _33_SearchInRotatedSortedArray {
    /*
     * 有序搜索就要想到二分，在mid里区分哪边有序，对比对比就在哪个部分找target
     * （其他：这种题目小数目遍历得了）
     * */

    public int search(int[] nums, int target) {
        int len = nums.length;
        if (len == 0) {
            return -1;
        }
        if (len == 1) {
            return nums[0] == target ? 0 : -1;
        }

        int left = 0;
        int right = len - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[0] <= nums[mid]) {
                if (nums[0] <= target
                        && target <= nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[len - 1]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }
}
