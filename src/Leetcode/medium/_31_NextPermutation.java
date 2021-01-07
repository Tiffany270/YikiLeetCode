package Leetcode.medium;

/*
* Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
If such an arrangement is not possible, it must rearrange it as the lowest possible order (i.e., sorted in ascending order).
The replacement must be in place and use only constant extra memory.

                Example 1:
                Input: nums = [1,2,3]
                Output: [1,3,2]
                ps:get all is 123,132,213,231,312,321 => 123<132<others, get 132

                Example 2:
                Input: nums = [3,2,1]
                Output: [1,2,3]
                ps:get all is 123,132,213,231 => 321 is the biggest, return the smallest -> 123

* */
public class _31_NextPermutation {


    /*
     * Solution of exmple 452631
     *   - use [i,i+1 ] and loop from right to left, find the first descending number =>2, so a[i] = 2
     *   - in [i ~ n ] , find the first num when a[i]<a[j] , a[j] = 3
     *   - swap(i,j) => 453621
     *   - rearrange the right of 3 => 126
     * */
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[i] >= nums[j]) {
                j--;
            }
            swap(nums, i, j);
        }
        //reverse
        int left = i + 1, right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }

    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}



