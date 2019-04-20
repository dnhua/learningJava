package solution.tree;

/**
 * 统计路径和等于一个数的路径数量
 */
public class Solution437 {
    int res = 0;
    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        startWithRoot(root, sum);
        pathSum(root.left, sum);
        pathSum(root.right, sum);
        return res;
    }

    public void startWithRoot(TreeNode root, int sum) {
        if (root == null) return ;
        if (root.val == sum) res += 1;
        startWithRoot(root.left, sum-root.val);
        startWithRoot(root.right, sum-root.val);
    }
}
