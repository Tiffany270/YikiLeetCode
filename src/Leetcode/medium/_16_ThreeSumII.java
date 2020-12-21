package Leetcode.medium;


/*
* Given an array nums of n integers and an integer target,
* find three integers in nums such that the sum is closest to target.
* Return the sum of the three integers.
 * You may assume that each input would have exactly one solution.
    Example 1:
    Input: nums = [-1,2,1,-4], target = 1
    Output: 2
    Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
* */


import java.util.Arrays;

/*
    Solution: two pointers
    sum = nums[i] + nums[start] + nums[end],
    loop i, each i MUST contains s&e !
    start = i + 1, end = len-1
    diff = (target - sum) and needs to update
    sum < target start++
    sum > target end--
    ending condition : start > end

* */
public class _16_ThreeSumII {


    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int diff = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int start = i + 1, end = nums.length - 1;
            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                if (Math.abs(target - sum) < Math.abs(diff)) {
                    diff = target - sum;
                }
                if(sum<target) start++;
                else end--;

            }

        }


        return target-diff;

    }
}
