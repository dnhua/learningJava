package solution.top100;

/**
 * 105. Construct Binary Tree from Preorder and Inorder Traversal
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/submissions/
 */
public class Solution105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0)
            return null;
        if (inorder == null || inorder.length == 0)
            return null;
        if (inorder.length != preorder.length)
            return null;
        return build(preorder, inorder, 0, 0, inorder.length - 1);
    }

    public TreeNode build(int[] preorder, int[] inorder, int preIndex, int startIndex, int endIndex) {
        //sp case:如果startIndex大于endIndex则直接返回
        if (startIndex > endIndex)
            return null;
        //新建“根节点作为返回值”
        TreeNode node = new TreeNode(preorder[preIndex]);
        //计算根节点在inorder中的下标,并以这个下标作为数组的切分点
        int idx = getIndexInorder(inorder, preorder[preIndex]);
        int lenL = idx - startIndex;
        int lenR = endIndex - idx;
        //生成左子树
        if (lenL > 0)
            node.left = build(preorder, inorder, preIndex + 1, startIndex, idx - 1);
        //生成右子树
        if (lenR > 0)
            node.right = build(preorder, inorder, preIndex + lenL + 1, idx + 1, endIndex);
        return node;
    }

    public int getIndexInorder(int[] inorder, int val) {
        for (int i=0; i<inorder.length; i++) {
            if (inorder[i] == val)
                return i;
        }
        return -1;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
