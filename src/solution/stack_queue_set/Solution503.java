package solution.stack_queue_set;

import java.util.Arrays;
import java.util.Stack;

/**
 * 循环数组中比当前元素大的下一个元素
 * https://leetcode.com/problems/next-greater-element-ii/
 */
public class Solution503 {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[nums.length];
        Arrays.fill(res, -1);
        for (int i=0; i<nums.length*2; i++) {
            int num = nums[i % nums.length];    //通过取余方式实现循环
            while (!stack.isEmpty() && num > nums[stack.peek()]) {
                res[stack.pop()] = num;
            }
            if (i < nums.length) stack.push(i); //只保存n个值
        }
        return res;
    }
}
