package Leetcode.easy;

/* 121. 买卖股票的最佳时机
* 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
注意你不能在买入股票前卖出股票。
示例 1:
输入: [7,1,5,3,6,4]
输出: 5
解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
     注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。

Best Time to Buy and Sell Stock
Say you have an array for which the ith element is the price of a given stock on day i.
If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.
Note that you cannot sell a stock before you buy one.
Example 1:

Input: [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
             Not 7-1 = 6, as selling price needs to be larger than buying price.
Example 2:

Input: [7,6,4,3,1]
Output: 0
Explanation: In this case, no transaction is done, i.e. max profit = 0.
     */
public class _121_BestTimetoBuyandSellStock {


    /*思路一
    暴力遍历：
    外层for一个元素
    内层for 后面的元素依次和外层的那个对比，维持一个max，找到最大的那个
    时间复杂度O(n^2)
    非常慢……
    * */

    public static int LoopMaxProfit(int[] prices) {

        int max = 0;
        int profit;
        for (int i = 0; i < prices.length; i++) {
            int current = prices[i];
            for (int j = i + 1; j < prices.length; j++) {
                if (current < prices[j]) {
                    profit = prices[j] - current;
                    max = max > profit ? max : profit;
                }
            }
        }


        return max;
    }


    /*
     * 思路二
     * 维持峰值
     * 找到最小的元素，之后的元素只要比这个最小大就会产生max
     * 由于买入的是不能小于卖出的，所以就算min出现在后面，它就会推翻前面的min，但是max是保存的
     * 时间复杂度：O(n)
     * */
    public static int LoopPlusMaxProfit(int[] prices) {

        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else if (prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice;
            }
        }


        return maxProfit;
    }

    /*思路三
     * Dynamic programming/动态规划/DP
     * 计算maxCur += prices[i] - prices[i-1]原始数组的差异，
     * 并找到一个连续的子数组，以获得最大的利润。如果这个连续相加的差值低于0，则将其重置为零。
     *  下面的解释需要注意的是，想买入的数是不允许高于卖出的数的，所以公式成立。【这点我也不是很明白为什么……
     * *maxCur = current maximum value
     * *maxSoFar = maximum value found so far
     * A more clear explanation on why sum of subarray works.:
     * Suppose we have original array:
           [a0, a1, a2, a3, a4, a5, a6]
           what we are given here(or we calculate ourselves) is:
           [b0, b1, b2, b3, b4, b5, b6]
           where,
           b[i] = 0, when i == 0
           b[i] = a[i] - a[i - 1], when i != 0
       suppose if a2 and a6 are the points that give us the max difference (a2 < a6)
       then in our given array, we need to find the sum of sub array from b3 to b6.
        b3 = a3 - a2
        b4 = a4 - a3
        b5 = a5 - a4
        b6 = a6 - a5
        adding all these, all the middle terms will cancel out except two
        i.e.
        b3 + b4 + b5 + b6 = a6 - a2
        a6 - a2 is the required solution.
        so we need to find the largest sub array sum to get the most profit
     * */


    public static int DPMaxProfit(int[] prices) {

        int maxCur = 0;
        int maxSoFar = 0;
        for (int i = 1; i < prices.length; i++) {
            maxCur = Math.max(0, maxCur += prices[i] - prices[i - 1]);
            maxSoFar = Math.max(maxCur, maxSoFar);
        }


        return maxSoFar;
    }

    public static void main(String[] args) {
        int[] arr = {7, 2, 5, 3, 6};
        System.out.println(DPMaxProfit(arr));
    }


}
