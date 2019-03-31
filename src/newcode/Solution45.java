package newcode;

import org.junit.jupiter.api.Test;

/**
 * 十进制 1 的总数
 */
public class Solution45 {
    public int NumberOf1Between1AndN_Solution(int n) {
        int res = 0;
        for (int i=1; i<=n; i++) {
            res += NumberOfN(i);
        }
        return res;
    }

    public int NumberOfN(int n) {
        int cnt = 0;
        while (n != 0) {
            n = n & (n-1);
            cnt++;
        }
        return cnt;
    }

    @Test
    public void test1() {
        Solution45 solution45 = new Solution45();
        int number = solution45.NumberOf1Between1AndN_Solution(5);
        System.out.println(number);
    }
}
