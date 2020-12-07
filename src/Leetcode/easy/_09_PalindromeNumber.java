package Leetcode.easy;

public class _09_PalindromeNumber {
    /*
    * Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.
Follow up: Could you solve it without converting the integer to a string?

            Example 1:
            Input: x = 121
            Output: true

            Example 2:
            Input: x = -121
            Output: false
            Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.

    * */

    // solution
    // revert half of the number
    public boolean isPalindrome(int x) {
        //negative num and the situation when the first place is 0 is FALSE
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int revertedNumber = 0;
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10; // each time divided by 10
        }
        // 123vs 12 ==> 123/10 == 12
        return x == revertedNumber || x == revertedNumber / 10;

    }
}
