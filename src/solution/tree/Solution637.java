package solution.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 一棵树每层节点的平均数
 */
public class Solution637 {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        //特殊情况
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        //主循环
        while (!queue.isEmpty()) {
            int qsize = queue.size();
            Double sum = 0.0;
            for (int i=0; i<qsize; i++) {
                TreeNode node = queue.poll();
                sum += node.val;
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            res.add(sum/qsize);
        }
        return res;
    }
}
