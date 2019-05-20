package solution.greedy;

/**
 * 判断是否为子序列
 * 392. Is Subsequence (Medium)
 *
 * s = "abc", t = "ahbgdc"
 * Return true.
 */
public class Solution329 {
    public boolean isSubsequence(String s, String t) {
        int index = -1;
        for (char c : s.toCharArray()) {
            index = t.indexOf(c, index + 1);
            if (index == -1) {
                return false;
            }
        }
        return true;
    }
}
