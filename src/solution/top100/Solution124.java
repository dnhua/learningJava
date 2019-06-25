package solution.top100;

/**
 * 124. Binary Tree Maximum Path Sum
 * https://leetcode.com/problems/binary-tree-maximum-path-sum/
 * 对于一个节点来说，其最大值为其本身与其左子树路径最大值与右子树路径最大值之和
 */
public class Solution124 {
    int maxValue = Integer.MIN_VALUE;   //用来保存最大值，这里一定要初始化为最小整数，不可初始化为0
    public int maxPathSum(TreeNode root) {
        if (root == null)
            return 0;
        findMaxSum(root);
        return maxValue;
    }

    public int findMaxSum(TreeNode root) {
        if (root == null)   //如果root为null，就直接返回0
            return 0;
        int curValue = root.val;

        //分别计算左子树路径和与右子树路径和
        int lvalue = findMaxSum(root.left);
        int rvalue = findMaxSum(root.right);

        //如果lvalue和rvalue大于0，则将它们加入到和里面来
        if (lvalue > 0)
            curValue += lvalue;
        if (rvalue > 0)
            curValue += rvalue;

        //如果当前的和大于maxValue，则更新maxValue
        if (maxValue < curValue)
            maxValue = curValue;

        //返回以当前根的子树的最大和
        return Math.max(root.val, Math.max(root.val + lvalue, root.val + rvalue));
    }

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
}
