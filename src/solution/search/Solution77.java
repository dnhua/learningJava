package solution.search;

import java.util.ArrayList;
import java.util.List;

/**
 *  组合
 *  77. Combinations (Medium)
 * https://leetcode.com/problems/combinations/
 * If n = 4 and k = 2, a solution is:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 */
public class Solution77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (k > n)
            return res;
        List<Integer> com = new ArrayList<>();
        doCombine(res, com, 1, n, k);
        return res;
    }

    private void doCombine(List<List<Integer>> res, List<Integer> com, int start, final int n, int k) {
        if (k == 0) {   //找到一个解
            res.add(new ArrayList<>(com));
            return ;
        }

        for (int i=start; i<=n-k+1; i++) {
            com.add(i);
            doCombine(res, com, i+1, n,k-1);
            com.remove(com.size()-1);
        }
    }
}
