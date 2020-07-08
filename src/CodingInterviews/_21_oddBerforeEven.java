package CodingInterviews;

import java.util.Arrays;

/*
*输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
* 使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。


        示例：
        输入：nums = [1,2,3,4]
        输出：[1,3,2,4]
        注：[3,1,2,4] 也是正确的答案之一。

* */
public class _21_oddBerforeEven {
    /*
     * Solution:
     * （顺序遍历-太慢了别用这个）
     * 遍历+快慢指针
     * 快指针j往下走，碰到奇数就和i交换，i++,j++
     * j遇到偶数，i不变，j++
     * */

    public int[] exchange2(int[] nums) {


        int slow = 0;
        int fast = 1;
        while (slow < nums.length) {// 先筛选一遍slow，skip掉奇数
            if (nums[slow] % 2 != 0) {
                slow++;
                fast++;
            } else {
                break;
            }
        }
        while (slow < fast && fast < nums.length) {
            if (nums[fast] % 2 != 0) {
                int temp = nums[slow];
                nums[slow] = nums[fast];
                nums[fast] = temp;
                slow++;
                fast++;
            } else {
                fast++;
            }

        }
        return nums;

    }

    /*
     * （正式）
     * 应该用前后指针
     *
     * */

    public int[] exchange(int[] nums) {
        if (nums.length == 0) return nums;
        int i = 0, j = nums.length - 1;
        while (i < j) {
            while (nums[i] % 2 != 0 && i < j) {// 内部剔除
                i++;
            }
            while (nums[j] % 2 == 0 && i < j) {// 内部剔除
                j--;
            }
            if (nums[j] % 2 != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j--;
            } else {
                j--;
            }
        }
        return nums;
    }


    public static void main(String[] args) {
        _21_oddBerforeEven func = new _21_oddBerforeEven();
        int[] arr = {2, 16, 3, 5, 13, 1, 16, 1, 12, 18, 11, 8, 11, 11, 5, 1};
        System.out.println("res: " + Arrays.toString(func.exchange(arr)));
    }
}
