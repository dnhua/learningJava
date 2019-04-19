package solution;

/**
 * 分隔链表
 */
public class Solution725 {
    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode[] res = new ListNode[k];
        ListNode cur = root;
        //1.calculate root size
        int size = getSize(root);
        //2.sp case, size <= k
        if (size <= k) {
            int i = 0;
            while (cur != null) {
                res[i++] = cur;
                ListNode next = cur.next;
                cur.next = null;
                cur = next;
            }
            return res;
        }
        //3.calculate mod and N
        int mod = size % k;
        int N = size / k;
        //4.major loop
        for (int i=0; i<k; i++) {
            int n = mod > 0 ? N + 1 : N;    //get every element size
            res[i] = cur;
            while (n > 1) {
                cur = cur.next;
                n--;
            }
            ListNode next = cur.next;
            cur.next = null;
            cur = next;
            mod--;
        }
        return res;
    }

    public int getSize(ListNode head) {
        int cnt = 0;
        while (head != null) {
            cnt++;
            head = head.next;
        }
        return cnt;
    }
}
