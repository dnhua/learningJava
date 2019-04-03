package newcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,
 * 并返回它的位置, 如果没有则返回 -1（需要区分大小写）.
 */
public class Solution52 {
    public int FirstNotRepeatingChar(String str) {
        if (str==null || str.length()==0)
            return -1;
        //1.建立一个hashmap来保存字符出现的次数
        Map<Character, Integer> map = new HashMap();
        for (int i=0; i< str.length(); i++) {
            char ch = str.charAt(i);
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch)+1);
            } else {
                map.put(ch, 1);
            }
        }
        //2.从前到后扫描找到第一个次数为1的位置
        for (int i=0; i<str.length(); i++) {
            char ch = str.charAt(i);
            if (map.get(ch) == 1)
                return i;
        }
        return -1;
    }
}
