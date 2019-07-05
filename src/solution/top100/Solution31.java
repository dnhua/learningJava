package solution.top100;

import java.util.Arrays;

/**
 * 31. Next Permutation
 * https://leetcode.com/problems/next-permutation/
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 *
 * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
 *
 * The replacement must be in-place and use only constant extra memory.
 *
 * Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 *
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 */
public class Solution31 {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0)
            return ;
        //第一次遍历找到第一个nums[i-1] < nums[i]的位置
        int p = nums.length - 1;
        for (int i=nums.length-1; i >= 0; i--) {
            if(i == 0) { //意味着所有的元素都是降序排列的
                Arrays.sort(nums);
                return;
            }
            if (nums[i-1] < nums[i]) {
                p = i-1;
                break;
            }
        }

        //第二次遍历找到第一个大于nums[p]的数，并交换
        for (int i=nums.length-1; i>p; i--) {
            if (nums[i] > nums[p]) {
                //交换
                int tem = nums[i];
                nums[i] = nums[p];
                nums[p] = tem;

                break;
            }
        }

        Arrays.sort(nums, p+1, nums.length);
    }
}
