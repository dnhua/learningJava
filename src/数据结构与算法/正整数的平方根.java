package 数据结构与算法;

public class 正整数的平方根 {
    public static void main(String[] args) {
        for (int i=0; i<100; i++) {
            System.out.println(i + ": " + sqrt(i));
        }
    }
    public static int sqrt(int y) {
        int low = 0, high = y;
        int ans = 0;
        while(low <= high) {
            int mid = (low + high) / 2;
            if (mid * mid <= y) {
                ans = mid;
                low = mid + 1;
            } else if(mid * mid > y) {
                high = mid - 1;
            }
        }
        return ans;
    }
}
