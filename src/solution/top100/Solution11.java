package solution.top100;

/**
 * 11.Container With Most Water
 * Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate
 * (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and
 * (i, 0). Find two lines, which together with x-axis forms a container, such that the container
 * contains the most water.
 * Example:
 * Input: [1,8,6,2,5,4,8,3,7]
 * Output: 49
 */
public class Solution11 {
    public int maxArea(int[] height) {
        if (height == null || height.length == 0)
            return 0;
        int n = height.length;
        //双指针法
        int l = 0, r = n-1;
        int maxArea = 0;
        while (l < r) {
            maxArea = Math.max(maxArea, Math.min(height[l], height[r]) * (r - l));
            //比较当前两个指针所在位置的值，改变较小值的指针（只有它有可能补偿宽度的变化）
            if (height[l] > height[r])
                r--;
            else
                l++;
        }
        return maxArea;
    }
}
