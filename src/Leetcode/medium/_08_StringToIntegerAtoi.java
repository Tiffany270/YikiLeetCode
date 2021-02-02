package Leetcode.medium;
/*
*
                        Example 1:
                        Input: "42"
                        Output: 42

                        Example 2:
                        Input: "   -42"
                        Output: -42
                        Explanation: The first non-whitespace character is '-', which is the minus sign.
                                     Then take as many numerical digits as possible, which gets 42.

                        Example 3:
                        Input: "4193 with words"
                        Output: 4193
                        Explanation: Conversion stops at digit '3' as the next character is not a numerical digit.

                        Example 4:
                        Input: "words and 987"
                        Output: 0
                        Explanation: The first non-whitespace character is 'w', which is not a numerical
                                     digit or a +/- sign. Therefore no valid conversion could be performed.

                        Example 5:
                        Input: "-91283472332"
                        Output: -2147483648
                        Explanation: The number "-91283472332" is out of the range of a 32-bit signed integer.
                                     Thefore INT_MIN (−231) is returned.
* */


/*
 * Solution : DFA (Deterministic Finite Automaton)
 *
 * API:
 * Character.isDigit(v)
 * str.charAt(i)// the string stored in char is 'ascii', so str.charAt(i) - '0'
 *
 * ABCD
 * num[i-1] * 10 + i = res
 *
 * */

public class _08_StringToIntegerAtoi {
    public int myAtoi(String str) {
        str = str.trim();// 去空格
        if (str == "") {
            return 0;
        }

        int i = 0;
        int flag = 1;
        int res = 0;
        if (i < str.length() && (str.charAt(i) == '+' || str.charAt(i) == '-'))
            flag = (str.charAt(i++) == '-') ? -1 : 1;


        while (i < str.length()
                && str.charAt(i) >= '0'
                && str.charAt(i) <= '9') {
            if (res > Integer.MAX_VALUE / 10
                    || (res == Integer.MAX_VALUE / 10
                    && str.charAt(i) - '0' > Integer.MAX_VALUE % 10)// 最后一个数字和max的最后一个数字比较溢出，max%10 = 7
            ) {
                return flag == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            res = res * 10 + (str.charAt(i++) - '0');
        }

        return res * flag;

    }

    public static void main(String[] args) {
        _08_StringToIntegerAtoi func = new _08_StringToIntegerAtoi();
        int res = func.myAtoi("");
        System.out.println("".length());
    }


}
