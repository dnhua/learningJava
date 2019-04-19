package solution.linkedlist;

/**
 * 链表反转
 */
public class Solution206 {
    /**
     * 头插法
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode prev = new ListNode(-1);   //使用prev.next表示前驱节点
        ListNode next = null;
        while (head != null) {
            next = head.next;   //保存next节点
            head.next = prev.next;  //让head的下一个节点连接到head.next
            prev.next = head;   //更新prev.next
            head = next;    //更新head
        }
        return prev.next;
    }

    /**
     * 递归法
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        ListNode newHead = reverseList(next);
        next.next = head;
        head.next = null;
        return newHead;
    }
}
