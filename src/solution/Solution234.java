package solution;

/**
 * 回文链表
 */
public class Solution234 {
    public boolean isPalindrome(ListNode head) {
        //1.特殊情况
        if (head == null || head.next == null) return true;
        //2.通过快慢指针进行奇偶性判断
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast != null) slow = slow.next; //如果是偶,slow还需要往后移动一位
        //3.切分为两部分
        cut(head, slow);
        //4.判断是否相等
        return isEqual(head, reverse(slow));
    }

    public void cut(ListNode l1, ListNode l2) {
        while (l1.next != l2) {
            l1 = l1.next;
        }
        l1.next = null;
    }

    public ListNode reverse(ListNode head) {
        ListNode prev = new ListNode(-1);
        while (head != null) {
            //保存next节点
            ListNode next = head.next;
            head.next = prev.next;
            prev.next = head;
            head = next;
        }
        return prev.next;
    }

    public boolean isEqual(ListNode l1, ListNode l2) {
        while (l1 != null && l2 != null) {
            if (l1.val != l2.val)
                return false;
            l1 = l1.next;
            l2 = l2.next;
        }
        return true;
    }
}
