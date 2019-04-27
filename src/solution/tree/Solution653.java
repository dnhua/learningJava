package solution.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 在二叉查找树中寻找两个节点，使它们的和为一个给定值
 */
public class Solution653 {
    List<Integer> nums = new ArrayList<>();
    public boolean findTarget(TreeNode root, int k) {
        //sp case
        if (root == null) return false;
        //中序遍历得到有序数组
        inorder(nums, root);
        //主循环,使用双指针找到是否有解
        int l = 0;
        int r = nums.size() - 1;
        while (l < r) {
            int sum = nums.get(l) + nums.get(r);
            if (sum == k) return true;
            if (sum > k) r--;
            if (sum < k) l++;
        }
        return false;
    }

    public void inorder(List nums, TreeNode root) {
        if (root == null) return ;
        inorder(nums, root.left);
        nums.add(root.val);
        inorder(nums, root.right);
    }
}
