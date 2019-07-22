package solution.牛客部分题二刷;

import org.junit.jupiter.api.Test;

public class 正则表达式匹配 {
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true;
        for (int j=1; j<=p.length(); j++) {
            dp[0][j] = j > 1 && p.charAt(j-1) == '*' && dp[0][j-2];
        }

        for (int i=1; i<=s.length(); i++) {
            for (int j=1; j<=p.length(); j++) {
                if (p.charAt(j-1) != '*') {
                    dp[i][j] = (s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '.')
                            && dp[i-1][j-1];    //这个条件不要忘了
                } else {
                    dp[i][j] = (j>1 && dp[i][j-2]) || ((s.charAt(i-1) == p.charAt(j-2) || p.charAt(j-2) == '.')
                            && dp[i-1][j]);     //这个条件不要忘了
                }
            }
        }

        return dp[s.length()][p.length()];
    }
    @Test
    public void test() {
        boolean match = isMatch("a", "a.");
        System.out.println(match);
    }
}
