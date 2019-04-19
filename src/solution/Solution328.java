package solution;

/**
 * 链表元素按奇偶下标聚集
 */
public class Solution328 {
    public ListNode oddEvenList(ListNode head) {
        //sp case, head == null
        if (head == null)
            return head;
        //1.def odd node and even node
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;
        //2.major loop
        while (even != null && even.next != null) {
            odd.next = odd.next.next;
            odd = odd.next;
            even.next = even.next.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}
