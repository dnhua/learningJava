package solution.string;

import edu.princeton.cs.algs4.StdIn;

/**
 * s = "I am a student"
 * Return "student a am I"
 * 将每个单词翻转，然后将整个字符串翻转
 */
public class Solution_wordsReverse {
    public static void main(String[] args) {
        String s = StdIn.readLine();
        System.out.println(reverseSentence(s));
        System.out.println(s);
    }

    public static String reverseSentence(String sinput) {
        String[] split = sinput.split("\\s+");  //这里一定要是\\s+，代表匹配任意多个字符串
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<split.length; i++) {
            String s = split[i];
            s = reverse(s, 0, s.length()-1);
            sb.append(s+" ");
        }
        String res = sb.toString();
        res = res.trim();   //去掉头尾空格
        return reverse(res, 0, res.length()-1);
    }

    public static String reverse(String s, int idx1, int idx2) {
        char[] chars = s.toCharArray();
        while (idx1 < idx2) {
            char tem = chars[idx1];
            chars[idx1] = chars[idx2];
            chars[idx2] = tem;
            idx1++;
            idx2--;
        }
        return new String(chars);
    }
}
