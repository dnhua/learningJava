package solution.string;

/**
 * 统计二进制字符串中连续 1 和连续 0 数量相同的子字符串个数
 */
public class Solution696 {
    public int countBinarySubstrings2(String s) {
        int len=s.length();
        if(len<=1) return 0;
        char[] sc= s.toCharArray();
        int prevRunLength = 0, curRunLength = 1, res = 0;
        for (int i=1;i<len;i++) {
            if (sc[i] == sc[i-1]) curRunLength++;
            else {
                prevRunLength = curRunLength;
                curRunLength = 1;
            }
            if (prevRunLength >= curRunLength) res++;
        }
        return res;
    }
}
