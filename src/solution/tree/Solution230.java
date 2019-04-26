package solution.tree;

/**
 * 寻找二叉查找树的第 k 个元素
 */
public class Solution230 {
    //中序遍历解法
    int k;
    int res;
    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        inorder(root);
        return res;
    }
    public void inorder(TreeNode root) {
        if (root == null) return ;
        inorder(root.left);
        k--;
        if (k == 0) {
            res = root.val;
            return ;
        }
        inorder(root.right);
    }

    //递归法
    public int kthSmallest1(TreeNode root, int k) {
        int leftCnt = count(root.left);
        if (leftCnt == k - 1) return root.val;
        if (leftCnt > k - 1) return kthSmallest(root.left, k);
        return kthSmallest1(root.right, k - leftCnt - 1);
    }
    private int count(TreeNode node) {
        if (node == null) return 0;
        return 1 + count(node.left) + count(node.right);
    }
}
