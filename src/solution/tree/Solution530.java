package solution.tree;

/**
 * Minimum Absolute Difference in BST
 */
public class Solution530 {
    int mindiff = Integer.MAX_VALUE;
    TreeNode preNode;   //保存一下中序遍历的上一个节点
    public int getMinimumDifference(TreeNode root) {
        inorder(root);
        return mindiff;
    }
    public void inorder(TreeNode root) {
        if (root == null) return ;
        inorder(root.left);
        //处理逻辑
        if (preNode != null) mindiff = Integer.min(mindiff, root.val - preNode.val);
        preNode = root;
        inorder(root.right);
    }
}
