package Leetcode.hard;

/*
*
* Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
(i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).
Find the minimum element.
The array may contain duplicates.

            Example 1:
            Input: [1,3,5]
            Output: 1

            Example 2:
            Input: [2,2,2,0,1]
            Output: 0

* */
public class _154_FindMinimum_in_RotatedSortedArrayII {

    /*理解：就递增数组结束后的第一个元素呗
     * Note :排序数组的查找问题首先考虑使用 二分法 解决
     *
     * 二分
     * i 头部指针， j 尾部指针， m 中间值
     * m和j比，因为递增，不要和i比
     * 用m判断左右即可
     * */


    public int findMin(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int m = (i + j) / 2;
            if (nums[m] > nums[j]) {
                i = m + 1;
            } else if (nums[m] < nums[j]) {
                j = m;
            } else {
                j--;
            }
        }

        return nums[i];
    }

}
