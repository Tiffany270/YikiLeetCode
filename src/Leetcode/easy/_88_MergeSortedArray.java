package Leetcode.easy;

/*
 * 序号88 合并两个有序数组
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 * 说明:
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 * Note:
 * The number of elements initialized in nums1 and nums2 are m and n respectively.
 * You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
 * */

import java.util.Arrays;

public class _88_MergeSortedArray {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        /*
         * 思路
         * 两个指针i,j，以及合并的长度肯定是k=m+n
         * num[i]和num[j]比较，大的放到num[k--]里
         * 共两个while
         * 第二个while仅用于当num2还剩下元素的时候，就可以直接放进num[k--]里
         * */

        int i = m - 1,
                j = n - 1;//因为索引从0开始
        int k = n + m - 1;
        while (i > -1 && j > -1) {//不要忘记括号
            nums1[k--] = (nums1[i] > nums2[j]) ? nums1[i--] : nums2[j--];
        }
        while (j > -1) {
            nums1[k--] = nums2[j--];
        }


    }

    public static void main(String[] args) {
        int[]
                nums1 = {0},
                nums2 = {1};
        int
                m = 0, n = 1;

        merge(nums1, m, nums2, n);

        System.out.println(Arrays.toString(nums1));

    }
}
