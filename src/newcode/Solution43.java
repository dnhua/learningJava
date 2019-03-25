package newcode;

import java.util.*;

/**
 * 字符流中第一个不重复的字符
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。
 * 例如，当从字符流中只读出前两个字符 "go" 时，第一个只
 * 出现一次的字符是 "g"。当从该字符流中读出前六个字符“
 * google" 时，第一个只出现一次的字符是 "l"。
 */
public class Solution43 {
    private Set<Character> set = new HashSet<>();
    private Deque<Character> queue = new LinkedList<>();
    //Insert one char from stringstream
    public void Insert(char ch) {
        if (!set.contains(ch)) {
            set.add(ch);
            queue.addFirst(ch);
        } else {
            queue.remove(ch);
        }
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        return queue.peekLast() == null ? '#' : queue.peekLast();
    }
}

//    private int[] cnts = new int[256];
//    private Queue<Character> queue = new LinkedList<>();
//
//    public void Insert(char ch) {
//        cnts[ch]++;
//        queue.add(ch);
//        while (!queue.isEmpty() && cnts[queue.peek()] > 1)
//            queue.poll();
//    }
//
//    public char FirstAppearingOnce() {
//        return queue.isEmpty() ? '#' : queue.peek();
//    }
