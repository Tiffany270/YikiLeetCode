package Leetcode.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/*
* Given an array nums of distinct integers,
 * return all the possible permutations. You can return the answer in any order.
        Example 1:
        Input: nums = [1,2,3]
        Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
* */
public class _46_Permutations {

    /*
     * DFS 回溯 经典，不懂的时候记得看下视频
     * 回溯包括 return 以及下一层返回后把某个变量还原回去
     *
     * */

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        int len = nums.length;
        if (len == 0) {
            return res;
        }

        Deque<Integer> path = new ArrayDeque<>();
        boolean[] used = new boolean[len];//all false
        dfs(nums, len, 0, path, used, res);

        return res;

    }

    private void dfs(
            int[] nums,
            int len,
            int depth,
            Deque<Integer> path,
            boolean[] used, // 记录被用过的数字
            List<List<Integer>> res
    ) {
        if (depth == len) {
            res.add(new ArrayList<Integer>(path));
        }

        for (int i = 0; i < len; i++) {
            if (used[i]) {
                continue;
            }
            path.addLast(nums[i]);
            used[i] = true;
            dfs(nums, len, depth + 1, path, used, res);
            used[i] = false;
            path.removeLast();
        }

    }

}
