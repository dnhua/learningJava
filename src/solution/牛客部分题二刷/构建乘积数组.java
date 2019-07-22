package solution.牛客部分题二刷;

import org.junit.jupiter.api.Test;

public class 构建乘积数组 {
    public int[] multiply(int[] A) {
        int n = A.length;
        int[] B = new int[n];
        for (int i = 0, product = 1; i < n; product *= A[i], i++)       /* 从左往右累乘 */
            B[i] = product;
        for (int i = n - 1, product = 1; i >= 0; product *= A[i], i--)  /* 从右往左累乘 */
            B[i] *= product;
        return B;
    }
    @Test
    public void test() {
        int[] A = new int[] {1,2,3,4,5};
        int[] multiply = multiply(A);
        for (int num : multiply)
            System.out.println(num);
    }
}
