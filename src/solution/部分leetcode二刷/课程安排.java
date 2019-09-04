package solution.部分leetcode二刷;

import java.util.*;

public class 课程安排 {
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        //建立邻接表
        Map<Integer, List<Integer>> adjacencyList = new HashMap<>();
        int[] indegree = new int[numCourses];
        int[] topologicalOrder = new int[numCourses];
        for (int[] relation : prerequisites) {
            List<Integer> list = adjacencyList.getOrDefault(relation[1], new ArrayList<>());
            list.add(relation[0]);
            adjacencyList.put(relation[1], list);
            indegree[relation[0]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i=0; i<numCourses; i++) {
            if (indegree[i] == 0)
                q.add(i);
        }

        int i = 0;
        while (!q.isEmpty()) {
            int num = q.remove();
            topologicalOrder[i++] = num;

            if (adjacencyList.containsKey(num)) {
                for (int neighbor : adjacencyList.get(num)) {
                    indegree[neighbor]--;

                    if (indegree[neighbor] == 0)
                        q.add(neighbor);
                }
            }
        }

        if (i == numCourses)
            return topologicalOrder;

        return new int[0];
    }

    public static void main(String[] args) {
        int[][] prerequisites = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        findOrder(4, prerequisites);
    }
}
