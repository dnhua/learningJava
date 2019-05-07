package solution.array;

/**
 * 对角元素相等的矩阵
 * 1234
 * 5123
 * 9512
 *
 * In the above grid, the diagonals are "[9]", "[5, 5]", "[1, 1, 1]", "[2, 2, 2]", "[3, 3]", "[4]",
 * and in each diagonal all elements are the same, so the answer is True.
 */
public class Solution766 {
    public boolean isToeplitzMatrix(int[][] matrix) {
        for (int i=matrix.length-1; i>=0; i--) {
            for (int j=0; j<matrix[0].length; j++) {
                if (!check(matrix, i, j))
                    return false;
            }
        }
        return true;
    }

    public boolean check(int[][] matrix, int beginRow, int beginColumn) {
        int i = beginRow;
        int j = beginColumn;
        while (i > 0 && j > 0) {
            if (matrix[i][j] != matrix[--i][--j])
                return false;
        }
        return true;
    }
}
