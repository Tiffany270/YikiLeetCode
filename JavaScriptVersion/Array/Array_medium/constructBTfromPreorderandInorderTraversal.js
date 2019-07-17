/**105
 * @param {number[]} preorder
 * @param {number[]} inorder
 * @return {TreeNode}
 *
 * Explanation/Discussion:

 * Consider this input:

 * preorder: [1, 2, 4, 5, 3, 6]
 * inorder:  [4, 2, 5, 1, 6, 3]
 * The obvious way to build the tree is:
 *  1.Use the first element of preorder, the 1, as root.
 *  2.Search it in inorder.
 *  3.Split inorder by it, here into [4, 2, 5] and [6, 3].
 *  4.Split the rest of preorder into two parts as large as the inorder parts, here into [2, 4, 5] and [3, 6].
 *  5.Use preorder = [2, 4, 5] and inorder = [4, 2, 5] to add the left subtree.
 *  6.Use preorder =[3, 6]andinorder = [6, 3] to add the right subtree.
 */

function TreeNode(val) {
    this.val = val;
    this.left = this.right = null;
}

var buildTree = function (preorder, inorder) {
    let pre = 0;
    let i = 0;
    build = function (stop) {
        if (inorder[i] !== stop) {
            let root = new TreeNode(preorder[pre++]);
            root.left = build(root.val);
            i++;
            root.right = build(stop);
            return root;
        }
        return null;
    };

    return build();

};