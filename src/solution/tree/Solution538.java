package solution.tree;

/**
 * Convert BST to Greater Tree
 */
public class Solution538 {
    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        travel(root);
        return root;
    }

    public void travel(TreeNode root) {
        if (root == null) return ;
        travel(root.right); //从最右边开始遍历
        sum += root.val;
        root.val = sum;
        travel(root.left);  //最后遍历左子树
    }
}
