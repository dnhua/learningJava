package math;

/**
 * 26进制
 */
public class Solution168 {
    public String convertToTitle(int n) {
        if (n == 0) {
            return "";
        }
        n--;
        return convertToTitle(n / 26) + (char) (n % 26 + 'A');
    }
}
