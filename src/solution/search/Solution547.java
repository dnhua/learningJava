package solution.search;

/**
 * 好友关系的连通分量数目
 * 547. Friend Circles (Medium)
 * https://leetcode.com/problems/friend-circles/
 * Input:
 * [[1,1,0],
 *  [1,1,0],
 *  [0,0,1]]
 *
 * Output: 2
 *
 * Explanation:The 0th and 1st students are direct friends, so they are in a friend circle.
 * The 2nd student himself is in a friend circle. So return 2.
 *
 * 题目描述：好友关系可以看成是一个无向图，例如第 0 个人与第 1 个人是好友，那么 M[0][1] 和 M[1][0]
 * 的值都为 1。
 */
public class Solution547 {
    public int findCircleNum(int[][] M) {
        int n = M.length;
        int res = 0;
        boolean[] visited = new boolean[M.length];
        for (int i=0; i<n; i++) {
            if (!visited[i]) {  //如果没有访问过
                dfs(M, i, visited);
                res++;
            }
        }
        return res;
    }

    private void dfs(int[][] M, int i, boolean[] visited) {
        visited[i] = true;
        for (int j=0; j<M.length; j++) {
            if (M[i][j] == 1 && !visited[j]) {
                dfs(M, j, visited);
            }
        }
    }
}
