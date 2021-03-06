package Leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* NO.1
 * Given an array of integers,
 * return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution,
 * and you may not use the same element twice.
 * */
public class _01_TwoSum {

    /*
     * 遍历，找到target-num[i]=num[j]的元素
     * 时间复杂度n^2
     * */

    public  int[] twoSum1(int[] nums, int target) {
        int[] res = new int[2];

        for (int i = 0; i < nums.length; i++) {

            for (int j = i + 1; j < nums.length; j++) {
                if (target - nums[i] == nums[j]) {
                    res[0] = i;
                    res[1] = j;
                }
            }
        }


        return res;
    }

    /*思路2
     * HashMap
     * 循环把值+i放入map里
     * 只要找到target-i在map里，返回这个的i和target-i的索引
     *
     * Note: [1]Map is not allowed repeat key
     *          - HashMap: containing a hashcode for each key. only have one null value.
     *          - HashTable: same with above, but not allow have null value.
     *          - LinkedHashMap: sub of HashMap, containing a order of its insert
     *          - TreeMap: will sort the order of insert (default up)
     *
     *       [2]Set is not allowed repeat value
     * */
    public  int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> myMap = new HashMap<>();
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (myMap.containsKey(target - nums[i])) {
                res[0] = myMap.get(target - nums[i]);
                res[1] = i;
            }
            myMap.put(nums[i], i);
        }


        return res;
    }

    public static void main(String[] args) {
        _01_TwoSum twoSum = new _01_TwoSum();
        int[] arr = {2, 7, 11, 15};
        System.out.println(Arrays.toString(twoSum.twoSum(arr, 9)));
    }
}

