package Leetcode.easy;

/*
* Given a 32-bit signed integer, reverse digits of an integer.

            Example 1:
            Input: 123
            Output: 321

            Example 2:
            Input: -123
            Output: -321

            Example 3:
            Input: 120
            Output: 21
* */
public class _07_Reverse_Integer {

    public int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
            System.out.println(x + " " + pop + " " + rev);
        }
        return rev;
    }


    public static void main(String[] args) {


        int res = new _07_Reverse_Integer().reverse(-120);
        System.out.println(res);
    }
}
