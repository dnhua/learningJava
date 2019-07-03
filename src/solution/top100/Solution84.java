package solution.top100;

/**
 * 84. Largest Rectangle in Histogram
 * https://leetcode.com/problems/largest-rectangle-in-histogram/
 * Given n non-negative integers representing the histogram's bar height where
 * the width of each bar is 1, find the area of largest rectangle in the histogram.
 */
public class Solution84 {
    public int largestRectangleArea(int[] heights) {
        //思路：网上看来的思路，找局部峰值剪枝
        if (heights == null || heights.length == 0)
            return 0;
        int max = 0;
        for (int i=0; i<heights.length; i++) {
            if (i + 1 < heights.length && heights[i] <= heights[i+1])
                continue;
            //记录当前的最小高度
            int minH = heights[i];
            for (int j=i; j>=0; j--) {
                minH = heights[j] < minH ? heights[j] : minH;
                max = Math.max(max, (i - j + 1) * minH);
            }
        }
        return max;
    }
}
