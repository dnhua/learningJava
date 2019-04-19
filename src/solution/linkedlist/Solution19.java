package solution.linkedlist;

/**
 * 删除链表的倒数第 n 个节点
 */
public class Solution19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //使用p1来保存正向第n个节点,p2来保存反向第n个节点
        ListNode p1 = head;
        //while循环找到正向n+1的位置
        while (n-- > 0) {
            p1 = p1.next;
        }
        //特殊情况,删除的是第一个元素，也就是倒数链表长度个
        if (p1 == null)
            return head.next;
        ListNode p2 = head;
        //while循环找到逆向n-1的位置
        while (p1.next != null) {
            p2 = p2.next;
            p1 = p1.next;
        }
        p2.next = p2.next.next;
        return head;
    }
}
