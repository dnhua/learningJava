package solution.greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 投飞镖刺破气球
 * 452. Minimum Number of Arrows to Burst Balloons (Medium)
 *
 * Input:
 * [[10,16], [2,8], [1,6], [7,12]]
 *
 * Output:
 * 2
 *
 * 题目描述：气球在一个水平数轴上摆放，可以重叠，飞镖垂直投向坐标轴，使得路径上的气球都被刺破。求解最小的投飞镖次数使所有气球都被刺破。
 *
 * 也是计算不重叠的区间个数，不过和 Non-overlapping Intervals 的区别在于，[1, 2] 和 [2, 3] 在本题中算是重叠区间。
 */
public class Solution452 {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0)
            return 0;
        int cnt = 1;
        Arrays.sort(points, new Comparator<int []>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        int end = points[0][1];
        for (int i=1; i<points.length; i++) {
            if (points[i][0] <= end)
                continue;
            end = points[i][1];
            cnt++;
        }
        return cnt;
    }
}
