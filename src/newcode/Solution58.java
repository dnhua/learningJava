package newcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 平衡二叉树
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 */
public class Solution58 {
    private boolean isBalanced = true;

    public boolean IsBalanced_Solution(TreeNode root) {
        height(root);
        return isBalanced;
    }

    private int height(TreeNode root) {
        if (root == null || !isBalanced)
            return 0;
        int left = height(root.left);
        int right = height(root.right);
        if (Math.abs(left - right) > 1)
            isBalanced = false;
        return 1 + Math.max(left, right);
    }

    /**
     * 有问题啊，仅仅通过42.8%
     * @param root
     * @return
     */
    public boolean IsBalanced_Solution1(TreeNode root) {
        if (root == null)
            return false;
        int minHeight = 0;
        int maxHeight = 0;
        int cnt = 0;
        Queue<TreeNode> q = new LinkedList();
        q.offer(root);
        //广度优先搜索
        while (!q.isEmpty()) {
            int qsize = q.size();
            for (int i=0; i<qsize; i++) {
                TreeNode node = q.poll();
                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
                //找到的第一个叶子节点
                if (node.left == null && node.right == null && cnt == 0) {
                    minHeight = maxHeight + 1;
                    cnt++;
                }
            }
            maxHeight++;    //得到树的深度
        }
        return (maxHeight - minHeight) < 2;
    }

}
