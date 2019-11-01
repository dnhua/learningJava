package solution.newCode;

import java.util.ArrayList;

public class S7 {
    private ArrayList<Integer> ret = new ArrayList<>();
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        dfs(root);
        return ret;
    }
    public void dfs(TreeNode root) {
        if (root == null)
            return ;
        ret.add(root.val);
        dfs(root.left);
        dfs(root.right);
    }
}
