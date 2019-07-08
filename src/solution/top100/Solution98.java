package solution.top100;

import solution.tree.TreeNode;

/**
 * 98. Validate Binary Search Tree
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 *
 * Assume a BST is defined as follows:
 *
 *     The left subtree of a node contains only nodes with keys less than the node's key.
 *     The right subtree of a node contains only nodes with keys greater than the node's key.
 *     Both the left and right subtrees must also be binary search trees.
 *
 *
 *
 * Example 1:
 *
 *     2
 *    / \
 *   1   3
 */
public class Solution98 {
    //注意注意，这个解法是错误的，错误的！！！
    boolean flag = true;
    public boolean isValidBST(TreeNode root) {
        //思路：中序遍历，看看是否是按照从小到大排列
        traverse(root);
        return flag;
    }

    public void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        traverse(root.left);
        //判断是否合法
        TreeNode left = root.left;
        TreeNode right = root.right;
        if (left != null)
            if (left.val >= root.val) {
                flag = false;
                return;
            }
        if (right != null)
            if (right.val <= root.val) {
                flag = false;
                return;
            }
        traverse(root.right);
    }
}
