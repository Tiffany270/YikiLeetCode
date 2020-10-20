package CodingInterviews;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class _32_I_LevelOrder {
    /*
    * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
                例如:
                给定二叉树: [3,9,20,null,null,15,7],

                    3
                   / \
                  9  20
                    /  \
                   15   7
                返回：

                [3,9,20,15,7]
    * */

    // 队列（先进先出） ->LOOP里：在队列里依次弹出左右节点加入队列，直到队列为空
    public int[] levelOrder(TreeNode root) {
        if (root == null)
            return new int[0];

        ArrayList<Integer> res = new ArrayList();
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);

        while (!queue.isEmpty()){
            TreeNode node = queue.poll();//the head of this queue
            res.add(node.val);
            if(node.left!=null){
                queue.add(node.left);
            }
            if(node.right!=null){
                queue.add(node.right);
            }
        }
        int[] resn = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            resn[i] = res.get(i);
        }
        return resn;
    }
}
