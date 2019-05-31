package solution.search;

import java.util.ArrayList;
import java.util.List;

/**
 * 组合求和
 * 39. Combination Sum (Medium)
 * https://leetcode.com/problems/combination-sum/
 * given candidate set [2, 3, 6, 7] and target 7,
 * A solution set is:
 * [[7],[2, 2, 3]]
 */
public class Solution39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        doCombinationSum(res, new ArrayList<>(), candidates, target, 0);
        return res;
    }

    private void doCombinationSum(List<List<Integer>> res, List<Integer> com, final int[] candidates, int target, int start) {
        if (target == 0) {  //找到一个解
            res.add(new ArrayList<>(com));
            return ;
        }
//        if (target < 0) {
//            return ;
//        }

        for (int i=start; i<candidates.length; i++) {
            if (candidates[i] <= target) {
                com.add(candidates[i]);
                doCombinationSum(res, com, candidates, target-candidates[i], i);
                com.remove(com.size()-1);
            }
        }
    }
}
