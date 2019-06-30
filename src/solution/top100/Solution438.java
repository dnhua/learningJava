package solution.top100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 438. Find All Anagrams in a String
 * https://leetcode.com/problems/find-all-anagrams-in-a-string/
 * 这种easy解法超时
 */
public class Solution438 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ret = new ArrayList<>();
        for (int i=0; i<s.length()-p.length()+1; i++) {
            if (isAnagrams(s, p, i))
                ret.add(i);
        }
        return ret;
    }
    public boolean isAnagrams(String s, String p, int start) {
        //从start位置匹配是否是anagrams
        //1.取sub字符串
        String sub = s.substring(start, start + p.length());
        //2.将sub和p放到两个map里面，统计字符出现的次数
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        for (char c : sub.toCharArray())
            map1.put(c, map1.getOrDefault(c, 0) + 1);
        for (char c : p.toCharArray())
            map2.put(c, map2.getOrDefault(c, 0) + 1);
        return map1.equals(map2);
    }
}
