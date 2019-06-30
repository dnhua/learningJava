package solution.top100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 49. Group Anagrams
 * Given an array of strings, group anagrams together.
 * Example:
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Output:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 * 这个解法很慢，仅仅超过了5%左右的解法
 */
public class Solution49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        //解题思路：用map来统计，如果当前统计的map和之前的都不一样就是一个新的
        List<List<String>> ret = new ArrayList<>();
        if (strs == null || strs.length == 0)
            return ret;
        List<Map<Character, Integer>> mapList = new ArrayList<>();
        //主循环
        for (int i = 0; i < strs.length; i++) {
            //新建map统计
            Map<Character, Integer> map = new HashMap<>();
            for (char c : strs[i].toCharArray())
                map.put(c, map.getOrDefault(c, 0) + 1);
            int idx = mapList.indexOf(map);
            if( idx == -1 ) {
                //没找到，也就是这是一个新类
                ret.add(new ArrayList<>());
                ret.get(ret.size()-1).add(strs[i]);
                mapList.add(map);
            } else {
                //找到了，这是一个旧类
                ret.get(idx).add(strs[i]);
            }
        }
        return ret;
    }
}
