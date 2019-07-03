package solution.top100;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 32. Longest Valid Parentheses
 * https://leetcode.com/problems/longest-valid-parentheses/
 */
public class Solution32 {
    public int longestValidParentheses(String s) {
        //思路：用栈来保存，左括号压入，右括号弹出
        if (s == null || s.length() == 0)
            return 0;
        Deque<Integer> stack = new LinkedList<>();
        int l = 0;
        int res = 0;
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) == '(') {
                //左括号直接压入栈中
                stack.push(i);
            } else {
                //右括号的情况
                if (stack.isEmpty()) {  //如果栈是空的
                    l = i + 1;
                } else {
                    stack.pop();    //右括号出栈
                    //根据此时栈是否为空来计算res
                    res = stack.isEmpty() ? Math.max(res, i - l + 1) : Math.max(res, i - stack.peek());
                }
            }
        }
        return res;
    }
}
