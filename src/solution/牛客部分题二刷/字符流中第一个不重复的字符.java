package solution.牛客部分题二刷;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class 字符流中第一个不重复的字符 {
    Deque<Character> q = new LinkedList<>();
    Set<Character> set = new HashSet<>();
    //Insert one char from stringstream
    public void Insert(char ch){
        if (!set.contains(ch)) {
            set.add(ch);
            q.addFirst(ch);
        } else {
            q.remove(ch);
        }
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce(){
        return q.peekLast() == null ? '#' : q.peekLast();
    }
}
