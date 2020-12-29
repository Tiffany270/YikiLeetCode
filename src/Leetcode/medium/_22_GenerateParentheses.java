package Leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/*
* Given n pairs of parentheses,
* write a function to generate all combinations of well-formed parentheses.

            Example 1:
            Input: n = 3
            Output: ["((()))","(()())","(())()","()(())","()()()"]

            Example 2:
            Input: n = 1
            Output: ["()"]
* */
public class _22_GenerateParentheses {

    public static void main(String[] args) {
        _22_GenerateParentheses func = new _22_GenerateParentheses();
        List res = func.generateParenthesis(2);
        System.out.println(res.toString());
    }

    List<String> combinations = new ArrayList<String>();

    public List<String> generateParenthesis(int n) {
        recur(new char[2 * n], 0);
        return combinations;

    }

    public void recur(char[] current, int pos) {
        System.out.println(pos);
        System.out.println(current);
        if (pos == current.length) {
            if (valid(current)) {
                combinations.add(new String(current));
            }
        } else {
// 不懂啊啊啊啊啊啊
            current[pos] = '(';
            recur(current, pos + 1);
            current[pos] = ')';
            recur(current, pos + 1);
        }
    }

    // write down some examples u will understand
    public boolean valid(char[] current) {
        int balance = 0;
        for (char c : current) {
            if (c == '(') {
                ++balance;
            } else {
                --balance;
            }
            if (balance < 0) {
                return false;
            }

        }

        return balance == 0;
    }


}
