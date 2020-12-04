package Leetcode.easy;

import java.util.Arrays;

/*
 * 66 加一
 *
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * 最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 * Given a non-empty array of digits representing a non-negative integer, plus one to the integer.
 * The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.
 * You may assume the integer does not contain any leading zero, except the number 0 itself.
 * */
public class _66_PlusOne {

    /*思路
     * 从后遍历，遇到 9 就变为 0,arr[i--]++
     * 如果存在溢出，初始化brr[arr.len+1],由于初始化都是0，首位为1即可
     * 注意输入[9],   输出是[1,0]
     *     [2,2,9]      [2,3,0]
     *     [9,9,9]     [1,0,0,0]
     *
     * 因为是plus 1，只有 9 才会进位，并且进位后留下的数只会是0
     * Java里初始化都为 0
     *
     *
     * */

    public static int[] plusOne(int[] digits) {

        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] == 9) {
                digits[i] = 0;
            } else {
                digits[i]++;
                return digits;
            }
        }

        if(digits[0]==0){
            int[] arr = new int[digits.length+1];
            arr[0]=1;
            return arr;
        }


        return digits;
    }

    public static void main(String[] args) {
        int[] arr = {9};
        System.out.println(Arrays.toString(plusOne(arr)));
    }
}
