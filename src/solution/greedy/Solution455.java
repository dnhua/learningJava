package solution.greedy;

import java.util.Arrays;

/**
 * 分配饼干
 * 455. Assign Cookies (Easy)
 *
 * Input: [1,2], [1,2,3]
 * Output: 2
 *
 * Explanation: You have 2 children and 3 cookies. The greed factors of 2 children are 1, 2.
 * You have 3 cookies and their sizes are big enough to gratify all of the children,
 * You need to output 2.
 */
public class Solution455 {
    public int findContentChildren(int[] g, int[] s) {
        int gi = 0, si = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        while (gi < g.length && si < s.length) {
            if (g[gi] <= s[si])
                gi++;
            si++;
        }
        return gi;
    }
}