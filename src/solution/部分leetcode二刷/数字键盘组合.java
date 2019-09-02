package solution.部分leetcode二刷;

import java.util.LinkedList;
import java.util.List;

public class 数字键盘组合 {
    private static final String[] KEYS = {"", "",
            "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> ret = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        if (digits == null || digits.length() == 0) {
            return ret;
        }
        dfs(ret, sb, digits);
        return ret;
    }

    public void dfs(List<String> ret, StringBuilder sb, String digits) {
        if (sb.length() == digits.length()) {
            ret.add(sb.toString());
            return ;
        }
        int idx = digits.charAt(sb.length()) - '0';
        String s = KEYS[idx];
        //dfs
        for (char c : s.toCharArray()) {
            sb.append(c);
            dfs(ret, sb, digits);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
