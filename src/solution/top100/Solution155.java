package solution.top100;

import java.util.Stack;

/**
 * 155. Min Stack
 * https://leetcode.com/problems/min-stack/
 */
public class Solution155 {
    Stack<Integer> stk = new Stack<>();
    Stack<Integer> stk2 = new Stack<>();

    public void push(int x) {
        stk.push(x);                             //Always push into main stack
        if(stk2.isEmpty() || x <= stk2.peek())   //Push when empty OR x<= current smallest value
            stk2.push(x);
    }

    public void pop() {
        if(stk.pop().equals(stk2.peek()))    //Main stk always pop
            stk2.pop();                      //Other stk pops only if it equal to main stk's min
    }

    public int top() {
        return stk.peek();
    }

    public int getMin() {
        return stk2.peek();
    }
}
