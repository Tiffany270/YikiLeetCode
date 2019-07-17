package Array.Medium;

/*11.盛最多水的容器
 *给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
 * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 *
 * Given n non-negative integers a1, a2, ..., an ,
 * where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
 * Find two lines, which together with x-axis forms a container,
 * such that the container contains the most water.
 * Note: You may not slant the container and n is at least 2.
 *
 * Input: [1,8,6,2,5,4,8,3,7]
 * Output: 49
 * */

public class ContainerWithMostWater {

    /*题解1： Brute Force/暴力法
     * 用两个循环来找max...
     *
     * 太慢了……慢到没朋友
     * */

    public int maxArea(int[] height) {

        int maxArea = 0;

        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                //point 底边 = j-i;
                int temp = Math.min(height[i], height[j]) * (j - i);
                maxArea = Math.max(maxArea, temp);
            }
        }
        return maxArea;

    }
}
