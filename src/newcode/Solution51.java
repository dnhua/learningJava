package newcode;

import org.junit.jupiter.api.Test;

/**
 * 丑数
 * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，
 * 但14不是，因为它包含质因子7。 习惯上我们把1当做是第一个丑数。求按从
 * 小到大的顺序的第N个丑数。
 */
public class Solution51 {
    public int GetUglyNumber_Solution(int index) {
        if (index <= 6)
            return index;
        int index2 = 0, index3 = 0, index5 = 0;
        int[] dp = new int[index];
        dp[0] = 1;
        for (int i=1; i<index; i++) {
            int next2=dp[index2]*2, next3=dp[index3]*3, next5=dp[index5]*5;
            dp[i] = Math.min(next2, Math.min(next3, next5));    //这里比较重要
            if (dp[i]==next2)
                index2++;
            if (dp[i]==next3)
                index3++;
            if (dp[i]==next5)
                index5++;
        }
        return dp[index-1];
    }

    @Test
    public void test() {
        int uglyNumber = GetUglyNumber_Solution(8);
        System.out.println(uglyNumber);
    }
}
