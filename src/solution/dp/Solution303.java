package solution.dp;

/**
 * 数组区间和
 * Given nums = [-2, 0, 3, -5, 2, -1]
 *
 * sumRange(0, 2) -> 1
 * sumRange(2, 5) -> -1
 * sumRange(0, 5) -> -3
 *
 * 求区间 i ~ j 的和，可以转换为 sum[j + 1] - sum[i]，其中 sum[i] 为 0 ~ i - 1 的和。
 */
public class Solution303 {
    private int[] sums;

    public Solution303(int[] nums) {
        sums = new int[nums.length + 1];
        for (int i = 1; i <= nums.length; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }
    }

    public int sumRange(int i, int j) {
        return sums[j + 1] - sums[i];
    }
}
