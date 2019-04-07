package newcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树的深度
 * 输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）
 * 形成树的一条路径，最长路径的长度为树的深度。
 */
public class Solution57 {
    public int TreeDepth(TreeNode root) {
        if (root == null)
            return 0;
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
            }
            cnt++;
        }
        return cnt;
//        return root == null ? 0 : 1 + Math.max(TreeDepth(root.left), TreeDepth(root.right));  //递归法
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
