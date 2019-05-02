package solution.string;

import edu.princeton.cs.algs4.StdIn;

public class Solution_wordsReverse2 {
    public static void main(String[] args) {
        String s = StdIn.readLine();
        System.out.println(reverseSentence(s));
        System.out.println(s);
    }

    public static String reverseSentence(String sinput) {
        char[] chars = sinput.toCharArray();
        int idx1 = 0;
        int idx2 = 0;
        while (true) {
            idx1 = findnext(chars, idx2, "a-z");
            idx2 = findnext(chars, idx1, " ");
            if (idx2 == -1) {
                reverse(chars, idx1, chars.length-1);
                break;
            }
            reverse(chars, idx1, idx2-1);
        }
        reverse(chars, 0, chars.length-1);
        return new String(chars);
    }

    public static int findnext(char[] chars, int begin, String rex) {
        int oldid = begin;
        if (rex.equals(" ")) {   //找到下一个空格位置
            for (int i=begin; i<chars.length; i++) {
                if (chars[i] == ' ') {
                    return i;
                }
            }
        } else {    //找到下一个单词的初始位置
            if (begin == 0)
                return 0;
            for (int i=begin; i<chars.length; i++) {
                if (chars[i] != ' ' && chars[oldid] == ' ')
                    return i;
                oldid = i;
            }
        }
        return -1;
    }

    public static void reverse(char[] chars, int idx1, int idx2) {
        while (idx1 < idx2) {
            char tem = chars[idx1];
            chars[idx1] = chars[idx2];
            chars[idx2] = tem;
            idx1++;
            idx2--;
        }
    }
}
