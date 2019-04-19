package solution.tree;

/**
 * 两节点的最长路径
 */
public class Solution543 {
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return max;
    }
    public int depth(TreeNode root) {
        if (root == null) return 0;
        int left = depth(root.left);
        int right = depth(root.right);
        max = Math.max(max, left + right);
        return 1 + Math.max(left, right);
    }
}
