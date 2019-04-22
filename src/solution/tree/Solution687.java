package solution.tree;

/**
 * 相同节点值的最大路径长度
 *              1
 *             / \
 *            4   5
 *           / \   \
 *          4   4   5
 *
 * Output : 2
 */
public class Solution687 {
    int max = 0;
    public int longestUnivaluePath(TreeNode root) {
        dfs(root);
        return max;
    }
    public int dfs(TreeNode root) {
        if (root == null) return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        //判断左子节点和根节点是否相等
        int leftpath = root.left != null && root.val == root.left.val ? left + 1 : 0;
        //判断右子节点和根节点是否相等
        int rightpath = root.right != null && root.val == root.right.val ? right + 1 : 0;
        max = Math.max(max, leftpath + rightpath);
        return Math.max(leftpath, rightpath);
    }
}
