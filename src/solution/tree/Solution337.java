package solution.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 间隔遍历
 */
public class Solution337 {
//    此答案有问题，没有考虑间隔多行的情况。
//    public int rob(TreeNode root) {
//        if (root == null) return 0;
//        int sum1 = bfs(root, 0);
//        int sum2 = bfs(root, 1);
//        return Math.max(sum1, sum2);
//    }
//
//    public int bfs(TreeNode root, int flag) {
//        int sum = 0;
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.add(root);
//        while(queue.size() != 0){
//            int qsize = queue.size();
//            for(int i=0;i<qsize;i++){
//                TreeNode curnode = queue.poll();
//                if (flag % 2 == 0) sum += curnode.val;
//                if(curnode.left!=null)
//                    queue.add(curnode.left);
//                if(curnode.right!=null)
//                    queue.add(curnode.right);
//            }
//            flag++;
//        }
//        return sum;
//    }
    public int rob(TreeNode root) {
        if (root == null) return 0;
        int val1 = root.val;
        if (root.left != null) val1 += rob(root.left.left) + rob(root.left.right);
        if (root.right != null) val1 += rob(root.right.left) + rob(root.right.right);
        int val2 = rob(root.left) + rob(root.right);
        return Math.max(val1, val2);
    }
}
