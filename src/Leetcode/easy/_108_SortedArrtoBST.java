package Leetcode.easy;

/*
* Given an array where elements are sorted in ascending order,
 * convert it to a height balanced BST.
For this problem,
a height-balanced binary tree is defined as a binary tree
in which the depth of the two subtrees of every node never differ by more than 1.

        Example:
        Given the sorted array: [-10,-3,0,5,9],
        One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
              0
             / \
           -3   9
           /   /
         -10  5
* */
public class _108_SortedArrtoBST {

    /*
     * solution 中序遍历 取中间值为root 递归
     * */
    public TreeNode sortedArrayToBST(int[] nums) {

        return recur(nums, 0, nums.length - 1);
    }

    public TreeNode recur(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = recur(nums,left,mid-1);
        root.right= recur(nums,mid+1,right);

        return root;
    }
}
