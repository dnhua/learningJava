package solution.string;

import edu.princeton.cs.algs4.StdIn;

/**
 * 编程之美 3.1
 * s1 = AABCD, s2 = CDAA
 * Return : true
 * 给定两个字符串 s1 和 s2，要求判定 s2 是否能够被 s1 做循环移位得到的字符串包含。
 * s1 进行循环移位的结果是 s1s1 的子字符串，因此只要判断 s2 是否是 s1s1 的子字符串即可。
 */
public class Solution3_1 {
    public static void main(String[] args) {
        String s1 = StdIn.readLine();
        String s2 = StdIn.readLine();
        System.out.println("s1:"+s1);
        System.out.println("s2:"+s2);
        System.out.println(subString(s1, s2));
    }

    public static boolean subString(String s1, String s2) {
        s1 += s1;
        return s1.contains(s2);
    }
}
