package Leetcode.easy;

public class _38_CountAndSay {


    /*
    *Given a positive integer n, return the nth term of the count-and-say sequence.
    * (给定一个正整数 n ，输出外观数列的第 n 项)

                1.     1
                2.     11
                3.     21
                4.     1211
                5.     111221
                第一项是数字 1
                描述前一项，这个数是 1 即 “ 一 个 1 ”，记作 "11"
                描述前一项，这个数是 11 即 “ 二 个 1 ” ，记作 "21"
                描述前一项，这个数是 21 即 “ 一 个 2 + 一 个 1 ” ，记作 "1211"
                描述前一项，这个数是 1211 即 “ 一 个 1 + 一 个 2 + 二 个 1 ” ，记作 "111221"

    * */

    // solution : double point
    //              count = end-start; use a cur to store res, every inner loop should init cur;
    //          when pre[start]!=pre[end], end ++;
    //
    public String countAndSay(int n) {
        StringBuffer pre = new StringBuffer("1");
        StringBuffer cur = new StringBuffer("1");

        for (int i = 1; i < n; i++) {
            pre = cur;
            cur = new StringBuffer();
            int start = 0;
            int end = 0;
            while (end < pre.length()) {
                System.out.println(pre.length());
                while (end < pre.length() && pre.charAt(start) == pre.charAt(end)) {
                    end++;// in order to avoid loop end early, make end++ enough
                }
                // start to join together
                cur = cur.append(Integer.toString(end - start)).append(pre.charAt(start));
                start = end;

            }
        }
        return cur.toString();
    }


    public static void main(String[] args) {
        _38_CountAndSay func = new _38_CountAndSay();
        func.countAndSay(6);
    }
}
