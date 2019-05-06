package solution.array;

/**
 * 找出数组中重复的数，数组值在 [1, n] 之间
 * 要求不能修改数组，也不能使用额外的空间。
 */
public class Solution287 {
    public int findDuplicate(int[] nums) {
        //二分搜索，统计所有小于等于mid数字的个数
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            int cnt = 0;
            //统计小于等于mid数字的个数
            for (int num : nums)
                if (num <= mid) cnt++;
            if (cnt > mid) hi = mid - 1;
            else lo = mid + 1;
        }
        return lo;
    }

    public int findDuplicate2(int[] nums) {
        int slow = nums[0], fast = nums[nums[0]];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        fast = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
