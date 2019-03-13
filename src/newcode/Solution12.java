package newcode;

/**
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向
 * 下移动一个格子。如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该
 * 格子。
 */
public class Solution12 {
    private int[][] next = new int[][]{{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
    private int rows, cols;
    public boolean hasPath(char[] array, int rows, int cols, char[] str){
        if (rows==0 && cols==0)
            return false;
        this.cols = cols;
        this.rows = rows;
        boolean[][] marked = new boolean[rows][cols];
        char[][] matrix = buildMatrix(array);
        for (int i=0; i<rows; i++) {
            for (int j=0; j<cols; j++) {
                if (findPath(matrix, str, marked, 0, i, j))
                    return true;
            }
        }
        return false;
    }

    private boolean findPath(char[][] matrix, char[] str, boolean[][] marked, int pathL, int r, int c) {
        if (pathL==str.length)
            return true;
        if (r < 0 || r >= rows || c < 0 || c >= cols || marked[r][c] == true || matrix[r][c] != str[pathL])
            return false;
        marked[r][c] = true;
        for (int[] nc:next) {
            if (findPath(matrix, str, marked, pathL+1, r+nc[0], c+nc[1]))
                return true;
        }
        marked[r][c] = false;
        return false;
    }

    private char[][] buildMatrix(char[] array) {
        char[][] matrix = new char[rows][cols];
        for (int i=0; i<rows; i++) {
            for (int j=0; j<cols; j++) {
                matrix[i][j] = array[i*cols+j];
            }
        }
        return matrix;
    }
}
