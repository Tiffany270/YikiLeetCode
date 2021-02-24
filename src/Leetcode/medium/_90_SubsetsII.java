package Leetcode.medium;

import java.util.*;

/*
*
        Given an integer array nums that may contain duplicates,
        return all possible subsets (the power set).
        The solution set must not contain duplicate subsets.
        Return the solution in any order.

            Example 1:
            Input: nums = [1,2,2]
            Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]

            Example 2:
            Input: nums = [0]
            Output: [[],[0]]
*
* */
public class _90_SubsetsII {

    List<List<Integer>> res = new ArrayList<>();
    Deque<Integer> path = new ArrayDeque<>();


    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        dfs(nums, 0);
        return res;
    }

    public void dfs(
            int[] nums,
            int startIndex
    ) {
        res.add(new ArrayList<>(path));
        for (int i = startIndex; i < nums.length; i++) {
            if (i > startIndex && nums[i] == nums[i - 1]) {
                continue;
            }
            path.addLast(nums[i]);
            dfs(nums, i + 1);
            path.removeLast();
        }

    }
}
