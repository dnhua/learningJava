package newcode;

/**
 * 数字在排序数组中出现的次数
 */
public class Solution55 {
    /**
     * 直接法，暴力求解
     * @param array
     * @param k
     * @return
     */
    public int GetNumberOfK(int [] array , int k) {
        int cnt = 0;
        for (int i=0; i<array.length; i++) {
            if (array[i] == k)
                cnt++;
        }
        return cnt;
    }

    /**
     * 基于二分查找方法
     * @param nums
     * @param K
     * @return
     */
    public int GetNumberOfK2(int[] nums, int K) {
        int first = binarySearch(nums, K);
        int last = binarySearch(nums, K + 1);
        return (first == nums.length || nums[first] != K) ? 0 : last - first;
    }

    private int binarySearch(int[] nums, int K) {
        int l = 0, h = nums.length;
        while (l < h) {
            int m = l + (h - l) / 2;
            if (nums[m] >= K)
                h = m;
            else
                l = m + 1;
        }
        return l;
    }
}
