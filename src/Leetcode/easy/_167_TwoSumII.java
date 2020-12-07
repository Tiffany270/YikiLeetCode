package Leetcode.easy;
/*序号167-输入有序数组
给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
说明:
返回的下标值（index1 和 index2）不是从零开始的。
你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.
The function 01twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.
Note:
Your returned answers (both index1 and index2) are not zero-based.
You may assume that each input would have exactly one solution and you may not use the same element twice.
* */

import java.util.Arrays;

public class _167_TwoSumII {

    /*思路：双指针
     * 一个从头，一个从尾
     * 头+尾和target对比
     * 和target比大小决定是左指针往右移还是右指针往左移
     * */

    public static int[] twoSum(int[] numbers, int target) {

        int left = 0, right = numbers.length - 1;
        int[] res = new int[2];
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                res[0] = left + 1;
                res[1] = right + 1;
                break;
            } else if (sum > target) {
                right--;
            } else {
                left++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {2, 7, 11, 15};
        System.out.println(Arrays.toString(twoSum(arr, 9)));
    }
}
