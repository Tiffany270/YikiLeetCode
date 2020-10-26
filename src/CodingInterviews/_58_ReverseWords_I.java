package CodingInterviews;

/*
LeetCode151

* 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。例如输入字符串"I am a student. "，则输出"student. a am I"。

示例 1：

输入: "the sky is blue"
输出: "blue is sky the"

* */
public class _58_ReverseWords_I {

    /*
     * NOTE: 双指针边界，i,j,遇到空格双指针重置，空格遍历时skip，res自己加即可
     * i 每个循环中设置内循环在找到第一个空格
     * */
    public String reverseWords(String s) {

        s = s.trim();
        int i = s.length() - 1;
        int j = i;
        StringBuilder res = new StringBuilder();
        while (i >= 0) {
            while (i >= 0 && s.charAt(i) != ' ') {
                i--;
            }
            res.append(s.substring(i + 1, j + 1)+" ");
            while (i >= 0 && s.charAt(i) == ' ') {
                i--;
            }
            j = i;
        }


        return res.toString().trim();
    }
}
