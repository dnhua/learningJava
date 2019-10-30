package solution.newCode;

public class S4 {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        //使用快慢指针找到中间节点
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode last = slow.next;
        slow.next = null;
        ListNode pre = sortList(head);
        ListNode las = sortList(last);
        return merge(pre, las);
    }

    private ListNode merge(ListNode node1, ListNode node2) {
        ListNode pre = new ListNode(-1);
        ListNode p = pre;
        while (node1 != null && node2 != null) {
            if (node1.val < node2.val) {
                p.next = node1;
                p = p.next;
                node1 = node1.next;
            } else {
                p.next = node2;
                p = p.next;
                node2 = node2.next;
            }
        }
        if (node1 == null)
            p.next = node2;
        if (node2 == null)
            p.next = node1;
        return pre.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(5);
        ListNode tmp = head;
        head.next = new ListNode(3);
        head = head.next;
        head.next = new ListNode(7);
        S4 solution = new S4();
        solution.sortList(tmp);
    }
}
