package Leetcode.medium;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
*
    Given an array nums of n integers and an integer target,
    are there elements a, b, c, and d in nums such that a + b + c + d = target?
    Find all unique quadruplets in the array which gives the sum of target.
    Notice that the solution set must not contain duplicate quadruplets.

        Example 1:
        Input: nums = [1,0,-1,0,-2,2], target = 0
        Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]

        Example 2:
        Input: nums = [], target = 0
        Output: []
* */
public class _18_4Sum {

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    int sum = 0;


    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        dfs(nums, target, 0);
        return res;

    }

    // solution2 回溯
    public void dfs(int[] nums, int target, int start) {
        if (list.size() == 4) {
            if (sum == target) {
                res.add(new ArrayList<>(list));// otherwise will []
            }
            return;
        }
        for (int i = start; i < nums.length; i++) {
            //--- with cut action to reduce the time complexity
            if (nums.length - i < 4 - list.size()) return;
            // meet equal num, skip
            if (start != i && nums[i - 1] == nums[i]) continue;
            // sorry 还是没搞懂这个，但是没有这个又超时- -
            if (i < nums.length - 1 && sum + nums[i] + (3 - list.size()) * nums[i + 1] > target) return;
            if (i < nums.length - 1 && sum + nums[i] + (3 - list.size()) * nums[nums.length - 1] < target) continue;
            //--- reduce end -----
            sum += nums[i];
            list.add(nums[i]);
            dfs(nums, target, i + 1);
            list.remove(list.size() - 1);
            sum -= nums[i];
        }

    }

    // solution1
    public List<List<Integer>> fourSum1(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return ans;
        }
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 0; i < len - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                break;
            }
            if (nums[i] + nums[len - 3] + nums[len - 2] + nums[len - 1] < target) {
                continue;
            }

            for (int j = i + 1; j < len - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                    break;
                }
                if (nums[i] + nums[j] + nums[len - 2] + nums[len - 1] < target) {
                    continue;
                }
                // --- 以上剪枝行为烦死了看不懂
                int left = j + 1;
                int right = len - 1;
                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        ans.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        left++;
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }

            }

        }


        return ans;

    }
}
