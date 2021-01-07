package Leetcode.medium;


/*
* Given two integers dividend and divisor, divide two integers without using multiplication, division, and mod operator.

Return the quotient after dividing dividend by divisor.

The integer division should truncate toward zero, which means losing its fractional part. For example, truncate(8.345) = 8 and truncate(-2.7335) = -2.

Note:

Assume we are dealing with an environment that
could only store integers within the 32-bit signed integer range: [−231,  231 − 1].
 For this problem, assume that your function returns 231 − 1 when the division result overflows.
            Example 1:
            Input: dividend = 10, divisor = 3
            Output: 3
            Explanation: 10/3 = truncate(3.33333..) = 3.
            Example 2:
            Input: dividend = 7, divisor = -3
            Output: -2
            Explanation: 7/-3 = truncate(-2.33333..) = -2.
            Example 3:
            Input: dividend = 0, divisor = 1
            Output: 0
            Example 4:
            Input: dividend = 1, divisor = 1
            Output: 1
* */

public class _29_DivideTwoIntegers {

    public int divide(int dividend, int divisor) {

        int sign = 1;
        // use long to avoid integer overflow cases
        long lDividend = Math.abs((long) dividend);
        long lDivisor = Math.abs((long) divisor);
        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0))
            sign = -1;
        long lans = ldivide(lDividend, lDivisor);
        int ans;
        if (lans > Integer.MAX_VALUE) {
            ans = sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        } else {
            ans = (int) (sign * lans);
        }

        return ans;

    }

    private long ldivide(long ldividend, long ldivisor) {
        System.out.print(ldividend);

        if (ldividend < ldivisor) return 0;
        long sum = ldivisor;
        long multiple = 1;
        while ((sum + sum) < ldividend) {
            sum += sum;
            multiple += multiple;
        }

        System.out.println(multiple);
        return multiple + ldivide(ldividend - sum, ldivisor);
    }

    public static void main(String[] args) {
        _29_DivideTwoIntegers func = new _29_DivideTwoIntegers();
        func.divide(10, 3);
    }
}
