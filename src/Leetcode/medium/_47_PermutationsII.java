package Leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
*
* Given a collection of numbers, nums, that might contain duplicates,
* return all possible unique permutations in any order.

                Example 1:
                Input: nums = [1,1,2]
                Output:
                [[1,1,2],
                 [1,2,1],
                 [2,1,1]]
                Example 2:
                Input: nums = [1,2,3]
                Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
* */
public class _47_PermutationsII {
    boolean[] used;

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> perm = new ArrayList<>();
        Arrays.sort(nums);
        used = new boolean[nums.length];
        backtrack(nums, res, 0, perm);

        return res;
    }

    public void backtrack(
            int[] nums,
            List<List<Integer>> res,
            int idx,
            List<Integer> perm
    ) {
        if (idx == nums.length) {
            res.add(new ArrayList<>(perm));
            return;
        }
        for (int i = 0; i < nums.length; ++i) {
            if (used[i] || (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])) {
                continue;
            }
            perm.add(nums[i]);
            used[i] = true;
            backtrack(nums, res, idx + 1, perm);
            used[i] = false;
            perm.remove(idx);


        }
    }
}
