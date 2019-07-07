package solution.top100;

/**
 * 581. Shortest Unsorted Continuous Subarray
 * https://leetcode.com/problems/shortest-unsorted-continuous-subarray/
 * Given an integer array, you need to find one continuous subarray that if you only sort
 * this subarray in ascending order, then the whole array will be sorted in ascending
 * order, too.
 *
 * You need to find the shortest such subarray and output its length.
 *
 * Example 1:
 *
 * Input: [2, 6, 4, 8, 10, 9, 15]
 * Output: 5
 * Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array
 * sorted in ascending order.
 */
public class Solution581 {
    public int findUnsortedSubarray(int[] nums) {
        //思路：双指针
        int n = nums.length;
        int beg = -1;
        int end = -2; // end is -2 防止已经有序的情况
        int min = nums[n-1]; // from right to left
        int max = nums[0];      // from left to right

        for(int i=0; i<n; i++)
        {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[n-1-i]);

            if(nums[i] < max)
                end = i;
            if(nums[n-1-i] > min)
                beg = n-1-i;
        }

        return end - beg + 1; // if array is already in ascending order, -2 - (-1) + 1 = 0
    }
}
