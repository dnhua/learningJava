package solution.array;

import edu.princeton.cs.algs4.StdIn;

import java.util.HashMap;
import java.util.Map;

/**
 * 数组的度
 * Input: [1,2,2,3,1,4,2]
 * Output: 6
 *
 * 题目描述：数组的度定义为元素出现的最高频率，例如上面的数组度为 3。
 * 要求找到一个最小的子数组，这个子数组的度和原数组一样。
 */
public class Solution697 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 3, 1};
        int shortestSubArray = findShortestSubArray(nums);
        System.out.println(shortestSubArray);
    }
    public static int findShortestSubArray(int[] nums) {
        //使用三个map来统计，其中一个map用来存次数，另外两个用来存
        Map<Integer, Integer> timesMap = new HashMap<>();
        Map<Integer, Integer> leftMap = new HashMap<>();
        Map<Integer, Integer> rightMap = new HashMap<>();

        //for循环统计
        for (int i=0; i<nums.length; i++) {
            timesMap.put(nums[i], timesMap.getOrDefault(nums[i], 0)+1);
            rightMap.put(nums[i], i);
            if (!leftMap.containsKey(nums[i]))
                leftMap.put(nums[i], i);
        }
        //for循环找到最大的度的num
        int maxCnt = 0;
        for (int num : nums) {
            if (timesMap.get(num) > maxCnt)
                maxCnt = timesMap.get(num);
        }
        //计算结果
        int ret = nums.length;
        for (int num : nums) {
            if (timesMap.get(num) == maxCnt)
                ret = Math.min(ret, rightMap.get(num) - leftMap.get(num) + 1);
        }

        return ret;
    }
}
