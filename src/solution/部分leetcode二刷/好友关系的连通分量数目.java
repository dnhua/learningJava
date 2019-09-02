package solution.部分leetcode二刷;

public class 好友关系的连通分量数目 {
    private int n;
    public int findCircleNum(int[][] M) {
        if (M == null) {
            return 0;
        }
        n = M[0].length;
        int ret = 0;
        boolean[] hasVisited = new boolean[n];
        for (int i=0; i<n; i++) {
            if (!hasVisited[i]) {
                ret++;
                dfs(M, i, hasVisited);
            }
        }
        return ret;
    }

    public void dfs(int[][] M, int i, boolean[] hasVisited) {
        hasVisited[i] = true;

        //dfs
        for (int k=0; k<n; k++) {
            if (M[i][k] == 1 && !hasVisited[k]) {
                dfs(M, k, hasVisited);
            }
        }
    }
}
