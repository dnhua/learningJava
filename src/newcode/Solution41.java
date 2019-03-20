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

//    public ArrayList<Integer> GetLeastNumbers_Solution(int[] nums, int k) {
//        ArrayList<Integer> ret = new ArrayList<>();
//        if (k > nums.length || k <= 0)
//            return ret;
//        findKthSmallest(nums, k - 1);
//        /* findKthSmallest 会改变数组，使得前 k 个数都是最小的 k 个数 */
//        for (int i = 0; i < k; i++)
//            ret.add(nums[i]);
//        return ret;
//    }
//
//    public void findKthSmallest(int[] nums, int k) {
//        int l = 0, h = nums.length - 1;
//        while (l < h) {
//            int j = partition(nums, l, h);
//            if (j == k)
//                break;
//            if (j > k)
//                h = j - 1;
//            else
//                l = j + 1;
//        }
//    }
//
//    private int partition(int[] nums, int l, int h) {
//        int p = nums[l];     /* 切分元素 */
//        int i = l, j = h + 1;
//        while (true) {
//            while (i != h && nums[++i] < p) ;
//            while (j != l && nums[--j] > p) ;
//            if (i >= j)
//                break;
//            swap(nums, i, j);
//        }
//        swap(nums, l, j);
//        return j;
//    }
//
//    private void swap(int[] nums, int i, int j) {
//        int t = nums[i];
//        nums[i] = nums[j];
//        nums[j] = t;
//    }
