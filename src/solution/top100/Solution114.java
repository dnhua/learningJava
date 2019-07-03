package solution.top100;

import solution.tree.TreeNode;

/**
 * 114. Flatten Binary Tree to Linked List
 * Given a binary tree, flatten it to a linked list in-place.
 *
 * For example, given the following tree:
 *
 *     1
 *    / \
 *   2   5
 *  / \   \
 * 3   4   6
 *
 * The flattened tree should look like:
 *
 * 1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
 */
public class Solution114 {
    public void flatten(TreeNode root) {
        if (root == null)
            return ;
        if (root.left != null) {
            TreeNode cur = root.left;
            //找到左子树的最右的节点
            while (cur.right != null) {
                cur = cur.right;
            }
            //以下三个操作可使跟节点为有序
            cur.right = root.right;
            root.right = root.left;
            root.left = null;
        }
        flatten(root.right);
    }
}
