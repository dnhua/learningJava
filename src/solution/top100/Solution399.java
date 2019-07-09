package solution.top100;

import java.util.*;

/**
 * 399. Evaluate Division
 * https://leetcode.com/problems/evaluate-division/
 * Equations are given in the format A / B = k, where A and B are variables represented as strings,
 * and k is a real number (floating point number). Given some queries, return the answers. If the
 * answer does not exist, return -1.0.
 *
 * Example:
 * Given a / b = 2.0, b / c = 3.0.
 * queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ? .
 * return [6.0, 0.5, -1.0, 1.0, -1.0 ].
 *
 * The input is: vector<pair<string, string>> equations, vector<double>& values, vector<pair<string, string>>
 *     queries , where equations.size() == values.size(), and the values are positive. This represents the
 *     equations. Return vector<double>.
 *
 * According to the example above:
 *
 * equations = [ ["a", "b"], ["b", "c"] ],
 * values = [2.0, 3.0],
 * queries = [ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"] ].
 */
public class Solution399 {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String, HashMap<String, Double>> graph = new HashMap<>();
        double[] answer = new double[queries.size()];
        buildGraph(graph, equations, values);
        for (int i=0; i<queries.size(); i++) {
            String a = queries.get(i).get(0);
            String b = queries.get(i).get(1);
            Double ret = dfs(graph, a, b, new HashSet<String>());
            answer[i] = ret == null ? -1 : ret;
        }
        return answer;
    }

    public Double dfs(HashMap<String, HashMap<String, Double>> graph,
                      String a, String target, Set<String> visited) {
        //深度优先搜索
        if (visited.contains(a)) return null;   //已经找了一圈没找到，返回null
        visited.add(a);
        if (!graph.containsKey(a))  return null;    //图里面不存在a，返回null
        if (a.equals(target))   return 1.0; //已经找到了，返回1.0

        //搜索所有与a相连的节点
        if (graph.get(a) == null) return null;  //如果没有节点与之相连，直接返回null
        for (Map.Entry<String, Double> entry : graph.get(a).entrySet()) {
            Double ret = dfs(graph, entry.getKey(), target, visited);
            if (ret != null) return ret * entry.getValue();
        }
        return null;
    }

    public void buildGraph(HashMap<String, HashMap<String, Double>> graph,
                           List<List<String>> equations, double[] values) {
        //for循环建图
        for (int i=0; i<equations.size(); i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            graph.putIfAbsent(a, new HashMap<>());
            graph.putIfAbsent(b, new HashMap<>());
            graph.get(a).put(b, values[i]);
            graph.get(b).put(a, 1.0 / values[i]);
        }
    }
}
