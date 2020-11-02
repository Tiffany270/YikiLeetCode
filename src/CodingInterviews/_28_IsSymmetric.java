package CodingInterviews;

// 判断一颗二叉树是不是对称的

public class _28_IsSymmetric {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        } else {
            return  recur(root.left, root.right);
        }
    }

    private boolean recur(TreeNode L, TreeNode R) {
        if (L == null && R == null) return true;//其实成功到底就是对称了
        if (L == null || R == null || L.val != R.val) {
            return false;
        }

        return recur(L.left, R.right) && recur(L.right, R.left);
    }
}
