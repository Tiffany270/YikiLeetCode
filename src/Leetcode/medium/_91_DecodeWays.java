package Leetcode.medium;

/*
* A message containing letters from A-Z can be encoded into numbers using the following mapping:
            'A' -> "1"
            'B' -> "2"
            ...
            'Z' -> "26"
                Example 1:
                Input: s = "12"
                Output: 2
                Explanation: "12" could be decoded as "AB" (1 2) or "L" (12).

                Example 2:
                Input: s = "226"
                Output: 3
                Explanation: "226" could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).

                Example 3:
                Input: s = "0"
                Output: 0
                Explanation: There is no character that is mapped to a number starting with 0.
                The only valid mappings with 0 are 'J' -> "10" and 'T' -> "20".
                Since there is no character, there are no valid ways to decode this since all digits need to be mapped.

                Example 4:
                Input: s = "06"
                Output: 0
                Explanation: "06" cannot be mapped to "F" because the zero at the beginning of the string can't make a valid character.
* */
public class _91_DecodeWays {

    /*
     * Solution dynamic programing
     *
     * */

    public int numDecodings(String s) {
        int n = s.length();
        if (n == 0) return 0;
        int[] dp = new int[n + 1]; // relate to i-2
        dp[0] = 1; // 不要直接得，倒推吧，顺着想想不通
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        // dp 的计算结果位肯定比s的长度多一位

        for (int i = 1; i < n; i++) {
            if (s.charAt(i - 1) == '1' || s.charAt(i - 1) == '2' && s.charAt(i) < '7') {
                // 10, 20
                if (s.charAt(i) == '0') {
                    dp[i + 1] = dp[i - 1];
                } else {
                    // 11~19 21~26
                    dp[i + 1] = dp[i] + dp[i - 1];
                }
            } else if (s.charAt(i) == '0') {
                // 0,30,40,50
                return 0;
            } else {
                //i-1和i无法构成一个字母 // 31 41 51 33 49 类似
                dp[i + 1] = dp[i];
            }

        }

        return dp[n];


    }

    public static void main(String[] args) {
        _91_DecodeWays func = new _91_DecodeWays();
        func.numDecodings("1234");
    }
}

