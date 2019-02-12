package Array.easy;

import java.util.ArrayList;
import java.util.List;

/*
 * 序号119
 * 杨辉三角
 *给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行
 *在杨辉三角中，每个数是它左上方和右上方的数的和
 *索引从0开始
 *
 * 进阶：
 * 你可以优化你的算法到 O(k) 空间复杂度吗？
 * Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle.
 * Note that the row index starts from 0.
 * In Pascal's triangle, each number is the sum of the two numbers directly above it.
 * Follow up:
 * Could you optimize your algorithm to use only O(k) extra space?
 * */
public class PascalsTriangleII {

    /*
     * 思路：
     * 循环叠加+替换list
     * 对于上一个循环的原数组，设置一个pre指针，内循环一次在原数组的基础上移动pre
     * 对于被替换的数组，要保存temp=要被替换的元素
     * 比如 k=3 [1,3,3,1]
     * 那么 k=4 没开始替换构造前依然是[1,3,3,1],循环数目是k=3的size,末尾加一个1的元素就是新的那一行了
     * 所以pre一开始是1
     * [1,    3,     3 , 1]
     *  pre   temp
     *  内循环开始，保存要替换的元素temp=3,pre=1,杨辉三角pre+temp不就等于下面的数
     *  于是替换(从j=1开始)
     * k=3 [ 1,  3 ,  3 , 1] 然后移动pre,pre就等于循环的当前index（是原数组）
     *          pre
     * 修改后的：
     * k=4 [1, 4 , 3 , 1 ] 依旧保存要修改的元素，
     *            temp      k=4的下一个循环里 修改当前索引，pre=3+temp=3
     * k=4 [1,4,6,1]
     * k=3 [ 1 , 3,  3,  1] pre继续移动
     *             pre
     * 其他同理
     *point:
     * 1.内循环永远从第1个元素（索引从0开始，0的位置是1)开始循环
     * 2.末尾永远是1这个元素
     * 3.Pre是指向前一个循环的数组而不是已经修改了的数组
     * 4.要产生新的替换数组，外循环要么<= rowIndex，要么<rowIndex+1
     * */
    public static List<Integer> getRow(int rowIndex) {
        List<Integer> myList = new ArrayList<>();

        for (int index = 0; index <= rowIndex; index++) {
            int prev = 1;

            int temp;
            for (int j = 1; j < myList.size(); j++) {
                temp = myList.get(j);
                myList.set(j, temp + prev);
                prev = temp;
            }

            myList.add(1);
        }


        return myList;
    }


    public static void main(String[] args) {
        System.out.println(getRow(3));
    }
}
