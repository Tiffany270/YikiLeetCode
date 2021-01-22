package Leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/*
*
        Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
        You may assume that the intervals were initially sorted according to their start times.

        Example 1:
        Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
        Output: [[1,5],[6,9]]
* */
public class _57_InsertInterval {

    /*
     * Same as 56 - -
     * 就要么在右边要么在左边，都不是就是有交集
     * */

    public int[][] insert(int[][] intervals, int[] newInterval) {

        List<int[]> res = new ArrayList<>();
        int left = newInterval[0];
        int right = newInterval[1];
        boolean placed = false;// make sure newInterval be used or not

        for (int[] interval : intervals) {
            if (interval[0] > right) {
                if (!placed) {
                    res.add(new int[]{left, right});
                    placed = true;
                }
                res.add(interval);
            } else if (interval[1] < left) {
                res.add(interval);
            } else {
                left = Math.min(left, interval[0]);
                right = Math.max(right, interval[1]);
            }
        }
        if (!placed) {
            res.add(new int[]{left, right});
        }

        int[][] ans = new int[res.size()][2];
        for (int i = 0; i < res.size(); ++i) {
            ans[i] = res.get(i);
        }


        return ans;
    }
}
