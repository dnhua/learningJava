package solution.linkedlist;

/**
 * 交换链表中的相邻结点
 */
public class Solution24 {
    public ListNode swapPairs(ListNode head) {
        //新建一个node节点
        ListNode node = new ListNode(-1);
        node.next = head;   //作为返回值
        //初始化prev节点为node节点
        ListNode prev = node;
        //主循环
        while (prev.next != null && prev.next.next!=null) {
            //初始化l1,l2,next节点
            ListNode l1 = prev.next;
            ListNode l2 = prev.next.next;
            ListNode next = l2.next;
            //反转链表
            l1.next = next;
            l2.next = l1;
            //恢复
            prev.next = l2;
            prev = l1;
        }
        return node.next;
    }
}
