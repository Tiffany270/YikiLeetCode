package Leetcode.easy;
/*
* Given two binary strings a and b, return their sum as a binary string.

            * Example 1:
            Input: a = "11", b = "1"
            Output: "100"

            Example 2:
            Input: a = "1010", b = "1011"
            Output: "10101"
* */


/*
        NOTE:
    Language defects of Java:
    if a String more than 33 bites , cannot covert into Integer
    if a String more than 65 bites , cannot covert into Long
    if a String more than 500000001 , cannot covert into BigInteger

    small number of calculation: covert into decimal, than covert back to binary
                                API : Integer.parse(num, k), k = 2 or 10




* */
public class _67_AddBinary {

    /*
    * solution:

    loop for n = max(a.len , b.len),  use 'carry' to store its carry
    sum = ( a + b + carry ) % 2
    ans = ans.reverse() // because we use append

    API : char - '0' = its Int
          StringBuffer() // use to append

    * */

    public String addBinary(String a, String b) {

        StringBuffer res = new StringBuffer();
        int i = a.length() - 1;
        int j = b.length() - 1; // from right to left , use while
        int carry = 0;
        while (i >= 0 && j >= 0) {
            int sum = carry;
            sum += a.charAt(i--) - '0';
            sum += b.charAt(j--) - '0';
            carry = sum / 2; // store carry
            res.append(sum % 2);
        }
        // if a or b are not ending the loop
        while (i >= 0) {
            int sum = carry + a.charAt(i--) - '0';
            carry = sum / 2;
            res.append(sum % 2);
        }
        while (j >= 0) {
            int sum = carry + b.charAt(j--) - '0';
            carry = sum / 2;
            res.append(sum % 2);
        }

        if(carry==1){
            res.append(carry);
        }


        return res.reverse().toString();

    }


}
