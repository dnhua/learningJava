package 数据结构与算法;

import java.util.Random;

public class 洗牌算法 {
    public static void main(String[] args) {
        int[] nums = shuffle(5);
        for (int num : nums) {
            System.out.println(num);
        }
    }

    public static int[] shuffle(int n) {
        int[] X = new int[n];
        for (int i=0; i<n; i++) {
            X[i] = i;
        }
        Random rand = new Random();
        for (int i=0; i<n; i++) {
            //Random rand=new Random(); rand.nextInt(max - min + 1) + min；
            int t = rand.nextInt(n - i) + i;
            swap(X, i, t);
        }
        return X;
    }

    public static void swap(int[] nums, int i, int j) {
        int tem = nums[i];
        nums[i] = nums[j];
        nums[j] = tem;
    }
}
