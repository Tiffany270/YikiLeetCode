package Leetcode.easy;

/*
序号169
* 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
你可以假设数组是非空的，并且给定的数组总是存在众数。
Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
You may assume that the array is non-empty and the majority element always exist in the array.
*
* */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*思路
 *众数=出现次数最多的数
 * 解法一：摩尔投票法
 * 每次从序列里选择两个不相同的数字删除掉（或称为“抵消”），最后剩下一个数字或几个相同的数字，就是出现次数大于总数一半的那个
 * 时间复杂度：O(n)
 * 这里给个示例： https://www.cs.utexas.edu/~moore/best-ideas/mjrty/example.html
 * point:
 * 1. 在任何数组中，出现次数大于该数组长度一半的值只能有一个(试想怎么可能有两个……)
 * 2. 题目也确保了一定存在众数，也就说众数的个数肯定是大于n/2,是大于而不是等于，所以类似[2,2,1,1,1,1,3,3]中1是不算的
 *
 *
 * 解法二：Hashtable
 * 存键值对+公式
 *
 * 解法三：API（不推荐）
 * */
public class _169_MajorityElement {

    public static int majorityElement(int[] nums) {

        int major = nums[0];//这里意味着循环第一轮的if是永远不会进入了
        int count = 1;

        for (int index = 0; index < nums.length; index++) {
            if (major != nums[index]) {
                count--;
                if (count == 0) {
                    major = nums[index];
                    count = 1;
                }

            } else {
                count++;
            }

        }

        return major;
    }

    public static int HashTableElement(int[] nums) {
        Map<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        int res = nums[0];
        for (int num : nums) {
            if (!hashMap.containsKey(num)) {
                hashMap.put(num, 1);
            } else {
                hashMap.put(num, hashMap.get(num) + 1);
            }

            if (hashMap.get(num) > nums.length / 2) {
                res = num;
                break;
            }
        }

        return res;
    }

    public static void main(String[] args) {

        int[] nums1 = {2, 2, 1, 1, 1, 2, 2};
        int[] nums2 = {6, 5, 5};
        int[] nums3 = {3, 2, 3};
        int[] nums4 = {10, 9, 9, 9, 10};


        System.out.println(HashTableElement(nums1));
        System.out.println(HashTableElement(nums2));
        System.out.println(HashTableElement(nums3));
        System.out.println(HashTableElement(nums4));

    }

    public static int ApiMaJorElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

}

