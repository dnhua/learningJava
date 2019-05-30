package solution.search;

import solution.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 输出二叉树中所有从根到叶子的路径
 * 257. Binary Tree Paths (Easy)
 * https://leetcode.com/problems/binary-tree-paths/
 *   1
 *  /  \
 * 2    3
 *  \
 *   5
 *
 * ["1->2->5", "1->3"]
 */
public class Solution257 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null)
            return res;
        dfs(root, res, new String());
        return res;
    }

    private void dfs(TreeNode root, List<String> res, String curPath) {
        if (root == null) {
            return ;
        }

        if (curPath.length() != 0)
            curPath += "->" + root.val;
        else
            curPath += root.val;

        if (root.left == null && root.right == null) {
            res.add(curPath);
        }
        dfs(root.left, res, curPath);
        dfs(root.right, res, curPath);
    }
}
