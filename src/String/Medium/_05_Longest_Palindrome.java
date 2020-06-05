package String.Medium;

/*
    Given a string s,
    find the longest palindromic substring in s.
    You may assume that the maximum length of s is 1000.

    回文数指 ABA ABCDDCBA 484 483384

        Example 1:
        Input: "babad"
        Output: "bab"
        Note: "aba" is also a valid answer.

        Example 2:
        Input: "cbbd"
        Output: "bb"
* */

public class _05_Longest_Palindrome {

    /*
    * Approach 1: = Longest Common Consecutive Substring
    Reverse SS and become S'S . Find the longest common substring between SS and S'S,
    which must also be the longest palindromic substring

    *(Here is other pretty complex problem:
     How to find common substring :)

     but : I still
    * */



    /* Approach 2: Brute Force
     *  API：String.substring(int beginIndex, int endIndex)
     * */
    public String longestPalindrome(String s) {
        ReverseTool reverseTool = new ReverseTool();
        String s2 = reverseTool.reverse1(s);



        return null;

    }


    public static void main(String[] args) {

        _05_Longest_Palindrome func = new _05_Longest_Palindrome();
        String test = "abac";
        String res = func.longestPalindrome(test);
    }
}
