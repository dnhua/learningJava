package newcode;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * 输入n个整数，找出其中最小的K个数。
 * 例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 */
public class Solution41 {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i=0; i<input.length-1; i++) {
            if (i < k)
                maxHeap.add(input[i]);
            else {
                if (input[i] < maxHeap.peek()) {
                    maxHeap.remove();
                    maxHeap.add(input[i]);
                }
            }
        }
        while (maxHeap.size()!=0) {
            res.add(maxHeap.remove());
        }
        return res;
    }
}
