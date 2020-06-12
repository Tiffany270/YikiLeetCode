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

     Note ；To rectify this, each time we find a longest common substring candidate,
     we check if the substring’s indices are the SAME as the reversed substring’s original indices.

     but : I still can understand
    * */

    public String longestPalindrome1(String s1) {
        ReverseTool reverseTool = new ReverseTool();
        String s2 = reverseTool.reverse1(s1);

        String out = "";

//        int len1 = s1.length();
//        int len2 = s2.length();
//        int res = 0;
//        int maxEnd = 0;
//        int[][] dp = new int[len1 + 1][len2 + 1]; // already all are init into zero
//        for (int i = 1; i < len1 + 1; i++) {
//            for (int j = 1; j < len2 + 1; j++) {
//                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
//                    dp[i][j] = dp[i - 1][j - 1] + 1;
//                    if (dp[i][j] > res) {
//                        maxEnd = i;
//                        out = s2.substring(j - dp[i][j], j);
//                    }
//                    res = Math.max(res, dp[i][j]);
//                }
//            }
//        }
        return out;

    }


    /*Approach 3 DP
    *   dp[i][i]=1 (when i = j)
        if dp[i][j] = 1  then dp[i+1][j-1] = 1
        if dp[i][j] = 0  then dp[i+1][j-1] = 0
    *
    * NOTE：s.substring (start,end) end NOT include endIndex itself, we have to add 1
    * */
    public String longestPalindrome(String s) {

        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        String maxPal = "";

        for (int l = 1; l <= len; l++) {// Traverse each length
            for (int i = 0; i < len; i++) { // if u don't understand, u can drew a i-j matrix,diagonal line means length
                int j = i + l - 1;
                if (j >= len) break;
                dp[i][j] = (l == 1 || l == 2 || dp[i + 1][j - 1]) && s.charAt(i) == s.charAt(j);
                if (dp[i][j]) maxPal = s.substring(i, j + 1);
            }
        }


        return maxPal;

    }


    public static void main(String[] args) {

        _05_Longest_Palindrome func = new _05_Longest_Palindrome();
        String test = "cbbabbc";
        String res = func.longestPalindrome(test);

    }
}
