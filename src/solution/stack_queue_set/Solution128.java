package solution.stack_queue_set;

import java.util.HashSet;
import java.util.Set;

/**
 * 最长连续序列
 */
public class Solution128 {
    public int longestConsecutive(int[] nums) {
        //先用一个set把nums装起来
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int longest = 0;
        for (int num : set) {
            //去重
            if (!set.contains(num-1)) {
                int curlongest = 1;
                while (set.contains(num+1)) {
                    num++;
                    curlongest++;
                }
                //与当前最长值比较
                longest = Math.max(longest, curlongest);
            }
        }
        return longest;
    }
}
