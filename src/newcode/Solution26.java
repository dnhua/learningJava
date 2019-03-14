package newcode;

/**
 * 输入两棵二叉树A，B，判断B是不是A的子结构。
 * （ps：我们约定空树不是任意一个树的子结构）
 */
public class Solution26 {
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if (root1 == null || root2 == null)
            return false;
        return isSubtree(root1, root2) || HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
    }

    private boolean isSubtree(TreeNode root1, TreeNode root2) {
        if (root2 == null)  //这里一定要先匹配root2，也就是正确的情况，因为可能存在同时为null的情况
            return true;
        if (root1 == null)
            return false;
        if (root1.val != root2.val)
            return false;
        return isSubtree(root1.left, root2.left) && isSubtree(root1.right, root2.right);
    }

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val) {
            this.val = val;
        }
    }

}
