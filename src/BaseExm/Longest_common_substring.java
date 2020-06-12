package BaseExm;

/*
 * The longest common substring of the strings
 * "ABABCF" and "BABCAF"
 * is string "ABC" of length 3
 *
 *
 * PS: sub sequence : is NOT consecutive
 *     sub string: MUST consecutive
 *
 * Explanation：relevant to DP(Dynamic Programming)
 *   when A[i]=B[j], res = dp[i-1][j-1]+1
 *   matrix:
 *           b   c   d   a   f
 *       h   0   0   0   0   0
 *       b   1   0   0   0   0
 *       c   0   2   0   0   0
 *       d   0   0   3   0   0
 *       f   0   0   0   0   1
 *
 *   首先，为什么遇到一样变1，但是由于必须连续，当碰到不一样的，等于断了，所以为0而不递增
 *   对角线为累积的长度，代表连续，所以对角线为1，遇到相等后加上（上一个）对角线的数（非叠加）
 *
 *   PS. index Out of Bounds :pls start at i=1
 *   Note:
 *   star a loop and use i-1 later,
 *   u can start at i=1,
 *   then i<len+1,
 *   it still can complete this loop
 * */
public class Longest_common_substring {

    // return a length

    public int getLCS(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        int res = 0;
        int[][] dp = new int[len1 + 1][len2 + 1]; // already all are init into zero
        for (int i = 1; i < len1 + 1; i++) {
            for (int j = 1; j < len2 + 1; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    res = Math.max(res, dp[i][j]);
                }
            }
        }
        return res;
    }

    // return a string

    public String getLcs(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        int res = 0;
        String out = "";
        int[][] dp = new int[len1 + 1][len2 + 1]; // already all are init into zero
        for (int i = 1; i < len1 + 1; i++) {
            for (int j = 1; j < len2 + 1; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    if (dp[i][j] > res) {
                        out = s2.substring(j - dp[i][j], j);//dp[i][j] is the length of substring
                    }
                    res = Math.max(res, dp[i][j]);
                }
            }
        }
        return out;
    }

    public static void main(String[] args) {
        Longest_common_substring func = new Longest_common_substring();
        String s1 = "adgbcdt";
        String s2 = "atybcdd";
        int res = func.getLCS(s1, s2);
        String output = func.getLcs(s1, s2);
        System.out.println(res + output);
    }
}
