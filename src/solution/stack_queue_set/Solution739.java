package solution.stack_queue_set;

import java.util.Stack;

/**
 * 数组中元素与下一个比它大的元素之间的距离
 */
public class Solution739 {
    public int[] dailyTemperatures(int[] T) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[T.length];
        for (int i=0; i<T.length; i++) {
            //1.已经找到栈顶元素的解
            while (!stack.isEmpty() && T[i] > T[stack.peek()]) {
                int preT = stack.pop();
                res[preT] = i - preT;
            }
            //2.将当前节点加入stack
            stack.push(i);
        }
        res[T.length - 1] = 0;
        return res;
    }
}
