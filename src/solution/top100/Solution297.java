package solution.top100;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 297. Serialize and Deserialize Binary Tree
 * https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
 * Serialization is the process of converting a data structure or object into a sequence of bits so that
 * it can be stored in a file or memory buffer, or transmitted across a network connection link to be
 * reconstructed later in the same or another computer environment.
 *
 * Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your
 * serialization/deserialization algorithm should work. You just need to ensure that a binary tree can
 * be serialized to a string and this string can be deserialized to the original tree structure.
 *
 * Example:
 *
 * You may serialize the following tree:
 *
 *     1
 *    / \
 *   2   3
 *      / \
 *     4   5
 *
 * as "[1,2,3,null,null,4,5]"
 */
public class Solution297 {
    private final String SEPARATOR = ",";
    private final String SIGN = "#";
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }

    private void serialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append(SIGN).append(SEPARATOR);
        } else {
            sb.append(root.val).append(SEPARATOR);
            serialize(root.left, sb);
            serialize(root.right, sb);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Deque<String> nodes = new LinkedList<>();
        nodes.addAll(Arrays.asList(data.split(SEPARATOR)));
        return deserialize(nodes);
    }

    private TreeNode deserialize(Deque<String> nodes) {
        String s = nodes.pollFirst();
        if (s.equals(SIGN)) {
            return null;
        } else {
            TreeNode root = new TreeNode(Integer.parseInt(s));
            root.left = deserialize(nodes);
            root.right = deserialize(nodes);
            return root;
        }
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

}
