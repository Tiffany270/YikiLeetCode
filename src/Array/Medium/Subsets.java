package Array.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*78 子集
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * 说明：解集不能包含重复的子集。
 * Given a set of distinct integers, nums, return all possible subsets (the power set).
 * Note: The solution set must not contain duplicate subsets.
 * */
public class Subsets {


    /*思路1
     * Backtracking+dfs
     * 回溯+深度优先搜索
     * 如果要理解，看到一个解释，也可以当作：存在和不存在。
     * 外层循环逐一往中间集合 temp 中加入元素 nums[i]，使这个元素处于存在状态
     * 开始递归，递归中携带加入新元素的 temp，并且下一次循环的起始是 i 元素的下一个，因而递归中更新 i 值为 i + 1
     * 将这个从中间集合 temp 中移除，使该元素处于不存在状态
     * */

    public static List<List<Integer>> subsets1(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        dfs(res, temp, nums, 0);
        return res;
    }

    /* * 再具体点
     * 形如[1,2,3]得到
     * [[], [1], [1, 2], [1, 2, 3], [1, 3], [2], [2, 3], [3]]
     * 假设某一步 temp=》 tempList.add(nums[i])=>[1]
     * 在进行dfs的时候是[1]add下一层=》[1,2]=>再下一层dfs->[1,2,3]，结束后往上回溯remove 3 =>[1,2]
     * 继续回溯会变为remove 2 =>[1] 最外层remove 1 =》[]
     * 最最外层循环结束，i++,从num[1]=2开始=temp=>[2]
     * */
    private static void dfs(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start) {
        list.add(new ArrayList<>(tempList));
        for (int i = start; i < nums.length; i++) {
            tempList.add(nums[i]);
            dfs(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }

    /*思路3
     * 选和不选+二进制
     * [ 1 , 2 , 3 ]
     *   f   f   f   []
     *   t   f   f   [1]
     *   t   t   f   [1,2]
     *   ...类推
     * */

    /*思路2
     * 遍历
     * 出现新的，就把新的添加到上一层子集的后面
     * 详解
     * res的size是递增的
     * 外层遍历每个nums的元素
     * 内层遍历res的元素，被外层当前元素add进temp再add进res即可
     * */
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        for (int num : nums) {  // ①从数组中取出每个元素
            int size = res.size();
            for (int i = 0; i < size; i++) {
                List<Integer> temp = new ArrayList<>(res.get(i));  // ②逐一取出中间结果集
                System.out.println(res.get(i));
                temp.add(num);  // ③将 num 放入中间结果集
                res.add(temp);  // ④加入到结果集中
            }
        }
        return res;
    }


    public static void main(String[] args) {
        int[] num = {1, 2, 3};
        System.out.println(subsets(num));

    }
}
