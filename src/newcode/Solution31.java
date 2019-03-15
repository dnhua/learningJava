package newcode;

import java.util.Stack;

/**
 *栈的压入、弹出序列
 * 题目描述
 *
 * 输入两个整数序列，第一个序列表示栈的压入顺序，
 * 请判断第二个序列是否为该栈的弹出顺序。假设压
 * 入栈的所有数字均不相等。例如序列 1,2,3,4,5
 * 是某栈的压入顺序，序列 4,5,3,2,1是该压栈序列
 * 对应的一个弹出序列，但 4,3,5,1,2就不可能是该
 * 压栈序列的弹出序列。
 */
public class Solution31 {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        Stack<Integer> stack = new Stack<>();
        int i = 0, j = 0;
        while (i < pushA.length && j < popA.length) {
            if (stack.isEmpty()) {
                stack.push(pushA[i]);
                i++;
            }
            if (stack.peek() != popA[i]) {
                stack.push(pushA[i]);
                i++;
            } else {
                stack.pop();
                j++;
            }
        }
        return i == pushA.length && j == pushA.length;
    }
}
