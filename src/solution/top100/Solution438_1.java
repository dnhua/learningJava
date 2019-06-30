package solution.top100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution438_1 {
    public List<Integer> findAnagrams(String s, String p) {
        //解题思路：用两个数组来装字符出现的次数，如果两个数组相等就找到一个解
        //1.准备
        List<Integer> ret = new ArrayList<>();
        if (s == null || s.isEmpty() || p.length() > s.length())
            return ret;
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        //2.统计
        for (int i=0; i<p.length(); i++) {
            map1.put(s.charAt(i), map1.getOrDefault(s.charAt(i), 0) + 1);
            map2.put(p.charAt(i), map2.getOrDefault(p.charAt(i), 0) + 1);
            map2.put(s.charAt(i), map2.getOrDefault(s.charAt(i), 0));
        }
        if (map1.equals(map2)) ret.add(0);
        //3.继续遍历，寻找其他解.类似滑动窗口
        for (int i=p.length(); i<s.length(); i++) {
            map1.put(s.charAt(i - p.length()), map1.get(s.charAt(i - p.length())) - 1);
            map1.put(s.charAt(i), map1.getOrDefault(s.charAt(i), 0) + 1);
            map2.put(s.charAt(i), map2.getOrDefault(s.charAt(i), 0));
            if (map1.equals(map2)) {
                ret.add(i - p.length() + 1);
//                System.out.println(i);
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        Solution438_1 solution438 = new Solution438_1();
        String s = "cbaebabacd";
        String p = "abc";
        List<Integer> anagrams = solution438.findAnagrams(s, p);
        System.out.println(anagrams);
    }
}
