package solution.search;

import java.util.ArrayList;
import java.util.List;

/**
 * 数字键盘组合
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 */
class Solution17 {
    private static final String[] KEYS = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0)
            return res;
        combinations(new StringBuilder(), res, digits);
        return res;
    }

    private void combinations(StringBuilder sbPrefix, List<String> res, String digits) {
        if (sbPrefix.length() == digits.length()) {
            res.add(sbPrefix.toString());
            return;
        }
        int curDigit = digits.charAt(sbPrefix.length()) - '0';
        String letters = KEYS[curDigit];
        for (char c : letters.toCharArray()) {
            sbPrefix.append(c);
            combinations(sbPrefix, res, digits);
            sbPrefix.deleteCharAt(sbPrefix.length()-1);
        }
    }
}