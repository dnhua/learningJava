package solution.部分leetcode二刷;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 组成整数的最小平方数数量 {
    public int numSquares(int n) {
        List<Integer> squares = generateSquares(n);
        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        boolean[] marked = new boolean[n];
        int level = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            level++;
            for (int i=0; i<size; i++) {
                int cur = q.poll();
                for (int num : squares) {
                    int next = cur - num;
                    if (next < 0) {
                        break;
                    } else if (next == 0) {
                        return level;
                    }

                    if (marked[next])
                        continue;

                    marked[next] = true;
                    q.add(next);
                }
            }
        }
        return n;
    }

    private List<Integer> generateSquares(int n) {
        List<Integer> list = new LinkedList<>();
        int square = 1;
        int diff = 3;
        while (square <= n) {
            list.add(square);
            square += diff;
            diff += 2;
        }
        return list;
    }
}
