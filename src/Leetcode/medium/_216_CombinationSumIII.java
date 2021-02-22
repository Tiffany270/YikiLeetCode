package Leetcode.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/*
    Find all valid combinations of k numbers that sum up to n such that the following conditions are true:
    Only numbers 1 through 9 are used.
    Each number is used at most once.
    Return a list of all possible valid combinations. The list must not contain the same combination twice,
    and the combinations may be returned in any order.

                    Example 1:
                    Input: k = 3, n = 7
                    Output: [[1,2,4]]
                    Explanation:
                    1 + 2 + 4 = 7
                    There are no other valid combinations.

                    Example 2:
                    Input: k = 3, n = 9
                    Output: [[1,2,6],[1,3,5],[2,3,4]]
                    Explanation:
                    1 + 2 + 6 = 9
                    1 + 3 + 5 = 9
                    2 + 3 + 4 = 9
                    There are no other valid combinations.

                    Example 3:
                    Input: k = 4, n = 1
                    Output: []
                    Explanation: There are no valid combinations. [1,2,1] is not valid because 1 is used twice.

                    Example 4:
                    Input: k = 3, n = 2
                    Output: []
                    Explanation: There are no valid combinations.

                    Example 5:
                    Input: k = 9, n = 45
                    Output: [[1,2,3,4,5,6,7,8,9]]
                    Explanation:
                    1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 = 45
                    ​​​​​​​There are no other valid combinations.

*
* */
public class _216_CombinationSumIII {

    /*
     * Note : 1~9 才是集合 = 树的宽度
     * */

    List<List<Integer>> res = new ArrayList<>();
    Deque<Integer> path = new ArrayDeque<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        dfs(n, k, 0, 1);
        return res;
    }

    public void dfs(
            int target,// n
            int k, //k ->  to limit the deep of ur tree
            int sum,
            int startIndex
    ) {


        if (sum > target) { // 剪枝操作
            return; // 如果path.size() == k 但sum != targetSum 直接返回
        }
        // end condition
        if (path.size() == k) {
            if (sum == target) {
                res.add(new ArrayList<>(path));
            }
            return;
        }

        // because of [1...9] so loop for 9
        for (int i = startIndex; i <= 9; i++) { // 是=
            sum += i;
            path.addLast(i);
            dfs(target, k, sum, i + 1);
            sum -= i;//backtracking
            path.removeLast();


        }

    }

    public static void main(String[] args) {
        _216_CombinationSumIII func = new _216_CombinationSumIII();
        List<List<Integer>> res =  func.combinationSum3(9,45);
        System.out.println(res.toString());
    }
}
