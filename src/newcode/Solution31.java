package newcode;

import org.junit.jupiter.api.Test;

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
        stack.push(pushA[0]);
        i++;
        while (i <= pushA.length && j < popA.length) {
            if (stack.peek() != popA[j]) {
                if (i == pushA.length)
                    return false;
                stack.push(pushA[i]);
                i++;
            } else {
                stack.pop();
                j++;
            }
        }
        return stack.isEmpty();
    }

    @Test
    void test() {
        Solution31 solution31 = new Solution31();
        int[] pushA = new int[]{1,2,3,4,5};
        int[] popA = new int[]{4,3,5,1,2};
        Boolean b = solution31.IsPopOrder(pushA, popA);
        System.out.println(b);
    }
}
