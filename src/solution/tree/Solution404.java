package solution.tree;

/**
 * 统计左叶子节点的和
 */
public class Solution404 {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        if (isLeftLeave(root.left)) return root.left.val + sumOfLeftLeaves(root.right);
        return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }

    public boolean isLeftLeave(TreeNode root) {
        if (root == null) return false;
        return root.left == null && root.right == null;
    }
}
