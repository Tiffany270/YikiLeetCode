package CodingInterviews;

import java.util.HashMap;

/*
* LeetCode 105
*
* Given preorder and inorder traversal of a tree, construct the binary tree.
        Note:
        You may assume that duplicates do not exist in the tree.
        For example, given
        preOrder = [3,9,20,15,7]
        inOrder = [9,3,15,20,7]
        Return the following binary tree:

            3
           / \
          9  20
            /  \
           15   7
* */
public class _07_ReBuildTree {
    HashMap<Integer, Integer> dic = new HashMap<>();

    int[] preOrder;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preOrder = preorder;
        for (int i = 0; i < inorder.length; i++)
            dic.put(inorder[i], i);
        return recur(0, 0, inorder.length - 1);

    }

    private TreeNode recur(int pre_root, int in_left, int in_right) {
        if(in_left > in_right) return null;
        TreeNode root = new TreeNode(preOrder[pre_root]);
        int i = dic.get(preOrder[pre_root]);

        root.left = recur(pre_root + 1, in_left, i - 1);

        // root.right = pre_root  +  左子树的长度 + 一个右子树的根
        // pre_root + ((i-1)-(in_left+1))+1
        root.right = recur(pre_root + i - in_left + 1, i + 1, in_right);

        return root;
    }

    public static void main(String[] args) {
        int[] pre = {3,9,20,15,7};
        int[] in = {9,3,15,20,7};
        _07_ReBuildTree func = new _07_ReBuildTree();
        func.buildTree(pre,in);
    }
}
