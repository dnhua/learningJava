package solution.tree;

/**
 * 二叉树的最近公共祖先
 */
public class Solution236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //在root的左子树里
        if (root.val > p.val && root.val > q.val)
            return lowestCommonAncestor(root.left, p, q);
        //在root的右子树里
        if (root.val < p.val && root.val < q.val)
            return lowestCommonAncestor(root.right, p, q);
        //找到了
        return root;
    }
}
