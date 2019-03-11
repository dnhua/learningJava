package sort;

public class QuickSort<T extends Comparable<T>> {
    public void partition(T[] nums, int l, int h) {
        int i = l;
        int j = h+1;
        T v = nums[l];
        while (i<=j) {
            while (nums[++i].compareTo(v)<0 && i!=h) ;
            while (nums[--j].compareTo(v)>0 && j!=l) ;
            //未完，待续
        }
    }
}
