package CodingInterviews;

/*
* 请实现一个函数，输入一个整数，输出该数二进制表示中 1 的个数。
* 例如，把 9 表示成二进制是 1001，有 2 位是 1。
* 因此，如果输入 9，则该函数输出 2。

    示例 1：
    输入：00000000000000000000000000001011
    输出：3
    解释：输入的二进制串 00000000000000000000000000001011 中，共有三位为 '1'
*/
public class _15_OnesInBinary {

    /*
     * NOTE:
     * >> 右移 负数：左高位补1 正数：左高位补零 = X/2^n
     * << 左移 右边低位补零                  = X*2^n
     * >>> 无符号右移 高位只补零
     *
     * 补码 = 原码取反+1
     * 补码->原码 = 先-1再取反
     * */

    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            res += n & 1;
            n = n >>> 1;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(3 & 1);
    }
}