package sort;

public class Test {
    @org.junit.jupiter.api.Test
    public void selectionTest() {
        String[] nums = new String[]{"1","4","6","2","1"};
        String[] nums1 = new String[]{};
        Sort<String> sort = new Sort<>();
        sort.slection(nums);
        sort.slection(null);
        for (String s:nums) {
            System.out.println(s);
        }
    }

    @org.junit.jupiter.api.Test
    public void bubble() {
        String[] nums = new String[]{"1","4","6","2","1"};
        Sort<String> sort = new Sort<>();
        sort.bubble(nums);
        for (String s:nums) {
            System.out.println(s);
        }
    }
}
