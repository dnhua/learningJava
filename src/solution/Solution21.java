package solution;

/**
 * 归并两个有序的链表
 */
public class Solution21 {
    /**
     * 循环法
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode res;
        //如果l1或者l2有一个是null
        if (l1 == null || l2 == null)
            return l1 == null ? l2 : l1;
        //新建result节点，初始化为l1与l2较小的那个值
        if (l1.val < l2.val) {
            res = new ListNode(l1.val);
            l1 = l1.next;
        } else {
            res = new ListNode(l2.val);
            l2 = l2.next;
        }
        //新建一个指针指向res的头节点
        ListNode p = res;

        //主循环,当l1和l2都为null时结束
        while (l1 != null || l2 != null) {
            //特殊情况处理,当其中一个为null时
            if (l1 == null) {
                while(l2!=null) {
                    p.next = new ListNode(l2.val);
                    p = p.next;
                    l2 = l2.next;
                }
                return res;
            }

            if (l2 == null) {
                while(l1!=null) {
                    p.next = new ListNode(l1.val);
                    p = p.next;
                    l1 = l1.next;
                }
                return res;
            }

            //进入正常情况,判断l1和l2的大小
            if (l1.val < l2.val) {
                p.next = new ListNode(l1.val);
                p = p.next;
                l1 = l1.next;
            } else {
                p.next = new ListNode(l2.val);
                p = p.next;
                l2 = l2.next;
            }
        }
        return res;
    }

    /**
     * 递归法
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}
