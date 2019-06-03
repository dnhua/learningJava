package math;

/**
 * 7 进制
 * https://leetcode.com/problems/base-7/
 */
public class Solution504 {
    public String convertToBase7(int num) {
        if (num == 0)
            return "0";
        StringBuilder sb = new StringBuilder();
        boolean negative = num < 0 ? true : false;
        if (negative)
            num = -num;
        while (num != 0) {
            sb.append(num%7);
            num /= 7;
        }
        String s = sb.reverse().toString();
        return negative ? "-"+s : s;
    }

    public String convertToBase7_2(int num) {
        return Integer.toString(num, 7);
    }
}
