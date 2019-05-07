package solution.array;

/**
 * 嵌套数组
 * Input: A = [5,4,0,3,1,6,2]
 * Output: 4
 * Explanation:
 * A[0] = 5, A[1] = 4, A[2] = 0, A[3] = 3, A[4] = 1, A[5] = 6, A[6] = 2.
 *
 * One of the longest S[K]:
 * S[0] = {A[0], A[5], A[6], A[2]} = {5, 6, 2, 0}
 *
 * 题目描述：S[i] 表示一个集合，集合的第一个元素是 A[i]，第二个元素是 A[A[i]]，
 * 如此嵌套下去。求最大的 S[i]。
 */
public class Solution565 {
    public int arrayNesting(int[] nums) {
        //暴力搜索，两层for循环
        int maxcnt = 0;
        int[] checkNums = new int[nums.length]; //这句话一定要放在循环外面，不然会超时。可以这么理解：如果被之前标记过，那么后面这次访问的结果肯定不会大于之前的那次访问
        for (int num : nums) {
            int cnt = 0;
            while (num < nums.length && checkNums[num] != -1) {
                cnt++;
                checkNums[num] = -1;
                num = nums[num];
            }
            maxcnt = Math.max(maxcnt, cnt);
        }
        return maxcnt;
    }

    public int arrayNesting2(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int cnt = 0;
            for (int j = i; nums[j] != -1; ) {
                cnt++;
                int t = nums[j];
                nums[j] = -1; // 标记该位置已经被访问
                j = t;
            }
            max = Math.max(max, cnt);
        }
        return max;
    }
}
