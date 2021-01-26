package Leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/*
* The gray code is a binary numeral system where two successive values differ in only one bit.
Given an integer n representing the total number of bits in the code, return any sequence of gray code.
A gray code sequence must begin with 0.

                        Example 1:
                        Input: n = 2
                        Output: [0,1,3,2]
                        Explanation:
                        00 - 0
                        01 - 1
                        11 - 3
                        10 - 2
                        [0,2,3,1] is also a valid gray code sequence.
                        00 - 0
                        10 - 2
                        11 - 3
                        01 - 1

                        Example 2:
                        Input: n = 1
                        Output: [0,1]
*
* 解释 n = 0 [0] 2^0
*     n = 1 [0,1] 2^1
*     n = 2 [0,1,3,2] 2^2
*     n = 3 [0,     1,      3,   2,     6, 7, 5, 1, 9, 4]
 *          000,    010,   011, 001 ...
*
*
*   其他
*   格雷码 以二进制为 0 值的格雷码为第零项，
*   第一项改变最右边的位元，第二项改变右起第一个为1的位元的左边位元，
*   第三、四项方法同第一、二项，如此反复，即可排列出n个位元的格雷码。
        以 n = 3 为例。
        0 0 0 第零项初始化为 0。
 case1  0 0 1 第一项改变上一项最右边的位元
 case2  0 1 1 第二项改变上一项右起第一个为 1 的位元的左边位
 case1  0 1 0 第三项同第一项，改变上一项最右边的位元
 case2  1 1 0 第四项同第二项，改变最上一项右起第一个为 1 的位元的左边位
        1 1 1 第五项同第一项，改变上一项最右边的位元
        1 0 1 第六项同第二项，改变最上一项右起第一个为 1 的位元的左边位
        1 0 0 第七项同第一项，改变上一项最右边的位元
* */
public class _89_GrayCode {
    public List<Integer> grayCode(int n) {
        List<Integer> gray = new ArrayList<>();
        gray.add(0);
        for (int i = 1; i < 1 << n; i++) {
            int prev = gray.get(i - 1);
            if (i % 2 == 1) { // case 1
                prev ^= 1; //^异或 同0 不同1
                gray.add(prev);
            } else {
                int temp = prev;
                for (int j = 0; j < n; j++) {
                    // 1 = 0000 1000 00
                    if ((temp & 1) == 1) {
                        prev = prev ^ (1 << (j + 1));
                        gray.add(prev);
                        break;
                    }
                    temp = temp >> 1;

                }
            }
        }
        return gray;
    }

    public static void main(String[] args) {
        _89_GrayCode func = new _89_GrayCode();
        System.out.println(
                func.grayCode(3).toString()

        );
        System.out.println(1<<1);
        System.out.println(1<<2);
        System.out.println(1<<3);

    }
}
