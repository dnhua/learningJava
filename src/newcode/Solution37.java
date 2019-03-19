package newcode;

public class Solution37 {
    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null)
            return null;
        //1.在每个节点后面增加一个节点
        RandomListNode cur = pHead;
        while (cur !=null) {
            RandomListNode clone = new RandomListNode(cur.label);
            clone.next = cur.next;
            cur.next = clone;
            cur = clone.next;
        }
        //2.为clone节点增加random指针
        cur = pHead;
        while (cur != null) {
            if (cur.random!=null)   //这里不要忘了
                cur.next.random = cur.random.next;
            cur = cur.next.next;
        }
        //3.拆分
        cur = pHead;
        RandomListNode pCloneHead = pHead.next;
        while (cur.next != null) {
            RandomListNode next = cur.next;
            cur.next = next.next;
            cur = next;
        }
        return pCloneHead;
    }

    public class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;
        RandomListNode(int label) {
            this.label = label;
        }
    }
}
