package Array.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * 39. Combination Sum
 * Given a set of candidate numbers (candidates) (without duplicates) and a target number (target),
 * find all unique combinations in candidates where the candidate numbers sums to target.
 * The same repeated number may be chosen from candidates unlimited number of times.
 * Note:
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.

 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，
 * 找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的数字可以无限制重复被选取。
 * 说明：
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 */

public class _39_CombinationSum {


    /*思路
     * 还是dfs+回溯
     * point
     * 1.为什么回溯结束要移除元素
     *  其实temp是唯一的，它只有一个，而包含它的解的是res，temp不移除怎么变化
     * 2.target >= candidates[i]是防止结果集的重复
     * 3.backtracking(...,i)而不是i+1是因为允许元素重复使用，即使已经排序了
     * 4.终极上一层回溯就会移除元素，进入上一层回溯得循环里，意会吧
     * 5.边界 肯定是target=0
     *
     *
     * */
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        backtracking(res, new ArrayList<Integer>(), candidates, target, 0);
        return res;
    }

    private static void backtracking(List<List<Integer>> res, List<Integer> temp, int candidates[], int target, int start) {
        if (target == 0) {
            res.add(new ArrayList<>(temp));
        }
        if (target > 0) {
            for (int i = start; i < candidates.length && target >= candidates[i]; i++) {
                temp.add(candidates[i]);
                backtracking(res, temp, candidates, target - candidates[i], i);
                temp.remove(temp.size() - 1);
            }
        }

    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 5};
        System.out.println(combinationSum(arr, 7));
    }
}
