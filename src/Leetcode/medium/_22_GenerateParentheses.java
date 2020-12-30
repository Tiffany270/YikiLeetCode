package Leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/*
* About recur
* f(3)
 =>3*f(2)
 =>3*f(2*f(1))
 =>3*f(2*1)
 =>3*2
 =>6

 f(n){
    1. find the end condition if(x) return T
    2. find some condition to reduce times of recur if(x==xx) return T;
    3. return equal f(x) to reduce scale return recur(f(n-1))
 }
* */

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
        List res = func.generateParenthesis(1);
        System.out.println(res.toString());
    }

    List<String> combinations = new ArrayList<String>();

    public List<String> generateParenthesis(int n) {
        recur(new char[2 * n], 0);
        return combinations;

    }

    public void recur(char[] current, int pos) {
        System.out.print(pos);
        System.out.print(' ');
        System.out.println(current);
        if (pos == current.length) {
            if (valid(current)) {
                combinations.add(new String(current));
            }
        } else {

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
