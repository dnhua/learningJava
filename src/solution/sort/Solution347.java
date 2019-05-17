package solution.sort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 出现频率最多的 k 个元素
 * 347. Top K Frequent Elements (Medium)
 *
 * Given [1,1,1,2,2,3] and k = 2, return [1,2].
 *
 * 设置若干个桶，每个桶存储出现频率相同的数。桶的下标表示数出现的频率，即第 i 个桶中存储的数出现的频率为 i。
 *
 * 把数都放到桶之后，从后向前遍历桶，最先得到的 k 个数就是出现频率最多的的 k 个数。
 */
public class Solution347 {
    public List<Integer> topKFrequent(int[] nums, int k) {
        //1.先统计所有出现的次数
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        //2.建立桶
        List<Integer>[] bucket = new ArrayList[nums.length+1];
        for (int key : map.keySet()) {
            Integer times = map.get(key);
            if (bucket[times] == null) {
                bucket[times] = new ArrayList<>();
            }
            bucket[times].add(key);
        }
        //3.得到频率出现最多的k个数
        List<Integer> topK = new ArrayList<>();
        for (int i=bucket.length-1; i>=0 && topK.size()<k; i--) {
            if (bucket[i] == null)
                continue;
            if (bucket[i].size() <= k - topK.size()) {
                topK.addAll(bucket[i]);
            } else {
                topK.addAll(bucket[i].subList(0, k-topK.size()));
            }
        }
        return topK;
    }
}
