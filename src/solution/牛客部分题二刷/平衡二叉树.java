package solution.牛客部分题二刷;

public class 平衡二叉树 {
    boolean isBalance = true;

    public boolean IsBalanced_Solution(TreeNode root) {
        height(root);
        return isBalance;
    }

    public int height(TreeNode root) {
        if (root == null)
            return 0;
        int left = height(root.left);    //左子树的高度
        int right = height(root.right);    //右子树的高度
        if (Math.abs(left - right) > 1)
            isBalance = false;
        return 1 + Math.max(left, right);
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
