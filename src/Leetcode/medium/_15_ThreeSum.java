package Leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
* Given an array nums of n integers,
* are there elements a, b, c in nums such that a + b + c = 0?
* Find all unique triplets in the array which gives the sum of zero.

    Note:
    The solution set must not contain duplicate triplets.

            Example:
            Given array nums = [-1, 0, 1, 2, -1, -4],

            A solution set is:
            [
              [-1, 0, 1],
              [-1, -1, 2]
            ]


*/

/*
* Solution :
*
*
    首先对数组进行排序，排序后固定一个数 nums[i]nums[i]，
    再使用左右指针指向 nums[i]nums[i]后面的两端，数字分别为 nums[L]nums[L] 和 nums[R]nums[R]，
    - 计算三个数的和 sumsum 判断是否满足为 00，满足则添加进结果集
    - 如果 nums[i]nums[i]大于 00，则三数之和必然无法等于 00，结束循环
    - 如果 nums[i]nums[i] == nums[i-1]nums[i−1]，则说明该数字重复，会导致结果重复，所以应该跳过
    - 当 sumsum == 00 时，nums[L]nums[L] == nums[L+1]nums[L+1] 则会导致结果重复，应该跳过，L++L++
    - 当 sumsum == 00 时，nums[R]nums[R] == nums[R-1]nums[R−1] 则会导致结果重复，应该跳过，R--R−−
    时间复杂度：O(n^2) n 为数组长度

*
* API:Arrays.asList : turn array into List
* */

public class _15_ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        if (len < 3) return res;
        Arrays.sort(nums);

        for (int i = 0; i < len; i++) {
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int L = i + 1;
            int R = len - 1;
            System.out.println(R);
            while (L < R) {
                int sum = nums[i] + nums[L] + nums[R];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i],nums[L],nums[R]));

                    while (L<R && nums[L] == nums[L+1])
                        L++; // 去重
                    while (L<R && nums[R] == nums[R-1])
                        R--; // 去重

                    L++;
                    R--;
                }
                else if (sum < 0) L++;
                else if (sum > 0) R--;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        _15_ThreeSum func = new _15_ThreeSum();
        int[] arr = {-1, 0, 1, 2, -1, -4};
        func.threeSum(arr);
    }
}
