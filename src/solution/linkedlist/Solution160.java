package solution.linkedlist;

/**
 * 234. Palindrome Linked List (Easy)
 *
 * 题目要求：以 O(1) 的空间复杂度来求解。
 *
 * 切成两半，把后半段反转，然后比较两半是否相等。
 *
 * public boolean isPalindrome(ListNode head) {
 *     if (head == null || head.next == null) return true;
 *     ListNode slow = head, fast = head.next;
 *     while (fast != null && fast.next != null) {
 *         slow = slow.next;
 *         fast = fast.next.next;
 *     }
 *     if (fast != null) slow = slow.next;  // 偶数节点，让 slow 指向下一个节点
 *     cut(head, slow);                     // 切成两个链表
 *     return isEqual(head, reverse(slow));
 * }
 *
 * private void cut(ListNode head, ListNode cutNode) {
 *     while (head.next != cutNode) {
 *         head = head.next;
 *     }
 *     head.next = null;
 * }
 *
 * private ListNode reverse(ListNode head) {
 *     ListNode newHead = null;
 *     while (head != null) {
 *         ListNode nextNode = head.next;
 *         head.next = newHead;
 *         newHead = head;
 *         head = nextNode;
 *     }
 *     return newHead;
 * }
 *
 * private boolean isEqual(ListNode l1, ListNode l2) {
 *     while (l1 != null && l2 != null) {
 *         if (l1.val != l2.val) return false;
 *         l1 = l1.next;
 *         l2 = l2.next;
 *     }
 *     return true;
 * }
 */
public class Solution160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //创建指针p1和p2分别指向headA和headB
        ListNode p1 = headA;
        ListNode p2 = headB;
        //while主循环,当p1 == p2时结束
        while (p1 != p2) {
            //如果p1到达A的末尾，则让他指向headB
            if (p1 == null)
                p1 = headB;
            else //否则，next
                p1 = p1.next;
            //p2同理
            if (p2 == null)
                p2 = headA;
            else //否则，next
                p2 = p2.next;
        }
        return p1;
    }
}
