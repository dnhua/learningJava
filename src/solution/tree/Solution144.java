package solution.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 非递归实现二叉树的前序遍历
 */
public class Solution144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        //特殊情况
        if (root == null) return res;
        Stack<TreeNode> stack = new Stack<>();  //使用栈来保存数据
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            res.add(node.val);
            //先放right,再放left
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
        }
        return res;
    }
}
