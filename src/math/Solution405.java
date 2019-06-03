package math;

/**
 * 16进制
 */
public class Solution405 {
    char[] map = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    public String toHex(int num) {
        if (num == 0)
            return "0";
        StringBuilder sb = new StringBuilder();
        boolean negative = num < 0 ? true : false;
        if (negative)
            num = -num;
        while (num != 0) {
            sb.append(map[num%16]);
            num /= 16;
        }
        String s = sb.reverse().toString();
        return negative ? "-"+s : s;
    }

    public String toHex2(int num){
        if (num == 0) return "0";
        StringBuilder sb = new StringBuilder();
        while (num != 0) {
            sb.append(map[num & 0b1111]);
            num >>>= 4; // 因为考虑的是补码形式，因此符号位就不能有特殊的意义，需要使用无符号右移，左边填 0
        }
        return sb.reverse().toString();
    }
}
