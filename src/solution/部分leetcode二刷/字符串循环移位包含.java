package solution.部分leetcode二刷;

import java.util.Scanner;

public class 字符串循环移位包含 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        System.out.println(contain(s1, s2));
    }

    public static boolean contain(String s1, String s2) {
        //s1是否能够包含住s2
        if (s1.length() < s2.length())
            return false;
        int n1 = s1.length();
        String s = s1 + s1;

        //判断s是否能够包含住s2
        return kmp(s, s2) != -1;
    }

    public static int kmp(String s, String s2) {
        char[] s_arr = s.toCharArray();
        char[] t_arr = s2.toCharArray();
        int[] next = getNextArray(t_arr);
        int i = 0, j = 0;
        while (i<s_arr.length && j<t_arr.length){
            if(j == -1 || s_arr[i]==t_arr[j]){
                i++;
                j++;
            }
            else
                j = next[j];
        }
        if(j == t_arr.length)
            return i-j;
        else
            return -1;
    }

    public static int[] getNextArray(char[] t) {
        int[] next = new int[t.length];
        next[0] = -1;
        next[1] = 0;
        int k;
        for (int j=2; j<t.length; j++) {
            k = next[j-1];
            while (k != -1) {
                if (t[j-1] == t[k]) {
                    next[j] = k + 1;
                } else {
                  k = next[k];
                }
                next[j] = 0;
            }
        }
        return next;
    }
}
