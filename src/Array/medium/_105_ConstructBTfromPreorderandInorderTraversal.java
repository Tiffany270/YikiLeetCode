package Array.medium;

/*
 *  105. Construct Binary Tree from Preorder and Inorder Traversal
 *     从前序与中序遍历序列构造二叉树
 *     Given preorder and inorder traversal of a tree, construct the binary tree.
 * */

public class _105_ConstructBTfromPreorderandInorderTraversal {


    /*note:
     * 前序 根左右 首先访问根结点然后遍历左子树，最后遍历右子树
     * 中序 左根右 首先遍历左子树，然后访问根结点，最后遍历右子树
     * 后序 左右根 首先遍历左子树，然后遍历右子树，最后访问根结点
     * key point:
     *   怎么递归构造？传入pre in,怎么找pre的起始点？
     *   ->在 中序 中根的左边是左子树，左子树的个数长度放回 前序 +1  = 要构造的右子树的起始点
     *   形如： pre 1 2 4 5 7 8 3 6
     *            root
     *         in  4 2 7 5 8    1    3 6
     *            <   左     > root  <右>
     *        in里左子树共5个，那么在pre里，根过一个，再加上五，[2 4 5 7 8]就是1为根的左子树
     *       左子树的长度 = InRoot - InStart
     *       pre的起始点就是左子树的长度+1
     * 思路
     * 参考BTS
     * 前序pre[0]就是root，
     * 找到中序里root的位置，假设为inorder[i],
     * inorder[i]的左边就是左子树,右边是右子树
     * 所以递归构造
     * */


    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return recursion(
                preorder, 0, //前
                inorder, 0, inorder.length - 1);//中
    }

    /**
     * @param pre      前序序列
     * @param preStart 前序序列中有效的起始索引
     * @param //preEnd 前序序列中有效的终止索引
     * @param in       中序序列
     * @param inStart  中序序列中有效的起始索引
     * @param inEnd    中序序列中有效的终止索引
     * @return 某棵子树（或最终树）
     */
    private TreeNode recursion(int[] pre, int preStart,
                               int[] in, int inStart, int inEnd

    ) {

        if (preStart > pre.length - 1 || inStart > inEnd) {
            return null;
        }

        TreeNode root = new TreeNode(pre[preStart]);
        int InorderRoot = 0;
        //在中序里找到root
        for (int i = inStart; i <= inEnd; i++) {
            if (in[i] == root.val) {
                InorderRoot = i;
            }
        }

        root.left = recursion(
                pre, preStart + 1,
                in, inStart, InorderRoot - 1);

        root.right = recursion(
                pre, preStart + InorderRoot - inStart + 1,
                in, InorderRoot + 1, inEnd);

        return root;

    }

    /*思路2
     *
     * */
    private static int in = 0;
    private static int pre = 0;

    public static TreeNode buildTree2(int[] preorder, int[] inorder) {
        return build(preorder, inorder, Integer.MIN_VALUE);
    }


    private static TreeNode build(int[] preorder, int[] inorder, int stop) {
        if (pre >= preorder.length) return null;
        if (inorder[in] == stop) {
            in++;
            return null;
        }
        TreeNode node = new TreeNode(preorder[pre++]);
        node.left = build(preorder, inorder, node.val);
        node.right = build(preorder, inorder, stop);
        return node;
    }

    public static void main(String[] args) {
        int pre[] = {1, 2, 4, 5, 7, 8, 3, 6};
        int in[] = {4, 2, 7, 5, 8, 1, 3, 6};
        buildTree2(pre, in);
    }


}
