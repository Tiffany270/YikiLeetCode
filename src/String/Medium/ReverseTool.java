package String.Medium;
// 提供各种翻转字符串的方法
public class ReverseTool {
    public String reverse1(String str) {
        return new StringBuilder(str).reverse().toString();
    }
    // toCharArray
    public String reverse2(String str) {
        char[] chars = str.toCharArray();
        String reverse = "";
        for (int i = chars.length - 1; i >= 0; i--) {
            reverse += chars[i];
        }
        return reverse;
    }

    // charAt
    public String reverse3(String str) {
        String reverse = "";
        int length = str.length();
        for (int i = 0; i < length; i++) {
            reverse = str.charAt(i) + reverse;
        }
        return reverse;
    }
}
