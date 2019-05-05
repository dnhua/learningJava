package solution.array;

/**
 * 一个数组元素在 [1, n] 之间，其中一个数被替换为另一个数，找出重复的数和丢失的数
 * 645. Set Mismatch (Easy)
 * Input: nums = [1,2,2,4]
 * Output: [2,3]
 */
public class Solution645 {
    public int[] findErrorNums(int[] nums) {
        for (int i=0; i<nums.length; i++) {
            while (nums[i] != i+1 && nums[nums[i]-1] != nums[i]) {
                swap(nums, nums[i]-1, i);
            }
        }
        for (int i=0; i<nums.length; i++) {
            if (nums[i] != i + 1) {
                return new int[]{nums[i], i + 1};
            }
        }
        return null;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
