package newcode;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 把二叉树打印成多行
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 */
public class Solution33 {
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        queue.add(pRoot);
        while (!queue.isEmpty()) {
            int qsize = queue.size();
            ArrayList<Integer> list = new ArrayList<>();
            while (qsize > 0) {
                TreeNode node = queue.poll();
                if (node!=null) {
                    list.add(node.val);
                    queue.add(node.left);
                    queue.add(node.right);
                }
                qsize--;
            }
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


//public class Solution {
//    ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
//        Queue<TreeNode> queue = new LinkedList<>();
//        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
//        if (pRoot == null)
//            return res;
//        queue.add(pRoot);
//        while (!queue.isEmpty()) {
//            int qsize = queue.size();
//            ArrayList<Integer> list = new ArrayList<>();
//            while (qsize > 0) {
//                TreeNode node = queue.poll();
//                list.add(node.val);
//                if (node.left != null)
//                    queue.add(node.left);
//                if (node.right != null)
//                    queue.add(node.right);
//                qsize--;
//            }
//            res.add(list);
//        }
//        return res;
//    }
//
//}