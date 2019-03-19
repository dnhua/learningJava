package newcode;

import java.util.ArrayList;
import java.util.List;

/**
 *输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输
 * 入整数的所有路径。路径定义为从树的根结点开始往下一直
 * 到叶结点所经过的结点形成一条路径。下图的二叉树有两条
 * 和为 22 的路径：10, 5, 7 和 10, 12
 */
public class Solution36 {
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        find(res, list, root, target);
        return res;
    }

    private void find(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> list, TreeNode node, int target) {
        if (node == null)
            return;
        list.add(node.val);
        target -= node.val;
        if (target == 0 && node.left == null && node.right == null) {
            res.add(new ArrayList<>(list));
        } else {
            find(res, list, node.left, target);
            find(res, list, node.right, target);
        }
        list.remove(list.size()-1);
    }

    public class TreeNode {
        int val;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val) {
            this.val = val;
        }
    }
}
