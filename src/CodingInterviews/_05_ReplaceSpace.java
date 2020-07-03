package CodingInterviews;

/*
* 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。

            示例 1：
            输入：s = "We are happy."
            输出："We%20are%20happy."

NOTE: string: 不可变，每次都是新对象
      StringBuffer 和 StringBuilder 类的对象能够被多次的修改，并且不产生新的未使用对象。
      StringBuilder 线程不安全，速度快
      StringBuffer 慢，线程安全

*/
public class _05_ReplaceSpace {

    public String replaceSpace(String s) {
        StringBuilder builder = new StringBuilder();

        for (Character c : s.toCharArray()) {
            if (c == ' ') {
                builder.append("%20");

            } else {
                builder.append(c);
            }
        }

        return builder.toString();
    }

}
