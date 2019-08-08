package solution.部分leetcode二刷;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

public class 在网格中从原点到特定点的最短路径长度 {
    public int minPathLength(int[][] grids, int tr, int tc) {
        int len = minPath(grids,tr,tc);
        return len;
    }

    private int minPath(int[][] grids, int tr, int tc) {
        final int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        final int m = grids.length, n = grids[0].length;
        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        q.add(new Pair<>(0, 0));
        int pathlength = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            pathlength++;
            for (int i=0; i<size; i++) {
                Pair<Integer, Integer> pair = q.poll();
                int r = pair.getKey();
                int c = pair.getValue();
                grids[r][c] = 0; // 标记
                for (int[] dir : direction) {
                    int nr = r + dir[0];
                    int nc = c + dir[1];
                    if (nr < 0 || nr >= m || nc < 0 || nc >= n || grids[nr][nc] != 1) {
                        continue;
                    }
                    if (nr == tr && nc == tc) {
                        return pathlength;
                    }
                    q.add(new Pair<>(nr, nc));
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        在网格中从原点到特定点的最短路径长度 solution = new 在网格中从原点到特定点的最短路径长度();
        int[][] grids = new int[][]{{1,1,0,1},{1,0,1,0},{1,1,1,1},{1,0,1,1}};
//        int minpathlen = solution.minPathLength(grids, 3, 3);
        int minpathlen = solution.minPath(grids, 3, 3);
        System.out.println(minpathlen);
    }
}
