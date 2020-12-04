package Leetcode.easy;

/*序号35
 *
 * Given a sorted array and a target value, return the index if the target is found. If not,
 * return the index where it would be if it were inserted in order.
 * You may assume no duplicates in the array.
 *
 * */
public class _35_SearchInsertPosition {

    //就是一个查找算法
    //二分查找

    public static int searchInsert(int[] nums, int target) {

        int i = 0, j = nums.length - 1;

        while (i <= j) {
            int mid = (i + j) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }

        return i;
    }

    public static void main(String[] args) {
        int[] arr = {2, 7, 11, 15};
        System.out.println(searchInsert(arr, 9));
    }
}
