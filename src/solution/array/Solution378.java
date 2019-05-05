package solution.array;

import java.util.PriorityQueue;

/**
 * 有序矩阵的 Kth Element
 * 378. Kth Smallest Element in a Sorted Matrix ((Medium))
 *
 * matrix = [
 *   [ 1,  5,  9],
 *   [10, 11, 13],
 *   [12, 13, 15]
 * ],
 * k = 8,
 *
 * return 13.
 */
public class Solution378 {
    public int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length, n = matrix[0].length;
        PriorityQueue<Tuple> pq = new PriorityQueue<Tuple>();
        //以第一行为基础构建一个小根堆
        for (int i=0; i<n; i++)
            pq.add(new Tuple(0, i, matrix[0][i]));
        //删除最小的k-1个元素，此时根就是第k大的
        for (int i=0; i<k-1; i++) {
            Tuple poll = pq.poll();
            if (poll.x == m-1) continue;
            pq.add(new Tuple(poll.x+1, poll.y, matrix[poll.x+1][poll.y]));
        }
        return pq.poll().val;
    }

    class Tuple implements Comparable<Tuple> {
        int x,y,val;
        public Tuple(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
        @Override
        public int compareTo(Tuple o) {
            return this.val - o.val;
        }
    }
}
