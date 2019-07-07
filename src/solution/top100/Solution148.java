package solution.top100;
import java.util.PriorityQueue;

/**
 * 148. Sort List
 * https://leetcode.com/problems/sort-list/
 * Sort a linked list in O(n log n) time using constant space complexity.
 *
 * Example 1:
 *
 * Input: 4->2->1->3
 * Output: 1->2->3->4
 *
 * Example 2:
 *
 * Input: -1->5->3->4->0
 * Output: -1->0->3->4->5
 */
public class Solution148 {
    public ListNode sortList(ListNode head) {
        //思路：全部放到小顶堆里
        ListNode cur = head;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        while (cur != null) {
            pq.add(cur.val);
            cur = cur.next;
        }
        cur = head;
        while (!pq.isEmpty()) {
            int val = pq.remove();
            cur.val = val;
            cur = cur.next;
        }
        return head;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }



}
