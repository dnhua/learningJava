package solution.linkedlist;

/**
 * 从有序链表中删除重复节点
 */
public class Solution83 {
    /**
     * 循环法
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode res = head;
        while (head != null && head.next != null) {
            while (head != null && head.next != null && head.val == head.next.val) {
                head.next = head.next.next;
            }
            head = head.next;
        }
        return res;
    }

    /**
     * 递归法
     * @param head
     * @return
     */
    public ListNode deleteDuplicates2(ListNode head) {
        if (head == null || head.next == null) return head;
        head.next = deleteDuplicates(head.next);
        return head.val == head.next.val ? head.next : head;
    }
}
