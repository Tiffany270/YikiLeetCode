package CodingInterviews;

/*
* 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。

 

示例 1:

输入: [0,1,3]
输出: 2
示例 2:

输入: [0,1,2,3,4,5,6,7,9]
输出: 8

*/
public class _53_IIMissingNumber {

    //Note 有序一定要想到二分，不要遍历！！！！
    public int missingNumber(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;
        int mid = 0;
        while (lo <= hi) { // hi = lo 判断自身
            mid = (hi + lo) / 2 ;
            if (nums[mid] == mid) {
                lo = mid + 1;// 不要 lo = mid，避开死循环
            }else{
                hi = mid -1;
            }
        }

        return mid;
    }

    public static void main(String[] args) {
        int[] arr = {0, 2, 3, 4, 5};
        _53_IIMissingNumber func = new _53_IIMissingNumber();
        int res = func.missingNumber(arr);
        System.out.println(res);
    }
}
