package Leetcode.medium;

public class _55_JumpGame {
    /*
    *   Given an array of non-negative integers nums, you are initially positioned at the first index of the array.
        Each element in the array represents your maximum jump length at that position.
        Determine if you are able to reach the last index.
        maximum: 说的是当前索引位置表示你可以跳的最大的步数
        如3，你可以跳1，2，3

        if num[index] is large number even larger then your length of nums,
        then u can directly reach the last index => true


        Example 1:
        Input: nums = [2,3,1,1,4]
        Output: true
        Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.

        Example 2:
        Input: nums = [3,2,1,0,4]
        Output: false
        Explanation: You will always arrive at index 3 no matter what.
        Its maximum jump length is 0, which makes it impossible to reach the last index.
    *
    * */

    public boolean canJump(int[] nums) {

        return canJumpFromPosition(0, nums);

    }

    /*
     * Solution :
     * 遍历，找到当前下表 可以到达的最远的距离
     * maxStep = max(num[index],prevMax)
     * farthest position (is a index) = step + current index
     * if far_position =  last index = > true
     *
     * */

    public boolean canJumpFromLoop(int[] nums) {
        int n = nums.length;
        int rightmost = 0;
        for (int i = 0; i < n; ++i) {
            if (i <= rightmost) {
                rightmost = Math.max(rightmost, i + nums[i]);
                if (rightmost >= n - 1) {
                    return true;
                }
            }
        }
        return false;
    }

    // change above to backtracking (算了算了，一直超时……）
    public boolean canJumpFromPosition(int position, int[] nums) {
        if (position == nums.length - 1) {
            return true;
        }
        int step =
                Math.min(position + nums[position], nums.length - 1);
        for (int nextPosition = step; nextPosition > position; nextPosition--) {
            if (canJumpFromPosition(nextPosition, nums)) {
                return true;
            }
        }


        return false;
    }



    public static void main(String[] args) {
        int[] arr = {2, 5, 0, 0};
        _55_JumpGame func = new _55_JumpGame();
        System.out.println(func.canJump(arr));
    }
}
