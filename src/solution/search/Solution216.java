package solution.search;

import java.util.ArrayList;
import java.util.List;

/**
 * 1-9 数字的组合求和
 * 216. Combination Sum III (Medium)
 * https://leetcode.com/problems/combination-sum-iii/
 * Input: k = 3, n = 9
 *
 * Output:
 *
 * [[1,2,6], [1,3,5], [2,3,4]]
 *
 * 从 1-9 数字中选出 k 个数不重复的数，使得它们的和为 n。
 */
public class Solution216 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        doCombinationSum3(res, new ArrayList<>(), k, n, 1);
        return res;
    }

    private void doCombinationSum3(List<List<Integer>> res, List<Integer> com, int k, int target, int start) {
        if (k == 0 && target == 0) {    //找到一个解
            res.add(new ArrayList<>(com));
            return ;
        }
        if (k == 0 || target == 0)
            return ;
        for (int i=start; i<=9; i++) {
            com.add(i);
            doCombinationSum3(res, com, k-1, target-i, i+1);
            com.remove(com.size()-1);
        }
    }
}
