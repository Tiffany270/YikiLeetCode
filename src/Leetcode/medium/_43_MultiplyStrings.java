package Leetcode.medium;

/*
*
* Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2,
* also represented as a string.
Note: You must not use any built-in BigInteger library or convert the inputs to integer directly.
            Example 1:
            Input: num1 = "2", num2 = "3"
            Output: "6"
            Example 2:
            Input: num1 = "123", num2 = "456"
            Output: "56088"
* */
public class _43_MultiplyStrings {

    /*Note:
     * API : char: x - '0' = its real number
     * */

    /*
     * Solution 1 竖式乘法 结果相加
     * solution 2 使用数组代替字符串存储结果，则可以减少对字符串的操作...不想写了
     * */
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";

        String res = "0";
        int m = num1.length(), n = num2.length();
        for (int i = n - 1; i >= 0; i--) {
            StringBuffer cur = new StringBuffer();
            int add = 0;
            for (int j = n - 1; j > i; j--) {
                cur.append(0);
            }
            int y = num2.charAt(i) - '0';
            for (int j = m - 1; j >= 0; j--) {
                int x = num1.charAt(j) - '0';
                int product = x * y + add;
                cur.append(product % 10);
                add = product / 10;
            }
            if (add != 0) {
                cur.append(add % 10);//最后一次进位>0
            }
            res = addStrings(res, cur.reverse().toString());
        }

        return res;
    }

    private String addStrings(String num1, String num2) {
        StringBuffer res = new StringBuffer();
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int add = 0;
        while (i >= 0 || j >= 0 || add != 0) {
            int x = i >= 0 ? num1.charAt(i) - '0' : 0;// 补零
            int y = j >= 0 ? num2.charAt(j) - '0' : 0;
            int temp = x + y + add;
            res.append(temp % 10);
            add = temp / 10;
            j--;
            i--;//变负数也没关系

        }
        res.reverse();
        return res.toString();

    }
}
