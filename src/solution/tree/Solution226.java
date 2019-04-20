package solution.tree;

/**
 * 翻转树
 */
public class Solution226 {
    public TreeNode invertTree(TreeNode root) {
        invert(root);
        return root;
    }
    public void invert(TreeNode root) {
        if (root == null) return;
        //swap left and right
        TreeNode right = root.right;
        root.right = root.left;
        root.left = right;
        //recursion
        invertTree(root.left);
        invertTree(root.right);
    }
}
