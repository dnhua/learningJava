package solution.tree;

/**
 * 树的对称
 */
public class Solution101 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return symmetric(root.left, root.right);
    }
    public boolean symmetric(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) return true;    //都为null,返回true
        if (node1 == null || node2 == null) return false;   //仅有一个为null,返回false
        if (node1.val != node2.val) return false;
        return symmetric(node1.left, node2.right) && symmetric(node1.right, node2.left);
    }
}
