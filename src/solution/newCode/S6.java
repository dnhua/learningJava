package solution.newCode;

import java.util.ArrayList;

public class S6 {
    ArrayList<Integer> ret = new ArrayList<>();
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        dfs(root);
        return ret;
    }

    public void dfs(TreeNode root) {
        if (root == null)
            return ;
        dfs(root.left);
        dfs(root.right);
        ret.add(root.val);
    }
}
