package Leetcode.medium;

import java.util.*;

public class _40_CombinationSumII {
    /*
    * Given a collection of candidate numbers (candidates) and a target number (target),
     find all unique combinations in candidates where the candidate numbers sum to target.
    Each number in candidates may only be used once in the combination.
    Note: The solution set must not contain duplicate combinations.

        Example 1:
        Input: candidates = [10,1,2,7,6,1,5], target = 8
        Output:
        [
        [1,1,6],
        [1,2,5],
        [1,7],
        [2,6]
        ]
    * */

    /*
     * Note: Deque : 双端队列
     * dfs + cut
     *
     *
     * */

    public List<List<Integer>> combinationSum2(
            int[] candidates,
            int target) {
        int len = candidates.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }
        Arrays.sort(candidates);

        Deque<Integer> path = new ArrayDeque<>(len);

        dfs(candidates, len, 0, target, path, res);
        return res;

    }

    private void dfs(
            int[] candidates,
            int len, // for redundant
            int begin,
            int target,// for  remaining
            Deque<Integer> path,
            List<List<Integer>> res
    ) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = begin; i < len; i++) {
            if (target - candidates[i] < 0) {
                break;
            }
            if (i > begin && candidates[i] == candidates[i - 1]) {
                continue;
            }
            path.addLast(candidates[i]);
            dfs(candidates,
                    len,
                    i + 1,
                    target - candidates[i],
                    path,
                    res);
            path.removeLast();
        }
    }
}
