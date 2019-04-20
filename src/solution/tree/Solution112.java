package solution.tree;

/**
 * 判断路径和是否等于一个数
 */
public class Solution112 {
    private boolean has = false;
    private int target;
    public boolean hasPathSum(TreeNode root, int sum) {
        dfs(root, sum);
        return has;
    }
    public void dfs(TreeNode root, int sum) {
        if (root == null) {
            sum = target;
            return ;
        }
        sum -= root.val;
        //判断是否是叶节点
        if (root.left == null && root.right == null) {
            //根据sum的值返回，为0时则找到一个解
            if (sum == 0) {
                has = true;
                return ;
            }
        }
        dfs(root.left, sum);
        dfs(root.right, sum);
        //复原
        sum += root.val;
    }
}
