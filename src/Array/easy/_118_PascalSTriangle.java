package Array.easy;

/*序号118
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 *
 * Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
 * In Pascal's triangle, each number is the sum of the two numbers directly above it.
 * */

import java.util.ArrayList;
import java.util.List;

public class _118_PascalSTriangle {


    /*
    *思路看杨辉三角Ⅱ
    * point:
    * 1.java里list的add或者说所有集合传递的都是引用（就是地址）而不是值，也就是说add(变量),这个变量改变了所有的存储都会改变的
    * 但是这里又不能new在里面，只能拷贝一个list，怎么拷贝也是一个point，看代码
    * 2.循环条件是前n行，就不需要i<row+1了,直接等于row即可
    * */

    public static List<List<Integer>> generate(int numRows) {

        List<List<Integer>> resList = new ArrayList<>();
        List<Integer> myList = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            int prev = 1, temp;
            for (int j = 1; j < myList.size(); j++) {
                temp = myList.get(j);
                myList.set(j, temp + prev);
                prev = temp;
            }
            myList.add(1);
            List<Integer> innerList = new ArrayList<>(myList);//拷贝
            resList.add(innerList);
        }

        return resList;
    }

    public static void main(String[] args) {
        generate(3);
        System.out.println(generate(3));
    }


}
