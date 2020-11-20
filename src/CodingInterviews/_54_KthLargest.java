package CodingInterviews;

/*
* 给定一棵二叉搜索树，请找出其中第k大的节点。
* 解释下，节点数越大表示越大 - -，6最大，5次之

                输入: root = [5,3,6,2,4,null,null,1], k = 3
                       5
                      / \
                     3   6
                    / \
                   2   4
                  /
                 1
                输出: 4

* */

// 中序遍历反向即可。
public class _54_KthLargest {
    int res = 0;
    int k = 0;
    public int kthLargest(TreeNode root, int k) {
        this.k=k;
        recur(root);

        return res;
    }

    void recur(TreeNode root) {
        if (root == null) return;
        recur(root.right);
        if (k == 0) return;
        if (--k == 0) res = root.val;
        recur(root.left);

    }


}

                    /*  NOTE:
                          | - prev ro L  R
                      DFS | - in   L  ro R  ->    use recur or stack
                          | - last L  R ro

                      BFS -> use queue, add root to queue, while(queue!empty),
                            poll header of queue then add left and right to queue
                    *
                    * binary search tree = left < root < right
                    * binary balance tree = each root has left and right,
                    *                       (depth left - depth right) < 2
                    *
                    * */
