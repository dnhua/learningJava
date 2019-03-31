package newcode;

import org.junit.jupiter.api.Test;

/**
 * 十进制的1的总数
 */
public class Solution46 {
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
            cnt = n%10 == 1 ? cnt+1 : cnt;
            n /= 10;
        }
        return cnt;
    }

    @Test
    public void test1() {
        Solution46 solution46 = new Solution46();
        int number = solution46.NumberOf1Between1AndN_Solution(5);
        System.out.println(number);
    }
}
