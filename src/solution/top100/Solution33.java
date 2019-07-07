package solution.top100;

/**
 * 33. Search in Rotated Sorted Array
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 *
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 *
 * You are given a target value to search. If found in the array return its index,
 * otherwise return -1.
 *
 * You may assume no duplicate exists in the array.
 *
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * Example 1:
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 *
 * Example 2:
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 */
public class Solution33 {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] >= nums[l]) {  //左半边有序
                if (nums[l] <= target && target <= nums[mid])   //目标值在左半部分
                    r = mid - 1;
                else //目标值在右半部分
                    l = mid + 1;
            } else {    //右半边有序
                if (nums[mid] <= target && target <= nums[r])   //目标值在右半部分
                    l = mid + 1;
                else    //目标值在左半部分
                    r = mid - 1;
            }
        }
        return -1;
    }
}
