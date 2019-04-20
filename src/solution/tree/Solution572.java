package solution.tree;

/**
 * 子树
 */
public class Solution572 {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s == null) return false;
        return subTree(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
    }
    public boolean subTree(TreeNode s, TreeNode t) {
        if (s == null && t != null) return false;
        //匹配完成,找到一颗子树
        if (t == null && s == null) {
            return true;
        }
        //如果已经不匹配了,直接返回
        //case1: s != null && t == null
        if (s != null && t == null)
            return false;
        //case2: s.val != t.val
        if (s.val != t.val)
            return false;
        //继续往后匹配
        return subTree(s.left, t.left) && subTree(s.right, t.right);
    }
}
