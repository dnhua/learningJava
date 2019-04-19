package solution.tree;

/**
 * 平衡树
 */
public class Solution110 {
    boolean balance = true;
    public boolean isBalanced(TreeNode root) {
        //sp case
        if (root == null) return true;
        height(root);
        return balance;
    }
    public int height(TreeNode root) {
        if (root == null)
            return 0;
        //calc left height
        int left = height(root.left);
        //calc right height
        int right = height(root.right);
        //judge
        if (Math.abs(left - right) > 1)
            balance = false;
        return 1 + Math.max(left, right);
    }
}
