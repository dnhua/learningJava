package solution.dp;

/**
 * 强盗在环形街区抢劫
 */
public class Solution213 {
    public int rob(int[] nums) {
        if (nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];
        int ret = Math.max(rob(nums, 0, nums.length-1), rob(nums, 1, nums.length));
        return ret;
    }

    public int rob(int[] nums, int left, int right) {
        int n_1 = 0, n_2 = 0;
        for (int i=left; i<right; i++) {
            int cur = Math.max(n_1, n_2+nums[i]);
            n_2 = n_1;
            n_1 = cur;
        }
        return n_1;
    }
}
