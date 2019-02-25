package Array.easy;

/*53最大子序和
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * Given an integer array nums,
 * find the contiguous subarray
 * (containing at least one number) which has the largest sum and return its sum.
 * */

import java.util.Map;

public class MaximumSubarray {


    /*思路1
     * O(n^3)
     * 滑窗遍历
     * */

    /*思路2
     * 滑窗plus
     * O(n^2)
     * 后面的滑窗不需要重新计算，而是当前元素+上一个滑窗的sum
     * */

    /*思路3
     * DP
     * max = Math.max(max, arr[i]+max)
     * 假定arr[i]这一点存在最大子序和
     * 形如           [ -2 , 1 , -3 , 4 ]
     * 在arr[i]的max:  -2    1   -2   4
     * 元素本身也是一个子序和，循环一次除了自身之外的子序和肯定要加上自身
     * temp:指在当前循环自身num[i]和nums[i]+之前最大子序和的对比
     * max不累述肯定是和temp比较
     * */

    public static int maxSubArray(int[] nums) {
        int max = nums[0];
        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            temp = Math.max(nums[i], nums[i] + temp);
            max = Math.max(temp, max);

        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(arr));
    }
}
