package Leetcode.easy;

/*
You are a professional robber planning to rob houses along a street.
Each house has a certain amount of money stashed,
the only constraint stopping you from robbing each of them is that
adjacent houses have security system connected and it will automatically contact the police
if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house,
determine the maximum amount of money you can rob tonight without alerting the police.

        Example 1:
        Input: nums = [1,2,3,1]
        Output: 4
        Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
                     Total amount you can rob = 1 + 3 = 4.

        Example 2:
        Input: nums = [2,7,9,3,1]
        Output: 12
        Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
                     Total amount you can rob = 2 + 9 + 1 = 12.

* */
public class _198_HouseRobber {
    /*
     * Solution : DP
     *
     *       Hi     0 1 2 3
     *       Vh     1 2 3 1
     *
     *       S0 = H0 = 1
     *       S1 = max(S0,H1) = 2
     *       S2 = max(S1,S0+H2) = 4
     *       S3 = max(S2,S1+H3)
     *
     *    so
     *       dp[0] = num[0]
     *       dp[1] = max(num[0],num[1])
     *       dp[i] = max(dp[i-1],dp[i-2]+num[i])
     * */
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        if (len == 1) {
            return nums[0];
        }
        int[] dp = new int[len];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < len; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }


        return dp[len - 1];
    }
}
