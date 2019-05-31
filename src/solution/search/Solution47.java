package solution.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 含有相同元素求排列
 * 47. Permutations II (Medium)
 *
 * [1,1,2] have the following unique permutations:
 * [[1,1,2], [1,2,1], [2,1,1]]
 *
 * 数组元素可能含有相同的元素，进行排列时就有可能出现重复的排列，要求重复的排列只返回一个。
 *
 * 在实现上，和 Permutations 不同的是要先排序，然后在添加一个元素时，判断这个元素是否等于
 * 前一个元素，如果等于，并且前一个元素还未访问，那么就跳过这个元素。
 */
public class Solution47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> permutes = new ArrayList<>();
        List<Integer> permuteList = new ArrayList<>();
        Arrays.sort(nums);  // 排序
        boolean[] hasVisited = new boolean[nums.length];
        backtracking(permuteList, permutes, hasVisited, nums);
        return permutes;
    }

    private void backtracking(List<Integer> permuteList, List<List<Integer>> permutes, boolean[] visited, final int[] nums) {
        if (permuteList.size() == nums.length) {
            permutes.add(new ArrayList<>(permuteList));
            return;
        }

        for (int i = 0; i < visited.length; i++) {
            if (i != 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
                continue;  // 防止重复
            }
            if (visited[i]){
                continue;
            }
            visited[i] = true;
            permuteList.add(nums[i]);
            backtracking(permuteList, permutes, visited, nums);
            permuteList.remove(permuteList.size() - 1);
            visited[i] = false;
        }
    }
}
