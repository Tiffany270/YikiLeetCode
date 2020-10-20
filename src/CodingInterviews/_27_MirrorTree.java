package CodingInterviews;

/*                LeetCode 226 题相同

   * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
                        例如输入：
                             4
                           /   \
                          2     7
                         / \   / \
                        1   3 6   9
                        镜像输出：

                             4
                           /   \
                          7     2
                         / \   / \
                        9   6 3   1

                输入：root = [4,2,7,1,3,6,9]
                输出：[4,7,2,9,6,3,1]

*/

/*
* NOTE:
       先：根左右
       中：左根右
       后：左右根
       二叉树：左子树 < 根 < 右子树
* */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class _27_MirrorTree {

    // 交换左右子树+递归即可
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode treeRight = root.right;
        root.right = mirrorTree(root.left);
        root.left = mirrorTree(treeRight);
        return root;

    }
}
