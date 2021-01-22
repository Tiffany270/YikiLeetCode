package Leetcode.medium;

/*
*
         Given an array nums with n objects colored red, white,
        or blue, sort them in-place so that objects of the same color are adjacent,
        with the colors in the order red, white, and blue.
        We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.

                Example 1:
                Input: nums = [2,0,2,1,1,0]
                Output: [0,0,1,1,2,2]

                Example 2:
                Input: nums = [2,0,1]
                Output: [0,1,2]

*/
public class _75_SortColors {

    /*
     * Solution 1
     * simple traverse twice, the once to move '0' to the first position,
     * twice make 2 to last position
     * */
    public void sortColors1(int[] nums) {
        int len = nums.length;
        int p = 0;
        for (int i = 0; i < len; ++i) {
            if (nums[i] == 0) {
                swap(nums, i, p);
                ++p;
            }

        }
        for (int i = p; i < len; ++i) {
            if (nums[i] == 1) {
                swap(nums, i, p);
                ++p;
            }

        }

    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /*
     * Solution 2
     * exchange num[i] and num[p0] or num[p1]
     * p0 -> num[i] = 0 , p0++,p1++
     * p1 -> num[i] = 1 , p1++
     * p0 and p1 all start at index = 0
     * minding that when num[i]=0,
     * would has two occasion = > so exchange both p0 and p1
     * 这到底是什么人才可以想出来啊 - -。
     * */
    public void sortColors2(int[] nums) {
        int n = nums.length;
        int p0 = 0;
        int p1 = 0;

        for (int i = 0; i < n; ++i) {
            if (nums[i] == 1) {
                swap(nums, i, p1);
                p1++;
            } else if (nums[i] == 0) {
                swap(nums, i, p0);
                if (p0 < p1) {
                    swap(nums, i, p1);
                }
                p0++;
                p1++;
            }
        }

    }
}
