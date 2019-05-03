package solution.array;

/**
 * 有序矩阵查找
 * Consider the following matrix:
 *
 * [
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 *
 * Given target = 5, return true.
 *
 * Given target = 20, return false.
 */
public class Solution240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        //从右上角开始
        int r = 0, c = matrix[0].length - 1;
        while (r < matrix.length && c >= 0) {
            if (matrix[r][c] == target)
                return true;
            if (matrix[r][c] < target)
                r++;
            else
                c--;
        }
        return false;
    }
}
