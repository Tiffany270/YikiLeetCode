package CodingInterviews;

/*
* 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项。斐波那契数列的定义如下：

    F(0) = 0,   F(1) = 1
    F(N) = F(N - 1) + F(N - 2), 其中 N > 1.

    斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
    答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。

* */
public class _10_1_Fibonacci {

    /*Solution 1.递归 时间复杂度O(n^2) 浪费 2.递归结果用数组保存 浪费额外空间O(n)
    BEST:
    DP: dp[i+1] = dp[i]+dp[i-1],  dp[0]=0, dp[1] = 1 ,return dp[n]

    chart: i    [0 , 1, 2 , 3 , 4 , 5 ]
           dp    0   1  1   2   3   5

     NOTE：这种题目在于公式一致，只需要不同的初始值
     青蛙跳台阶问题： f(0)=1f(0)=1 , f(1)=1f(1)=1 , f(2)=2f(2)=2
     斐波那契数列问题： f(0)=0f(0)=0 , f(1)=1f(1)=1 , f(2)=1f(2)=1


    */

    public int fib(int n) {
        if (n == 0) return 0;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
            dp[i] = dp[i] % 1000000007;
        }
        return dp[n];
    }


}

