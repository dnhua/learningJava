package solution.sort;

/**
 * 1. 按颜色进行排序
 *
 * 75. Sort Colors (Medium)
 *
 * Input: [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 *
 * 题目描述：只有 0/1/2 三种颜色。
 */
public class Solution75 {
    class Solution {
        public void sortColors(int[] nums) {
            int zero = -1, one = 0, two = nums.length;
            while (one < two) {
                if (nums[one] == 0) {
                    swap(nums, ++zero, one++);
                } else if (nums[one] == 2) {
                    swap(nums, --two, one);
                } else {
                    one++;
                }
            }
        }

        public void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}
