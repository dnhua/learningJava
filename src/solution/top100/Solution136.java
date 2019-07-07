package solution.top100;

/**
 * 136. Single Number
 * Given a non-empty array of integers, every element appears twice except for one. Find that single one.
 *
 * Note:
 *
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 *
 * Example 1:
 *
 * Input: [2,2,1]
 * Output: 1
 *
 * Example 2:
 *
 * Input: [4,1,2,1,2]
 * Output: 4
 */
public class Solution136 {
    public int singleNumber(int[] nums) {
        //思路：异或，0和任何数异或都是原数，同数异或得到零
        int ret = 0;
        for (int i=0; i<nums.length; i++) {
            ret = ret ^ nums[i];
        }
        return ret;
    }
}
