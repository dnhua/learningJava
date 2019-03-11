package sort;

public class MergeSort<T extends Comparable<T>> {
    T[] aux;
    public void up2Down(T[] nums) {
        aux = (T[]) new Comparable[nums.length];
        sort(nums, 0, nums.length-1);
    }

    public void down2Up(T[] nums) {
        int length = nums.length;
        aux = (T[]) new Comparable[length];
        for (int sz=1; sz<length; sz+=sz) {
            for (int l=0; l<length-sz; l+=sz+sz) {
                merge(nums, l, l+sz-1, Math.min(l+sz+sz-1, length-1));
            }
        }
    }

    protected void merge(T[] nums, int l, int m, int h) {
        int i = l;
        int j = m + 1;
        //拷贝数组

        for (int k=l; k<=h; k++) {  //这里要是小于等于h，而不是<=nums.length
            aux[k] = nums[k];
        }

        for(int k=l; k<=h; k++) {
            if (i>m) {  //左数组已经空了
                nums[k] = aux[j++];
            } else if (j>h) {   //右数组空了
                nums[k] = aux[i++];
            } else if (aux[i].compareTo(aux[j])<=0) {   //这里必须是小于等于以保证稳定性
                nums[k] = aux[i++];
            } else {
                nums[k] = aux[j++];
            }
        }
    }

    private void sort(T[] nums, int l, int h) {
        if (l>=h)   //l>=h作为返回条件
            return;
        int m = l + (h - l) / 2;
        sort(nums, l, m);
        sort(nums, m+1, h);
        merge(nums, l, m, h);
    }
}
