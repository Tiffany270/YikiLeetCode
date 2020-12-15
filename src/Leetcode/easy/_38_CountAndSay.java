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
    public String countAndSay(int n) {

        return null;
    }

    String count(String str) {
        char[] list = str.toCharArray();
        int count = 1;
        String res = "";
        char prev = list[0];
        for (int i = 1; i < list.length; i++) {
            char ele = list[i];
            if (ele == prev) {
                count += 1;
            } else {
                count = 1;
            }

        }

        return "";
    }
}
