package solution.top100;

import java.util.*;

/**
 * 207. Course Schedule
 * https://leetcode.com/problems/course-schedule/
 */
public class Solution207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //解题关键点，用map存储图的信息，用一个数组来存储入度
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] grade = new int[numCourses];
        //初始化图和入度
        for (int i = 0; i < prerequisites.length; i++) {
            int num1 = prerequisites[i][0];
            int num2 = prerequisites[i][1];
            if (!graph.containsKey(num1))
                graph.put(num1, new ArrayList<>());
            graph.get(num1).add(num2);
            grade[num2]++;
        }

        //存储所有入度为0的结点
        Queue<Integer> queue = new LinkedList();
        for (int i = 0; i < numCourses; i++) {
            if (grade[i] == 0)
                queue.add(i);
        }

        //计数
        int cnt = 0;

        //主循环
        while (!queue.isEmpty()) {
            int q = queue.poll();
            cnt++;
            if (!graph.containsKey(q))
                continue;
            List<Integer> list = graph.get(q);
            for (int i=0; i<list.size(); i++) {
                int idx = list.get(i);
                grade[idx]--;
                if (grade[idx] == 0) {
                    queue.offer(idx);
                }
            }
        }

        return cnt == numCourses;
    }
}
