package newcode;

import org.junit.jupiter.api.Test;

/**
 * 翻转单词顺序列
 * 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。
 * 同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。例
 * 如，“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，正确
 * 的句子应该是“I am a student.”。Cat对一一的翻转这些单词顺序可不在行，你能帮
 * 助他么？
 */
public class Solution62 {
    /**
     * 这段代码有问题，不能通过所有的案例，遇到有奇怪空格的案例就凉了
     * @param str
     * @return
     */
    public String ReverseSentence1(String str) {
        if (str==null || str.trim().equals(""))
            return str;
        String[] strArray = str.split(" ");
        StringBuffer sb = new StringBuffer();
        for (int i=strArray.length-1; i>=0; i--) {
            sb.append(strArray[i]);
            if (i != 0)
                sb.append(" ");
        }
        return sb.toString();
    }

    public String ReverseSentence(String str) {
        int n = str.length();
        char[] chars = str.toCharArray();
        int i = 0, j = 0;
        while (j <= n) {
            if (j == n || chars[j] == ' ') {
                reverse(chars, i, j - 1);
                i = j + 1;
            }
            j++;
        }
        reverse(chars, 0, n - 1);
        return new String(chars);
    }

    private void reverse(char[] c, int i, int j) {
        while (i < j)
            swap(c, i++, j--);
    }

    private void swap(char[] c, int i, int j) {
        char t = c[i];
        c[i] = c[j];
        c[j] = t;
    }

    @Test
    void test(){
        System.out.println(ReverseSentence(" "));
    }
}
