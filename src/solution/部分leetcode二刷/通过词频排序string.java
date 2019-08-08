package solution.部分leetcode二刷;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class 通过词频排序string {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        //1.统计字符出现的次数
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        //2.往桶里面加字符
        ArrayList<Character>[] bucket = new ArrayList[s.length() + 1];
        for (char c : map.keySet()) {
            if (bucket[map.get(c)] == null) {
                bucket[map.get(c)] = new ArrayList<>();
            }
            bucket[map.get(c)].add(c);
        }

        //3.生成结果
        StringBuilder sb = new StringBuilder();
        for (int i=bucket.length-1; i>=1; i--) {
            if (bucket[i] != null) {
                for (char c : bucket[i]) {
                    for (int j=0; j<i; j++) {
                        sb.append(c);
                    }
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        通过词频排序string solution = new 通过词频排序string();
        String aasssddfffff = solution.frequencySort("aasssddfffff");
        System.out.println(aasssddfffff);
    }
}
