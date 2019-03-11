package sort;

import org.junit.jupiter.api.Test;

class MergeSortTest {
    String[] nums = new String[]{"1","4","6","2","1"};
    @Test
    void test1() {
        MergeSort sort = new MergeSort();
        sort.up2Down(nums);
        for (String s:nums) {
            System.out.println(s);
        }
    }
    @Test
    void test2() {
        MergeSort sort = new MergeSort();
        sort.down2Up(nums);
        for (String s:nums) {
            System.out.println(s);
        }
    }
}