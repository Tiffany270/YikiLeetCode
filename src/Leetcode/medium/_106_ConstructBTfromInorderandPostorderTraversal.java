//package Leetcode.medium;

// 没写出来/太久没写/有空再说

///* 106  Construct Binary Tree from Inorder and Postorder Traversal
// * 从中序与后序遍历序列构造二叉树
// * Given inorder and postorder traversal of a tree, construct the binary tree.
// * Note:You may assume that duplicates do not exist in the tree.
// * */
//
//public class ConstructBTfromInorderandPostorderTraversal {
//
//    private static class TreeNode {
//        int val;
//        TreeNode left;
//        TreeNode right;
//
//        TreeNode(int x) {
//            val = x;
//        }
//    }
//
//    /*
//     * 后序树为了方便分割确定索引，应该从后往前(start:po.len-1,end:0)
//     * 中序依旧从前往后(start:0,end:in.len-1)
//     * */
//
//
//    public TreeNode buildTree(int[] inorder, int[] postorder) {
//
//        return recursion(inorder, 0, inorder.length - 1, postorder, postorder.length - 1);
//
//    }
//
//    private TreeNode recursion(int[] in, int inStart, int inEnd,
//                               int[] po, int poStart
//    ) {
//        if (inStart > inEnd)
//            return null;
//
//
//        TreeNode root = new TreeNode(po[poStart]);
//        int InRootIndex = 0;//中序里根的索引
//        for (int i = 0; i < in.length; i++) {
//            if (po[poStart] == in[i]) {
//                InRootIndex = i;
//            }
//        }
//        root.left = recursion(in, inStart, InRootIndex - 1,
//                po, poEnd - 1 - (in.length - 1 - InRootIndex));
//        root.right = recursion(in, InRootIndex + 1, inEnd,
//                po, poEnd - 1);
//
//        /*
//        int[] inorder, int inStart, int inEnd, int[] postorder,int postStart
//        root.left = buildTree(inorder, rIndex - 1, inEnd, postorder, postStart - (inStart - rIndex) -1);
//        * root.right = buildTree(inorder, inStart, rIndex + 1, postorder, postStart-1);
//	    */
//
//        return root;
//    }
//}
