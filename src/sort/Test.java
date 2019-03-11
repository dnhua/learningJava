package sort;

public class Test {
    String[] nums = new String[]{"1","4","6","2","1"};
    Sort<String> sort = new Sort<>();

    @org.junit.jupiter.api.Test
    public void selectionTest() {
        sort.slection(nums);
        sort.slection(null);
        for (String s:nums) {
            System.out.println(s);
        }
    }

    @org.junit.jupiter.api.Test
    public void bubbleTest() {
        sort.bubble(nums);
        for (String s:nums) {
            System.out.println(s);
        }
    }

    @org.junit.jupiter.api.Test
    public void insertionTest() {
        sort.isertion(nums);
        for (String s:nums) {
            System.out.println(s);
        }
    }

    @org.junit.jupiter.api.Test
    public void shellTest() {
        System.out.println("shell 排序");
        sort.shell(nums);
        for (String s:nums) {
            System.out.println(s);
        }
    }
}
