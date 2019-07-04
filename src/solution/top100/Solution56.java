package solution.top100;

import java.util.*;

/**
 * 56. Merge Intervals
 * Given a collection of intervals, merge all overlapping intervals.
 *
 * Example 1:
 *
 * Input: [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 */
class Solution56 {
    public int[][] merge(int[][] intervals) {
        List<int[]> ret = new ArrayList<>();
        if (intervals == null || intervals.length == 0)
            return new int[0][0];
        //先排序
        Arrays.sort(intervals, new Comparator<int []>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int[] oneRet = {intervals[0][0], intervals[0][1]};
        ret.add(oneRet.clone());    //这里一定要是clone
        for (int i=1; i<intervals.length; i++) {
            oneRet[0] = intervals[i][0];
            oneRet[1] = intervals[i][1];
            if (ret.get(ret.size()-1)[1] >= intervals[i][0])    //合并
                ret.get(ret.size()-1)[1] = Math.max(ret.get(ret.size()-1)[1], intervals[i][1]);
            else {  //新的区间
                oneRet = new int[2];
                oneRet[0] = intervals[i][0];
                oneRet[1] = intervals[i][1];
                ret.add(oneRet.clone());
            }
        }
//        int[][] result = new int[ret.size()][2];
//        for (int i=0; i<ret.size(); i++) {
//            result[i] = ret.get(i);
//        }
        return ret.toArray(new int[0][]);
    }
}