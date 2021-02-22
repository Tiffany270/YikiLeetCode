package Leetcode.medium;
/*
Given a string containing digits from 2-9 inclusive,
return all possible letter combinations that the number could represent.
Return the answer in any order.
A mapping of digit to letters (just like on the telephone buttons) is given below.
Note that 1 does not map to any letters.

             char[][]
             {
             {},{'a', 'b', 'c'}, {'d', 'e', 'f'},
             {'g', 'h', 'i'}, {'j', 'k', 'l'}, {'m', 'n', 'o'},
             {'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}

             }
                    Example 1:
                    Input: digits = "23"
                    Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]

                    Example 2:
                    Input: digits = ""
                    Output: []

                    Example 3:
                    Input: digits = "2"
                    Output: ["a","b","c"]
**/


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _17_LetterCombinationsofaPhoneNumber {


    /*
    * Note: 太麻烦了自己画个图吧
    * - "33222".substring(1) = "3222"
    * - output.len == input.len
    * */
    Map<String, String> phone = new HashMap<>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};
    List<String> res = new ArrayList<>();

    private void backtrack(String combination, String next_digit) {
        if (next_digit.length() == 0) {
            res.add(combination);

        } else {
            String digit = next_digit.substring(0, 1);
            String letters = phone.get(digit);
            for (int i = 0; i < letters.length(); i++) {
                String letter = letters.substring(i, i + 1);
                backtrack(combination+letter, next_digit.substring(1));
            }
        }


    }

    public List<String> letterCombinations(String digits) {
        if (digits.length() != 0) {
            backtrack("", digits);
        }

        return res;

    }

    public static void main(String[] args) {
        _17_LetterCombinationsofaPhoneNumber func = new _17_LetterCombinationsofaPhoneNumber();
        System.out.println(func.letterCombinations("234").toString());
    }
}
