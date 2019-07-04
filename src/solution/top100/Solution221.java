package solution.top100;

/**
 * 221. Maximal Square
 * https://leetcode.com/problems/maximal-square/
 * Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.
 *
 * Example:
 *
 * Input:
 *
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 *
 * Output: 4
 */
public class Solution221 {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return 0;
        int max = 0;
        int m = matrix.length, n = matrix[0].length;
        int[] line = new int[n];
        for (int i=0; i<m; i++) {
            //首先需要更新line
            for (int j=0; j<n; j++) {
                line[j] = matrix[i][j] == '1' ? line[j] + 1 : 0;
            }
            max = Math.max(max, maxLine(line));
        }
        return max;
    }

    public int maxLine(int[] line) {
        //通过局部峰值找到最大解,局部峰值为比后面一个数要大的值
        int max = 0;
        for (int i=0; i<line.length; i++) {
            if (i + 1 < line.length && line[i] < line[i+1])
                continue;
            int minH = line[i];
            for (int j=i; j>=0; j--) {
                minH = Math.min(minH, line[j]);
                if (minH == (i - j + 1))
                    max = Math.max(max, minH * (i - j + 1));
            }
        }
        return max;
    }
}
