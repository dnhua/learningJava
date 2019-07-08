package solution.top100;

/**
 * 42. Trapping Rain Water
 * https://leetcode.com/problems/trapping-rain-water/
 * Given n non-negative integers representing an elevation map where the width of each bar is 1,
 * compute how much water it is able to trap after raining.
 * Input: [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 */
public class Solution42 {
    public int trap(int[] height) {
        //思路：也是网上看来的答案，非常巧妙
        //找到最高的那个点
        if (height == null || height.length <= 2)
            return 0;
        int ret = 0;
        int max = 0, maxIdx = -1;   //max存值，maxIdx存下标
        for (int i=0; i<height.length; i++) {
            if (height[i] > max) {
                max = height[i];
                maxIdx = i;
            }
        }

        //计算左边的面积
        int left = height[0];
        for (int i=0; i<maxIdx; i++) {
            if (left < height[i])
                left = height[i];
            else
                ret += (left - height[i]);
        }

        //计算右边的面积
        int right = height[height.length-1];
        for (int i=height.length-1; i>maxIdx; i--) {
            if (right < height[i])
                right = height[i];
            else
                ret += (right - height[i]);
        }

        return ret;
    }
}
