package newcode;

import java.util.Stack;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够
 * 得到栈中所含最小元素的min函数（时间复杂度
 * 应为O（1））。
 */
public class Solution30 {
    Stack<Integer> min = new Stack<>();
    Stack<Integer> data = new Stack<>();
    public void push(int node) {
        data.push(node);
        if (min==null)
            min.push(node);
        min.push(Math.min(min.peek(), node));   //这里很巧妙啊
    }

    public void pop() {
        data.pop();
        min.pop();
    }

    public int top() {
        return data.peek();
    }

    public int min() {
        return min.peek();
    }
}
