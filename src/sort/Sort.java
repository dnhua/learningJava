package sort;

public class Sort<T extends Comparable<T>>  {
    public void slection(T[] nums) {
        if (nums==null)
            return;
        int length = nums.length;
        for (int i=0; i<length-1; i++) {
            int min = i;    //注意这里要存位置
            for (int j=i+1; j<length; j++) {
                if (nums[j].compareTo(nums[min])<0) {
                    min = j;    //这里一定不要忘了
                }
            }
            swap(nums, i, min); //要在循环外进行交换赋值
        }
    }

    public void bubble(T[] nums) {
        if (nums==null)
            return;
        int length = nums.length;
        boolean hasSorted = false;
        for (int i=length-1; i>0 && !hasSorted; i--) {
            hasSorted = true;
            for (int j=0; j<i; j++) {
                if (nums[j+1].compareTo(nums[j])<0) {
                    hasSorted = false;
                    swap(nums, j, j+1);
                }
            }
        }
    }

    public void isertion(T[] nums) {
        if (nums==null)
            return;
        int length = nums.length;
        for
    }

    private void swap(T[] nums, int i, int j) {
        T tem = nums[i];
        nums[i] = nums[j];
        nums[j] = tem;
    }
}
