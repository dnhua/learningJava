package newcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * 把数组排成最小的数
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，
 * 打印能拼接出的所有数字中最小的一个。例如输入数组{3，32，321}，
 * 则打印出这三个数字能排成的最小数字为321323。
 */
public class Solution47 {
    public String PrintMinNumber(int [] numbers) {
        if (numbers == null || numbers.length==0)
            return "";
        String[] sArray = new String[numbers.length];
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<numbers.length; i++)
            sArray[i] = numbers[i]+"";
        Arrays.sort(sArray, (s1, s2)->(s1+s2).compareTo(s2+s1));
        for (String s : sArray)
            sb.append(s);
        return sb.toString();
    }

    @Test
    public void test(){
        String s = PrintMinNumber(new int[]{1, 4, 3, 2, 5});
        System.out.println(s);
    }
}
