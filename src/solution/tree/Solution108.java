package solution.tree;

/**
 * 从有序数组中构造二叉查找树
 */
public class Solution108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return toBST(nums, 0, nums.length - 1);
    }

    private TreeNode toBST(int[] nums, int sIdx, int eIdx){
        if (sIdx > eIdx) return null;
        int mIdx = (sIdx + eIdx) / 2;
        TreeNode root = new TreeNode(nums[mIdx]);
        root.left =  toBST(nums, sIdx, mIdx - 1);
        root.right = toBST(nums, mIdx + 1, eIdx);
        return root;
    }
}
