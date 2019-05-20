package solution.greedy;

/**
 * 子数组最大的和
 * 53. Maximum Subarray (Easy)
 *
 * For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
 * the contiguous subarray [4,-1,2,1] has the largest sum = 6.
 */
public class Solution9 {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length==0)
            return 0;
        int cursum = nums[0];
        int maxsum = cursum;
        for (int i=1; i<nums.length; i++) {
            cursum = cursum > 0 ? cursum+nums[i] : nums[i];
            maxsum = Math.max(maxsum, cursum);
        }
        return maxsum;
    }
}
