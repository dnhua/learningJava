package solution.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 含有相同元素的组合求和
 * 40. Combination Sum II (Medium)
 * https://leetcode.com/problems/combination-sum-ii/description/
 * For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8,
 * A solution set is:
 * [
 *   [1, 7],
 *   [1, 2, 5],
 *   [2, 6],
 *   [1, 1, 6]
 * ]
 */
public class Solution40 {
    boolean[] hasVisited;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        hasVisited = new boolean[candidates.length];
        Arrays.sort(candidates);
        doCombinationSum(res, new ArrayList<>(), candidates, target, 0);
        return res;
    }

    private void doCombinationSum(List<List<Integer>> res, List<Integer> com, final int[] candidates, int target, int start) {
        if (target == 0) {  //找到一个解
            res.add(new ArrayList<>(com));
            return ;
        }

        for (int i=start; i<candidates.length; i++) {
            if (i != 0 && candidates[i] == candidates[i - 1] && !hasVisited[i - 1]) {
                continue;
            }
            if (candidates[i] <= target) {
                com.add(candidates[i]);
                hasVisited[i] = true;
                doCombinationSum(res, com, candidates, target-candidates[i], i+1);
                com.remove(com.size()-1);
                hasVisited[i] = false;
            }
        }
    }
}
