package CodingInterviews;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/*
* 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。

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
              [9,20],
              [15,7]
            ]
*/
// BFS + 队列，内部循环当前层的节点临时保存一下就行啦
public class _32_LevelOrderII {
    public List<List<Integer>> levelOrder(TreeNode root) {

        LinkedList<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if (root != null){
            queue.add(root);

        }
        while (!queue.isEmpty()) {
            ArrayList temp = new ArrayList();
            int loopLen = queue.size();
            for (int i = 0; i <loopLen; i++) {// 注意写在里面会错，因为size会变化
                TreeNode node = queue.poll();
                temp.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }

            }
            res.add(temp);

        }


        return res;
    }
}
