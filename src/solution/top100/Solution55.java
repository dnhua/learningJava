package solution.top100;

/**
 * 55. Jump Game
 * https://leetcode.com/problems/jump-game/
 * Example 1:
 * Input: [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 */
public class Solution55 {
    public boolean canJump(int[] nums) {
        //思路：顺序遍历，挨个标记
        boolean[] canArravied = new boolean[nums.length];
        canArravied[0] = true;
        for (int i=0; i<nums.length; i++) {
            int num = nums[i];
            if (canArravied[i] == true) {
                for (int j=i+1; j<=i+num; j++) {
                    if(j < nums.length) canArravied[j] = true;
                }
            }
        }
        return canArravied[nums.length-1] == true;
    }
}
