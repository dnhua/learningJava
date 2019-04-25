package solution.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 得到左下角的节点
 */
public class Solution513 {
    public int findBottomLeftValue(TreeNode root) {
        int res = 0;
        //特殊情况
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        //主循环
        while (!queue.isEmpty()) {
            res = queue.peek().val;
            int qsize = queue.size();
            for (int i=0; i<qsize; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
        }
        return res;
    }

    public int findBottomLeftValue2(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            root = queue.poll();
            if (root.right != null) queue.add(root.right);
            if (root.left != null) queue.add(root.left);
        }
        return root.val;
    }
}
