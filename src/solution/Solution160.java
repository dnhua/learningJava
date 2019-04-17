package solution;

/**
 * 找出两个链表的交点
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
