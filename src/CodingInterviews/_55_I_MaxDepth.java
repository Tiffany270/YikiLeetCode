package CodingInterviews;

/*
同leetcode104
Given a binary tree, find its maximum depth.
The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

            Note: A leaf is a node with no children.
            Example:
            Given binary tree [3,9,20,null,null,15,7],

                3
               / \
              9  20
                /  \
               15   7
            return its depth = 3.

* */

/*  DFS就是递归左递归右或栈，比想多了,don't over think about it
    深度每一层都要+1
    BFS一般用queue
     */


public class _55_I_MaxDepth {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right))+1;
    }


}
