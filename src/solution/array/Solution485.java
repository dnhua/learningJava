package solution.array;

/**
 * 找出数组中最长的连续 1
 */
public class Solution485 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0, cur = 0;
        for (int i=0; i<nums.length; i++) {
            if (nums[i] == 1)
                cur++;
            else {
                max = Math.max(cur, max);
                cur = 0;
            }

            if (i == nums.length-1) {
                max = Math.max(cur, max);
            }
        }
        return max;
    }
}
