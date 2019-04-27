package solution.tree;

/**
 * 根据有序链表构造平衡的二叉查找树
 */
public class Solution109 {
    ListNode list ;
    int len = 0;
    TreeNode root;
    public TreeNode sortedListToBST(ListNode head) {
        // 计算链表总长度
        list = head;
        while (head != null) {
            len++;
            head = head.next;
        }
        build(0, len-1);
        return root;
    }

    private TreeNode build(int lo, int hi) {
        if (lo > hi) return null;
        int mid = (lo + hi) / 2;
        // 先求左子树
        TreeNode left = build(lo, mid-1);
        // 构造节点
        TreeNode node = new TreeNode(list.val);
        list = list.next;
        // 右子树
        TreeNode right = build(mid+1, hi);
        node.left = left;
        node.right = right;
        if (mid == (len-1)/2) root = node;  //确定根节点的位置
        return node;
    }
}
