package CodingInterviews;

/*
*
一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。

* */
public class _10_2_Frog_Steps {

    /*Solution 1.递归 时间复杂度O(n^2) 浪费 2.递归结果用数组保存 浪费额外空间O(n)
    BEST:
    DP: dp[i+1] = dp[i]+dp[i-1],  dp[0]=0, dp[1] = 1 ,return dp[n]

    chart: i    [0 , 1, 2 , 3 , 4 , 5 ]
           dp    0   1  2   3   5   6

     NOTE：这种题目在于公式一致，只需要不同的初始值
     青蛙跳台阶问题：   f(0)=f(0)=1 , f(1)=1f(1)=1 , f(2)=2f(2)=2
     斐波那契数列问题： f(0)=f(0)=0 , f(1)=1f(1)=1 , f(2)=1f(2)=1


    */

    public int numWays(int n) {
        if (n == 0) return 1;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
            dp[i] = dp[i] % 1000000007;
        }
        return dp[n];
    }


}

