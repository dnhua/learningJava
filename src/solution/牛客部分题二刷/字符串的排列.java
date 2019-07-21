package solution.牛客部分题二刷;

import java.util.ArrayList;
import java.util.TreeSet;

public class 字符串的排列 {
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> ret = new ArrayList<>();
        if (str == null || str.length() == 0)
            return ret;

        TreeSet<String> set = new TreeSet<>();  //牛客网上刷题的时候发现用hashmap输出的顺序会不一样导致样例通不过，用treemap就好
        char[] chars = str.toCharArray();
        permutation(chars, set, 0);
        ret.addAll(set);
        return ret;
    }

    public void permutation(char[] chars, TreeSet<String> set, int begin) {
        if (begin >= chars.length)
            return;
        if (begin == chars.length - 1) {
            set.add(String.valueOf(chars));
        } else {
            for (int i=begin; i<chars.length; i++) {
                swap(chars, begin, i);
                permutation(chars, set, begin+1);
                swap(chars, begin, i);
            }
        }
    }

    public void swap(char[] chars, int i, int j) {
        char tem = chars[i];
        chars[i] = chars[j];
        chars[j] = tem;
    }
}
