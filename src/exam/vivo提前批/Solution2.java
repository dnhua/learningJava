package exam.vivo提前批;

/**
 * vivo2019提前批笔试第二题：
 * 将链表m到n范围内的链表反转
 */
public class Solution2 {
    public static void solution(ListNode head, int m, int n) {
        if (head == null)
            return;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = null;
        ListNode start = head;
        for (int i=1; i<m; i++) {
            prev = start;
            start = start.next;
        }

        for (int i=m; i<n; i++) {
            ListNode temp = start.next;
            start.next = temp.next;
            temp.next = prev.next;
            prev.next = temp;
        }

        while (dummy.next!=null) {
            System.out.println(dummy.next.val+" ");
            dummy.next = dummy.next.next;
        }
    }

    private static class ListNode {
        int val;
        ListNode next = null;
        ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        //测试
    }
}
