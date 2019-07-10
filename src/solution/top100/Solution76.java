package solution.top100;

/**
 * 76. Minimum Window Substring
 * https://leetcode.com/problems/minimum-window-substring/
 * 76. Minimum Window Substring
 * Hard
 * Given a string S and a string T, find the minimum window in S which will contain all
 * the characters in T in complexity O(n).
 * Example:
 * Input: S = "ADOBECODEBANC", T = "ABC"
 * Output: "BANC"
 */
public class Solution76 {
    public String minWindow(String s, String t) {
        //思路：双指针法，首先用ta统计String t字符出现的次数
        int[] ta = new int[128];
        int[] sa = new int[128];
        String ret = "";

        //统计t中字符出现的次数
        for (char c : t.toCharArray()) {
            ta[c]++;
        }

        int count = 0, start = 0, end = 0;
        int min = Integer.MAX_VALUE;
        while (end < s.length()) {
            if (ta[s.charAt(end)] != 0) {   //如果ta中包含这个字符
                if (sa[s.charAt(end)] < ta[s.charAt(end)]) {    //并且sa中字符的数量比ta中少，也就是没有完全ba这个字符匹配完
                    count++;
                }
                sa[s.charAt(end)]++;
            }
            if (count == t.length()) {  //如果count已经等于t的长度了，那表明已经匹配完了
                //这个时候考虑移动start以减小窗口的长度,如果start位置的字符ta中数量为零或者ta中的数量比较少，那么可以放心的移动start
                while (ta[s.charAt(start)] == 0 || sa[s.charAt(start)] > ta[s.charAt(start)]) {
                    if (sa[s.charAt(start)] > ta[s.charAt(start)]) {
                        sa[s.charAt(start)]--;
                    }
                    start++;
                }
                if (end - start + 1 < min ) {
                    min = end - start + 1;
                    ret = s.substring(start, end + 1);
                }
            }
            end++;
        }
        return ret;
    }
}
