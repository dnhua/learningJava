package sort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuickSortTest {
    private String[] nums = new String[]{"3","1","6","2","5","8","4","7"};
    private QuickSort sort = new QuickSort();
    @Test
    void partition() {
        sort.partition(nums, 0, nums.length-1);
        for (String num : nums) {
            System.out.printf("%s ", num);
        }
        System.out.println();
    }

    @Test
    void sort() {
        sort.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            String num = nums[i];
            System.out.printf("%s ", num);
        }
    }
}