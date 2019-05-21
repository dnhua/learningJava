package solution.binarySearch;

/**
 * 旋转数组的最小数字
 * 153. Find Minimum in Rotated Sorted Array (Medium)
 *
 * Input: [3,4,5,1,2],
 * Output: 1
 */
public class Solution153 {
    public int findMin(int[] nums) {
        int l = 0, h = nums.length - 1;
        while (l < h) {
            int m = l + (h - l) / 2;
            if (nums[m] <= nums[h]) {
                h = m;
            } else {
                l = m + 1;
            }
        }
        return nums[l];
    }
}
