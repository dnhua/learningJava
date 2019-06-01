package solution.search;

import java.util.ArrayList;
import java.util.List;

/**
 * 子集
 * 找出集合的所有子集，子集不能重复，[1, 2] 和 [2, 1] 这种子集算重复
 */
public class Solution78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        for (int i=1; i<=nums.length; i++) {
            doSubsets(res, new ArrayList<>(), nums, i, 0);
        }
        return res;
    }

    private void doSubsets(List<List<Integer>> res, List<Integer> subset, final int[] nums, int size, int start) {
        if (subset.size() == size) {    //找到一个解
            res.add(new ArrayList<>(subset));
            return ;
        }

        for (int i=start; i<nums.length; i++) {
            subset.add(nums[i]);
            doSubsets(res, subset, nums, size, i+1);
            subset.remove(subset.size()-1);
        }
    }
}
