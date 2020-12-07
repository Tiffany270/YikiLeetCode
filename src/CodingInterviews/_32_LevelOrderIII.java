package CodingInterviews;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/*
* 请实现一个函数按照之字形顺序打印二叉树，
* 即第一行按照从左到右的顺序打印，
* 第二层按照从右到左的顺序打印，
* 第三行再按照从左到右的顺序打印，其他行以此类推。
            例如:
            给定二叉树: [3,9,20,null,null,15,7],

                3
               / \
              9  20
                /  \
               15   7
            返回其层次遍历结果：

            [
              [3],
              [20,9],
              [15,7]
            ]

* */

// 双端队列性质+奇偶性(用res的长度来判断） 其他和II一样
public class _32_LevelOrderIII {
    public List<List<Integer>> levelOrder(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if (root != null) {
            queue.add(root);

        }
        while (!queue.isEmpty()) {

            LinkedList temp = new LinkedList();
            int qlen = queue.size();
            for (int index = 0; index < qlen; index++) {
                TreeNode node = queue.poll();
                if(res.size()%2==0){//偶数 改变temp的顺序就行了
                    temp.addLast(node.val);

                }else{
                    temp.addFirst(node.val);
                }
                    if(node.left!=null) queue.addLast(node.left);
                    if(node.right!=null)queue.addLast(node.right);

            }
            res.add(temp);
        }

        return res;
    }
}
