package solution.top100;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 23. Merge k Sorted Lists
 * https://leetcode.com/problems/merge-k-sorted-lists/
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 *
 * Example:
 *
 * Input:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * Output: 1->1->2->3->4->4->5->6
 */
public class Solution23 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0)
            return null;
        List<ListNode> list = new ArrayList<>(); //转为List方便操作
        list.addAll(Arrays.asList(lists));
        //去掉所有null
        // System.out.println(list.size());
        for (int i=0; i<list.size(); i++) {
            if (list.get(i) == null) {
                list.remove(i);
                i--;    //这里一定要i--，因为每次remove，list.size()都在变化
            }
        }
        // System.out.println(list.size());
        int k = lists.length;
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        while (!list.isEmpty()) {
            //找到最小的一个
            ListNode tem = list.get(0);
            int flag = 0;
            for (int i=1; i<list.size(); i++) {
                if (list.get(i).val < tem.val) {
                    tem = list.get(i);
                    flag = i;
                }
            }
            cur.next = list.get(flag);
            cur = cur.next;
            list.set(flag, list.get(flag).next);
            if (list.get(flag) == null)
                list.remove(flag);
        }
        return head.next;
    }

    public static void main(String[] args) {
        Solution23 solution23 = new Solution23();
        ListNode[] lists = new ListNode[2];
        ListNode l1 = new ListNode(1);
        lists[0] = null;
        lists[1] = l1;
        solution23.mergeKLists(lists);
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
