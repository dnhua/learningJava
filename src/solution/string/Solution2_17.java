package solution.string;

import edu.princeton.cs.algs4.StdIn;

/**
 * 编程之美 2.17
 * s = "abcd123" k = 3
 * Return "123abcd"
 * 将字符串向右循环移动 k 位。
 * 将 abcd123 中的 abcd 和 123 单独翻转，得到 dcba321，然后对整个字符串进行翻转，
 * 得到 123abcd。
 */
public class Solution2_17 {
    public static void main(String[] args) {
        String s = StdIn.readLine();
        int k = StdIn.readInt();
        System.out.println(getResult(s, k));
    }

    public static String getResult(String s, int k) {
        char[] chars = s.toCharArray();
        swap(chars, chars.length - k, chars.length - 1);
        swap(chars,0,chars.length - k - 1);
        swap(chars,0,chars.length - 1);
        return new String(chars);
    }

    public static void swap(char[] chars, int idx1, int idx2) {
        while (idx1 < idx2) {
            char tem = chars[idx1];
            chars[idx1] = chars[idx2];
            chars[idx2] = tem;
            idx1++;
            idx2--;
        }
    }
}
