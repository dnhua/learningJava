package newcode;

/**
 * 链表中倒数第 K 个结点
 */


public class Solution22 {
    public ListNode FindKthToTail(ListNode head,int k) {
        //特殊情况判断
        if (head == null)
            return null;
        ListNode p1 = head;
        ListNode p2 = head;
        while (p1!=null && k-->0) {     //这句话要体会下
            p1 = p1.next;
        }
        if (k>0)
            return null;
        while (p1!=null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }

    private class ListNode {
        int val;
        ListNode next = null;
        ListNode(int val) {
            this.val = val;
        }
    }
}
