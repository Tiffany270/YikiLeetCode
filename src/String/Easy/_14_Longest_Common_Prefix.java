package String.Easy;


/*
* Write a function to find the longest common prefix string amongst an array of strings.
    If there is no common prefix, return an empty string "".

    Example 1:
    Input: ["flower","flow","flight"]
    Output: "fl"

    Example 2:
    Input: ["dog","racecar","car"]
    Output: ""
    Explanation: There is no common prefix among the input strings.

    Note:
    All given inputs are in lowercase letters a-z.
*
* */
public class _14_Longest_Common_Prefix {


    /*Horizontal scanning
     *
     *
     * API:str.indexOf is return the FIRST index
     * ( so here must be !=0, meas prefix start at 0)
     *
     * Solution
     * i=0,str[i] as a prefix then compare to next str,i++
     *
     * leets leetcode leet leeds
     * [1] leets vs leetcode => leet
     * [2] leet vs leet => leet
     * [3] leet vs leeds => lee
     *
     * */

    public String longestCommonPrefix1(String[] strs) {
        if (strs.length == 0) return "";

        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        }

        return prefix;
    }

    /*
    * Solution 2
    * Vertical scanning
    *
    * leets leetcode leet leeds
    *
    * [1] l(leets) vs l(leetcode) vs l(j++)
    * [2] e(leets) vs e(j++) vs (j+++)
    * [3]...
    * [4]i=3 t(leets) vs ... d(leeds) =>dismiss =>i=3
    * [5] return str[0].substring(0,i)
    *
    * */
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        for(int i = 0;i<strs[0].length();i++){
            char c = strs[0].charAt(i);
            for (int j=0;j<strs.length;j++){
                if(i==strs[j].length()||strs[j].charAt(i)!=c){
                    return  strs[0].substring(0,i);
                }
            }
        }
        return strs[0];
    }

    public static void main(String[] args) {
        System.out.println("xxxleets".indexOf("leet"));
    }
}
