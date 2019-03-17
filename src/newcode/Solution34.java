package newcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 按之字形顺序打印二叉树
 * 请实现一个函数按照之字形打印二叉树，
 * 即第一行按照从左到右的顺序打印，第
 * 二层按照从右至左的顺序打印，第三行
 * 按照从左到右的顺序打印，其他行以此
 * 类推。
 */
public class Solution34 {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        queue.add(pRoot);
        int i = 0;
        while (!queue.isEmpty()) {
            int qsize = queue.size();
            ArrayList<Integer> list = new ArrayList<>();
            while (qsize > 0) {
                TreeNode node = queue.poll();
                if (node!=null) {
                    if ((i & 1) == 0)
                        list.add(node.val);
                    else
                        stack.push(node.val);
                    queue.add(node.left);
                    queue.add(node.right);
                }
                qsize--;
            }
            while (!stack.isEmpty())
                list.add(stack.pop());
            i = i + 1;
            if (list.size() != 0)
                res.add(list);
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

//    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
//        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.add(pRoot);
//        boolean reverse = false;
//        while (!queue.isEmpty()) {
//            ArrayList<Integer> list = new ArrayList<>();
//            int cnt = queue.size();
//            while (cnt-- > 0) {
//                TreeNode node = queue.poll();
//                if (node == null)
//                    continue;
//                list.add(node.val);
//                queue.add(node.left);
//                queue.add(node.right);
//            }
//            if (reverse)
//                Collections.reverse(list);
//            reverse = !reverse;
//            if (list.size() != 0)
//                ret.add(list);
//        }
//        return ret;
//    }
