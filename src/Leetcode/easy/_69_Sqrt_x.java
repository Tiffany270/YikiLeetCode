package Leetcode.easy;

// 求根号X 二分法
public class _69_Sqrt_x {
    public int mySqrt(int x) {

        int left = 0;
        int right = x;
        int res = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if ((long) mid * mid <= x) {
                res = mid;
                left = mid + 1;
            } else {
                right = mid - 1;

            }


        }

        return res;


    }
}
