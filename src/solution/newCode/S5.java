package solution.newCode;

/**
 * 使用插入排序对链表进行排序。
 */
public class S5 {
    public ListNode insertionSortList(ListNode head) {
        //哑节点
        ListNode dumy = new ListNode(Integer.MIN_VALUE);
        ListNode cur = head;
        ListNode pre = dumy;
        while (cur != null) {
            //保存当前节点下一个节点
            ListNode next = cur.next;
            pre = dumy;
            //寻找当前节点正确位置的一个节点
            while (pre.next != null && pre.next.val < cur.val) {
                pre = pre.next;
            }
            //将当前节点加入新链表中
            cur.next = pre.next;
            pre.next = cur;
            //处理下一个节点
            cur = next;
        }
        return dumy.next;
    }
}
