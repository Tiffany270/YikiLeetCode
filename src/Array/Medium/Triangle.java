package Array.Medium;

import java.util.ArrayList;
import java.util.List;

/*
 *  120. Triangle/三角形最小路径和
 *  Given a triangle,
 *  find the minimum path sum from top to bottom.
 *  Each step you may move to adjacent numbers on the row below.
 *  Note:
 *  Bonus point if you are able to do this using only O(n) extra space,
 *  where n is the total number of rows in the triangle.
 * */

public class Triangle {

    /*思路
     * DP + bottom to top + 非原地
     * minPath[i] = min( minPath[i], minPath[i+1]) + triangle[k][i];
     * 进一步优化解决了重叠子问题overlapping subproblems.
     * */
    public int minimumTotal(List<List<Integer>> triangle) {
        int k = triangle.size();//高
        int len = triangle.get(k - 1).size();//底长

        int[] minPath = new int[k];
        //以底边的长开辟一个新的数组来保留最短距离，初始化为底边的元素
        for (int i = 0; i < len; i++) {
            minPath[i] = triangle.get(k - 1).get(i);
        }
        for (int i = k - 2; i >= 0; i--) {//从倒数第二层开始
            List<Integer> temp = triangle.get(i);
            for (int j = 0; j < temp.size(); j++) {
                minPath[j] = Math.min(minPath[j], minPath[j + 1]) + temp.get(j);
            }
        }
        return minPath[0];
    }



}
