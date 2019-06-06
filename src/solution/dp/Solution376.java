package solution.dp;

/**
 * 最长摆动子序列
 * 376. Wiggle Subsequence (Medium)
 * https://leetcode.com/problems/wiggle-subsequence/
 * Input: [1,7,4,9,2,5]
 * Output: 6
 * The entire sequence is a wiggle sequence.
 *
 * Input: [1,17,5,10,13,15,10,5,16,8]
 * Output: 7
 * There are several subsequences that achieve this length. One is [1,17,10,13,10,16,8].
 *
 * Input: [1,2,3,4,5,6,7,8,9]
 * Output: 2
 */
public class Solution376 {
    //网上找的一种解法，很是巧妙
    public int wiggleMaxLength(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int n = nums.length;
        int down = 1, up = 1;
        //主循环，更新up and down
        for (int i=1; i<n; i++) {
            if (nums[i] > nums[i-1]) {//更新，up
                up = down + 1;
            } else if(nums[i] < nums[i-1]){//更新down
                down = up + 1;
            }
        }
        return Math.max(down, up);
    }
}
