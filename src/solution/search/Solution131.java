package solution.search;

import java.util.ArrayList;
import java.util.List;

/**
 * 分割字符串使得每个部分都是回文数
 * 131. Palindrome Partitioning (Medium)
 * https://leetcode.com/problems/palindrome-partitioning/
 * For example, given s = "aab",
 * Return
 *
 * [
 *   ["aa","b"],
 *   ["a","a","b"]
 * ]
 */
public class Solution131 {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if (s == null || s.length() == 0)
            return res;
        doPartition(s, res, new ArrayList<>());
        return res;
    }

    private void doPartition(String s, List<List<String>> res, List<String> partitions) {
        if (s.length() == 0) {
            res.add(new ArrayList<>(partitions));
            return ;
        }

        for (int i=0; i<s.length(); i++) {
            if (isPalindrome(s, 0, i)) {
                partitions.add(s.substring(0, i+1));
                doPartition(s.substring(i+1), res, partitions);
                partitions.remove(partitions.size()-1);
            }
        }
    }

    private boolean isPalindrome(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--))
                return false;
        }
        return true;
    }
}
