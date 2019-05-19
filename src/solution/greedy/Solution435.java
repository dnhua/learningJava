package solution.greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 不重叠的区间个数
 * 435. Non-overlapping Intervals (Medium)
 *
 * Input: [ [1,2], [1,2], [1,2] ]
 *
 * Output: 2
 *
 * Explanation: You need to remove two [1,2] to make the rest of intervals non-overlapping.
 *
 * Input: [ [1,2], [2,3] ]
 *
 * Output: 0
 *
 * Explanation: You don't need to remove any of the intervals since they're already non-overlapping.
 *
 * 题目描述：计算让一组区间不重叠所需要移除的区间个数。
 *
 * 先计算最多能组成的不重叠区间个数，然后用区间总个数减去不重叠区间的个数。
 *
 * 在每次选择中，区间的结尾最为重要，选择的区间结尾越小，留给后面的区间的空间越大，那么后面能够选择的区间个数也就越大。
 *
 * 按区间的结尾进行排序，每次选择结尾最小，并且和前一个区间不重叠的区间。
 */
public class Solution435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0)
            return 0;
        int cnt = 0;
        Arrays.sort(intervals, new Comparator<int []>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        int end = intervals[0][1];
        for (int i=1; i<intervals.length; i++) {
            if (intervals[i][0] < end) {
                cnt++;
                continue;
            }
            end = intervals[i][1];
        }
        return cnt;
    }
}
