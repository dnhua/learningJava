package solution.牛客部分题二刷;

public class 二叉搜索树与双向列表 {
    TreeNode head;    //当前的head
    TreeNode realhead;    //双向列表的head
    public TreeNode Convert(TreeNode pRootOfTree) {
        //终止条件
        if (pRootOfTree == null)
            return null;
        Convert(pRootOfTree.left);    //中序先左节点

        if (head == null) {    //最左节点
            head = pRootOfTree;
            realhead = pRootOfTree;
        } else {
            head.right = pRootOfTree;
            pRootOfTree.left = head;
            head = pRootOfTree;
        }

        Convert(pRootOfTree.right);    //中序后右节点

        return realhead;
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
