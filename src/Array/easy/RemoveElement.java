package Array.easy;


/*
* 编号27
* Given an array nums and a value val, remove all instances of that value in-place and return the new length.
Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
The order of elements can be changed. It doesn't matter what you leave beyond the new length.
* */

public class RemoveElement {


    /*
     * 思路一
     * 往后遍历，把不等于val的值往前放
     * */
    public static int removeElement1(int[] nums, int val) {

        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[res++] = nums[i];
            }
        }


        return res;
    }

    /*思路二
     * 保留两个指针 i 和 j，其中 i 是慢指针，j 是快指针。
     * 当 nums[j]与给定的值相等时，递增 j以跳过该元素。只要 nums[j]！=val
     * i++和j++,并且让num[i]=num[j]（把j的元素往前放）
     * 长度就是i
     * */

    public static int removeElement2(int[] nums, int val) {

        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }

        }

        return i;
    }


    /*
     * 思路三
     * 依旧维持两个指针，一个从头i，一个从尾j，交换的位置是num[i]=val，把要移除的元素放到尾部
     *
     * */
    public static int removeElement(int[] nums, int val) {

        int i = 0;
        int j = nums.length;

        while (j>i) {
            if (nums[i] == val) {
                nums[i] = nums[j - 1];
                j--;
            } else {
                i++;
            }

        }


        return i;
    }


    public static void main(String[] args) {
        int[] arr = {3, 2, 2, 3};
        System.out.println(removeElement(arr, 2));
    }
}
