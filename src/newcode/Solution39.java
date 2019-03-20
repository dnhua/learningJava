package newcode;

import java.util.ArrayList;
import java.util.TreeSet;

/**
 * 字符串的排列
 * 输入一个字符串，按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串 abc，则打印出由字符 a, b, c 所能排列出来
 * 的所有字符串 abc, acb, bac, bca, cab 和 cba。
 */
public class Solution39 {
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> res = new ArrayList<>();
        if (str == null || str.length() == 0)
            return res;
        TreeSet<String> set = new TreeSet<>();
        char[] schar = str.toCharArray();
        permutation(schar, 0, set);
        res.addAll(set);
        return res;
    }

    private void permutation(char[] schar, int begin, TreeSet<String> set) {
        if (schar == null || schar.length == 0 || begin > schar.length-1)
            return;
        if (begin == schar.length - 1)
            set.add(String.valueOf(schar)) ;
        else {
            for (int i=begin; i<=schar.length-1; i++) {
                swap(schar, begin, i);
                permutation(schar, begin+1, set);
                swap(schar, begin, i);
            }
        }
    }

    private void swap(char[] x, int a, int b) {
        char t = x[a];
        x[a] = x[b];
        x[b] = t;
    }
}
