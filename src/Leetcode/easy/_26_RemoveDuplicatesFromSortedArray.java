package Leetcode.easy;
/*
 * 26
 * Given a sorted array nums,
 * remove the duplicates in-place such that each element appear only once and return the new length.
 * Do not allocate extra space for another array,
 * you must do this by modifying the input array in-place with O(1) extra memory.
 *
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * */

public class _26_RemoveDuplicatesFromSortedArray {


    /*
    * 思路
    * 双指针
    * 一个慢一个快
    * 遇到前后两个相等的时候就快就跳，遇到不同的就慢++后把慢指针+1后的地方替换快指针指向的元素
    * */
    public static int removeDuplicates(int[] nums) {
        int i = 0, j;
        for (j = i + 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                nums[++i] = nums[j];
            }
        }
        return i+1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 2};
        System.out.println(removeDuplicates(arr));
    }
}
