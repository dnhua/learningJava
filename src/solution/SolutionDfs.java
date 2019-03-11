package solution;

import org.junit.jupiter.api.Test;

public class SolutionDfs {
    public int numIslands(char[][] grid) {
        int count=0;
        for (int i=0;i<grid.length;i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    dfsFill(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }
    private void dfsFill(char[][] grid,int i, int j){
        if(i>=0 && j>=0 && i<grid.length && j<grid[0].length&&grid[i][j]=='1'){
            grid[i][j]='0';
            dfsFill(grid, i + 1, j);
            dfsFill(grid, i - 1, j);
            dfsFill(grid, i, j + 1);
            dfsFill(grid, i, j - 1);
        }
    }

    @Test
    public void test() {
        char[][] grid = new char[][]{{'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}};
        SolutionDfs solution = new SolutionDfs();
        //solution.numIslands(grid);
        System.out.println("my answer is: "+solution.numIslands(grid));
    }
}
