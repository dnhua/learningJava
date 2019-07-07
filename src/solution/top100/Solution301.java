package solution.top100;

import java.util.ArrayList;
import java.util.List;

/**
 * 301. Remove Invalid Parentheses
 * https://leetcode.com/problems/remove-invalid-parentheses/
 * Remove the minimum number of invalid parentheses in order to make the input string valid.
 * Return all possible results.
 *
 * Note: The input string may contain letters other than the parentheses ( and ).
 *
 * Example 1:
 *
 * Input: "()())()"
 * Output: ["()()()", "(())()"]
 *
 * Example 2:
 *
 * Input: "(a)())()"
 * Output: ["(a)()()", "(a())()"]
 *
 * Example 3:
 *
 * Input: ")("
 * Output: [""]
 */
public class Solution301 {
    List<String> ret = new ArrayList<>();
    public List<String> removeInvalidParentheses(String s) {
        //思路：网上看来的答案，很巧妙。左右括号都满足规则即是一个解
        remove(s, ')', 0);
        return ret;
    }

    public void remove(String s, char c, int last) {
        for (int i=0, cnt=0; i<s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == ')')
                cnt = s.charAt(i) == c ? cnt - 1 : cnt + 1;
            if (cnt >= 0) continue;
            for (int j=last; j<=i; j++) {
                if (s.charAt(j) == c && (j == last || s.charAt(j-1) != c))
                    remove(s.substring(0, j) + s.substring(j+1, s.length()), c, j);
            }
            return ;
        }
        StringBuilder stringBuilder = new StringBuilder(s);
        s = stringBuilder.reverse().toString();
        if (c == ')') {
            remove(s, '(', 0);
            return ;
        }
        ret.add(s);
    }

    public static void main(String[] args) {
        Solution301 solution301 = new Solution301();
        String s = "()())()";
        List<String> strings = solution301.removeInvalidParentheses(s);
            System.out.println(strings);
    }
}
