package sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class QuickSort<T extends Comparable<T>> {
    public void sort(T[] nums) {
        shuffle(nums);
        sort(nums, 0, nums.length - 1);
    }

    private void sort(T[] nums, int l, int h) {
        if (h <= l)
            return;
        int j = partition(nums, l, h);
        sort(nums, l, j - 1);
        sort(nums, j + 1, h);
    }

    private void shuffle(T[] nums) {
        List<Comparable> list = Arrays.asList(nums);
        Collections.shuffle(list);
        list.toArray(nums);
    }

    public int partition(T[] nums, int l, int h) {
        int i = l;
        int j = h+1;
        T v = nums[l];
        while (true) {
            while (nums[++i].compareTo(v)<0 && i!=h) ;
            while (nums[--j].compareTo(v)>0 && j!=l) ;
            //已经找到合适的i和j的位置
            if (i>=j)   //这里一定要是i>=j
                break;
            swap(nums, i, j);
        }
        swap(nums, l, j);
        return j;
    }

    private void swap(T[] nums, int i, int j) {
        T tem = nums[i];
        nums[i] = nums[j];
        nums[j] = tem;
    }
}
