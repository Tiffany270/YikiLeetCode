package CodingInterviews;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;

/*
* 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。

    你可以假设数组是非空的，并且给定的数组总是存在多数元素。

            示例 1:
            输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
            输出: 2

* */
public class _39_MajorityElementOfArr {

    /*
     * Solution: - HashMap O(n)
     *           - sort then find 众数
     *           - Vote(best)
     * */


    //HashMap
    public int majorityElement1(int[] nums) {

        int len = nums.length / 2;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }

            if (map.get(nums[i]) > len) {
                return nums[i];
            }
        }

        return 0;
    }

    public int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    public int majorityElement(int[] nums) {
        int x = 0, vote = 0;
        for (int i = 0; i < nums.length; i++) {
            if (vote == 0) {
                x = nums[i];
            }
            if (x == nums[i]) {
                vote = vote + 1;
            } else {
                vote = vote - 1;
            }
        }

        return x;
    }
}
