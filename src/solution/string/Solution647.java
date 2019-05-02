package solution.string;

/**
 * 回文子字符串个数
 * 647. Palindromic Substrings (Medium)
 *
 * Input: "aaa"
 * Output: 6
 * Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
 *
 * 从字符串的某一位开始，尝试着去扩展子字符串。
 */
public class Solution647 {
    int cnt = 0;
    public int countSubstrings(String s) {
        for (int i=0; i<s.length(); i++) {
            extendsSubstring(s, i, i);
            extendsSubstring(s, i, i+1);
        }
        return cnt;
    }

    public void extendsSubstring(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
            cnt++;
        }
    }
}
