package Leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/*
*
* Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

    Symbol       Value
    I             1
    V             5
    X             10
    L             50
    C             100
    D             500
    M             1000

    Example 1:
        Input: s = "III"
        Output: 3

        s = IX = 9
        s = XII = 12

*/
public class _13_RomanToInt {

    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        char[] c = s.toCharArray();
        int res = 0;
        // store s prev num to ensure whether is + or -
        int prev = map.get(c[0]);
        for (int i = 1; i < c.length; i++) {
            if (map.containsKey(c[i])) {
                if (prev < map.get(c[i])) {
                    res -= prev;
                } else {
                    res += prev;
                }
                prev = map.get(c[i]);

            }
        }
        res += prev;//the last always +

        return res;
    }

    public static void main(String[] args) {
        String s = "LVIII";
        _13_RomanToInt func = new _13_RomanToInt();
        int res = func.romanToInt(s);
        System.out.println(res);
    }
}
