package newcode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 */
public class Solution32 {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        //广度优先遍历顺序即是答案要求的遍历顺序
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null)
            return res;
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            res.add(node.val);
            if (node.left!=null)
                queue.add(node.left);
            if (node.right!=null)
                queue.add(node.right);
        }
        return res;
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

//    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
//        Queue<TreeNode> queue = new LinkedList<>();
//        ArrayList<Integer> ret = new ArrayList<>();
//        queue.add(root);
//        while (!queue.isEmpty()) {
//            int cnt = queue.size();
//            while (cnt-- > 0) {
//                TreeNode t = queue.poll();
//                if (t == null)
//                    continue;
//                ret.add(t.val);
//                queue.add(t.left);
//                queue.add(t.right);
//            }
//        }
//        return ret;
//    }
