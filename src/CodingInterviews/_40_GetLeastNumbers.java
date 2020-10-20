package CodingInterviews;

import java.util.Arrays;

/**
 * 输入整数数组 arr ，找出其中最小的 k 个数。
 * 例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 * <p>
 * 示例 1：
 * 输入：arr = [3,2,1], k = 2
 * 输出：[1,2] 或者 [2,1]
 */
// sort it pls
public class _40_GetLeastNumbers {
    public int[] getLeastNumbers(int[] arr, int k) {

        Arrays.sort(arr);
        int[] res = new int[k];
        for (int index = 0; index < k; index++) {
            res[index] = arr[index];
        }


        return res;
    }
}
