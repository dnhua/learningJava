package solution.array;

/**
 * Beautiful Arrangement II
 * 题目描述：数组元素为 1~n 的整数，要求构建数组，使得相邻元素的差值不相同的个数为 k。
 *
 * 让前 k+1 个元素构建出 k 个不相同的差值，序列为：1  k+1  2  k  3  k-1  ...  k/2  k/2+1.
 */
public class Solution667 {
    public int[] constructArray(int n, int k) {
        int[] ans = new int[n];
        int c = 0;
        for (int v = 1; v < n-k; v++) {
            ans[c++] = v;
        }
        for (int i = 0; i <= k; i++) {
            ans[c++] = (i%2 == 0) ? (n-k + i/2) : (n - i/2);
        }
        return ans;
    }
}
