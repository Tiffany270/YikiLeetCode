package String.Medium;
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
 * */

public class _08_String_To_Integer_Atoi {
    public int myAtoi(String str) {
        str = str.trim();// 去空格

        if (str.length() == 0) return 0;//长度为0
        if (!Character.isDigit(str.charAt(0))//第一个非+-并且非数字的字符串
                && str.charAt(0) != '-' && str.charAt(0) != '+')
            return 0;

        int res = 0;

        return res;
    }

    public static void main(String[] args) {
        _08_String_To_Integer_Atoi func = new _08_String_To_Integer_Atoi();
        int res = func.myAtoi("0000000000012345678");
        System.out.println(res);

    }
}
