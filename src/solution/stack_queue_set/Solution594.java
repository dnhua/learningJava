package solution.stack_queue_set;

import java.util.HashMap;
import java.util.Map;

/**
 * 最长和谐序列
 */
public class Solution594 {
    public int findLHS(int[] nums) {
        //使用一个map来统计所有的数字出现的次数
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, 1+map.getOrDefault(num, 0));
        }
        //主循环
        int longest = 0;
        for (int key : map.keySet()) {
            if (map.containsKey(key + 1))
                longest = Math.max(longest, map.get(key) + map.get(key+1));
        }
        return longest;
    }
}
