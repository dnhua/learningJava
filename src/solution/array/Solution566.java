package solution.array;

/**
 * 改变矩阵维度
 * Input:
 * nums =
 * [[1,2],
 *  [3,4]]
 * r = 1, c = 4
 *
 * Output:
 * [[1,2,3,4]]
 *
 * Explanation:
 * The row-traversing of nums is [1,2,3,4]. The new reshaped matrix is a 1 * 4 matrix,
 * fill it row by row by using the previous list.
 */
public class Solution566 {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int m = nums.length, n = nums[0].length;
        if (m*n != r*c) return nums;
        int[][] reshape = new int[r][c];
        int idx = 0;
        for (int i=0; i<r; i++) {
            for (int j=0; j<c; j++) {
                reshape[i][j] = nums[idx/n][idx%n];
                idx++;
            }
        }
        return reshape;
    }
}
