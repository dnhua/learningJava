package solution.array;

/**
 * 把数组中的 0 移到末尾
 * For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].
 */
public class Solution283 {
    public void moveZeroes(int[] nums) {
        //先把所有的非零元素赋值到合适的位置
        int idx = 0;
        for (int num : nums) {
            if (num != 0)
                nums[idx++] = num;
        }
        //再把零元素放到最后
        while (idx < nums.length) {
            nums[idx++] = 0;
        }
    }
}
