package solution.top100;

/**
 * 238. Product of Array Except Self
 * Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
 *
 * Example:
 *
 * Input:  [1,2,3,4]
 * Output: [24,12,8,6]
 *
 * Note: Please solve it without division and in O(n).
 */
public class Solution238 {
    public int[] productExceptSelf(int[] nums) {
        //思路：题目要求不能用除法，那么我们可以使用两个临时数组保存左边的乘积和右边的乘积
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int[] ret = new int[n];
        left[0] = 1;
        right[n-1] = 1;
        //得到左乘积数组
        for (int i=1; i<n; i++) {
            left[i] = left[i-1] * nums[i-1];
        }
        //得到右乘积数组
        for (int i=n-2; i>=0; i--) {
            right[i] = right[i+1] * nums[i+1];
        }
        //计算结果数组
        for (int i=0; i<n; i++) {
            ret[i] = left[i] * right[i];
        }
        return ret;
    }
}
