package CodingInterviews;
/*
*
*
* 输入一棵二叉树的根节点，判断该树是不是平衡二叉树。
* 如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
                示例 1:
                给定二叉树 [3,9,20,null,null,15,7]

                    3
                   / \
                  9  20
                    /  \
                   15   7
                返回 true 。

* */


/*
 * Solution: !-1 == is Balance
 * 后续遍历，返回深度，某一子树不平衡，直接判断该子树返回-1不叠加max
 * */
public class _55_IsBalanceII {
    public boolean isBalanced(TreeNode root) {
        return recur(root) != -1;
    }

    private int recur(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = recur(root.left);
        if (left == -1) {
            return -1;
        }

        int right = recur(root.right);
        if (right == -1) {
            return -1;
        }
        return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;

    }
}
