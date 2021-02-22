package Leetcode.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/*

    Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
    You may return the answer in any order.

                Example 1:
                Input: n = 4, k = 2
                Output:
                [
                  [2,4],
                  [3,4],
                  [2,3],
                  [1,2],
                  [1,3],
                  [1,4],
                ]

                Example 2:
                Input: n = 1, k = 1
                Output: [[1]]
* */
public class _77_Combinations {

    /*
    *  n = 4, 集合为1~4
    *  k是深度
    * */
    List<List<Integer>> res = new ArrayList<>();
    Deque<Integer> path = new ArrayDeque<>();

    public List<List<Integer>> combine(int n, int k) {
        dfs(n, k, 1);
        return res;
    }

    public void dfs(int n, int k, int startIndex) {

        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; i <= n; i++) {
            path.addLast(i);
            dfs(n, k, i + 1);
            path.removeLast();

        }
    }
}
