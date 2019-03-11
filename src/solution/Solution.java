package solution;

import org.junit.jupiter.api.Test;

public class Solution {
    int[] father;
    int m, n;
    public int numIslands(char[][] grid) {
        //特殊情况的考虑
        if (grid==null || grid.length==0 || grid[0].length==0)
            return 0;
        UnionFind uf = new UnionFind(grid);
        int[][] directions = new int[][]{{0,1},{0,-1},{-1,0},{1,0}};
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (grid[i][j]=='0')
                    continue;
                for (int[] d : directions) {
                    int nr = j + d[1];
                    int nd = i + d[0];
                    if (nr>=0 && nd >=0 && nr<n && nd<m && grid[nd][nr]=='1') {
                        uf.union(i*n+j, nd*n+nr);
                    }
                }
            }
        }
        return uf.count;
    }

    private class UnionFind {
        int count;
        int[] rank;
        public UnionFind(char[][] grid) {
            m = grid.length;
            n = grid[0].length;
            father = new int[m*n];
            rank = new int[m*n];
            count = 0;
            for (int i=0; i<m; i++) {
                for (int j=0; j<n; j++) {
                    if (grid[i][j]=='1') {
                        father[i*n+j] = i*n+j;
                        count++;
                    }
                }
            }
        }
        public int find(int node) {
            if (father[node]!=node) {
                father[node] = find(father[node]);
            }
            return father[node];
        }
        public void union(int node1, int node2) {
            int rootx = find(node1);
            int rooty = find(node2);
            if (rootx!=rooty) {
                if (rank[rootx] > rank[rooty]) {
                    father[rooty] = rootx;
                } else if (rank[rootx] < rank[rooty]) {
                    father[rootx] = rooty;
                } else {
                    father[rooty] = rootx;
                    rank[rootx] = rank[rootx] + 1;
                }
                count--;
            }
        }
    }

    @Test
    public void test() {
        char[][] grid = new char[][]{{'1','1','1','1','0'},
                                     {'1','1','0','1','0'},
                                     {'1','1','0','0','0'},
                                     {'0','0','0','0','0'}};
        Solution solution = new Solution();
        //solution.numIslands(grid);
        System.out.println("my answer is: "+solution.numIslands(grid));
    }

}
