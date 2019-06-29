package solution.top100;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 394. Decode String
 * Examples:
 * s = "3[a]2[bc]", return "aaabcbc".
 * s = "3[a2[c]]", return "accaccacc".
 * s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
 * https://leetcode.com/problems/decode-string/discuss/87570/Simple-1-pass-Java-Solution-with-only-1-stack-with-explanation
 */
public class Solution394 {
    public String decodeString(String s) {
        Deque<Character> stack = new LinkedList();
        for (char c : s.toCharArray()) {
            //只要不是‘]’就放到stack中
            if (c != ']') {
                stack.push(c);
            } else {
                //1.当前字符是]，将stack里面的字符取出来
                StringBuilder sb = new StringBuilder();
                while (!stack.isEmpty() && Character.isLetter(stack.peek())) {
                    sb.insert(0, stack.pop());
                }
                String subString = sb.toString();
                //2.当前字符应该是[了，将其抛出
                stack.pop();

                //3.计算重复的次数
                sb = new StringBuilder();
                while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
                    sb.insert(0, stack.pop());
                }
                int cnt = Integer.valueOf(sb.toString());

                //4.repeat 字符串
                while (cnt-- > 0) {
                    for (char ch : subString.toCharArray())
                        stack.push(ch);
                }
            }
        }
        //5.将结果stack导出
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty())
            sb.insert(0, stack.pop());

        return sb.toString();
    }
}
