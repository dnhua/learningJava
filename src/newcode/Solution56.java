package newcode;

/**
 * 二叉搜索树的第k个节点
 * 给定一棵二叉搜索树，请找出其中的第k小的结点。例如， （5，3，7，2，4，6，8）
 * 中，按结点数值大小顺序第三小结点的值为4。
 */
public class Solution56 {
    public class Solution {
        TreeNode res = null;
        int cnt = 0;
        TreeNode KthNode(TreeNode pRoot, int k){
            findkInorder(pRoot, k);
            return res;
        }

        private void findkInorder(TreeNode node, int k) {
            if (node == null || cnt >= k)
                return;
            findkInorder(node.left, k);
            cnt++;
            if (cnt == k)
                res = node;
            findkInorder(node.right, k);
        }
    }

    public static void main(String[] args) {
        Solution56 solution56 = new Solution56();
        int cnt = 0;
        solution56.increaseCnt(cnt);
        System.out.println(cnt);
    }

    private void increaseCnt(int cnt){
        cnt++;
        System.out.println("cnt in func:" + cnt);
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
