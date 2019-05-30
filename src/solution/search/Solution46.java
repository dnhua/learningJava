package solution.search;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 排列
 * 46. Permutations (Medium)
 * https://leetcode.com/problems/permutations/
 * [1,2,3] have the following permutations:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 */
public class Solution46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Set<List<Integer>> setres = new HashSet<>();
        if (nums.length == 0)
            return res;

        doPermute(setres, nums, 0);
        for (List<Integer> list : setres) {
            res.add(list);
        }
        return res;
    }

    private void doPermute(Set<List<Integer>> set, int[] nums, int k) {
        set.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
        if (k == nums.length)
            return ;
        for (int i=k; i<nums.length; i++) {
            swap(nums, k, i);
            doPermute(set, nums, k+1);
            swap(nums, k, i);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tem = nums[i];
        nums[i] = nums[j];
        nums[j] = tem;
    }
}
