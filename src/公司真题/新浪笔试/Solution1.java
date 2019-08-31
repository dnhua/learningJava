package 公司真题.新浪笔试;

/**
 * 比较版本号大小
 */
public class Solution1 {
    public String getMinVersion(String[] list) {
        // 在这里编写代码
        String ret = list[0];
        for (String s : list) {
            if (compareV(ret, s) == 1)
                ret = s;
        }
        return ret;
    }

    public int compareV(String v1, String v2) {
        if (v1 == null || v2 == null)
            return 0;
        String[] str1 = v1.split("\\.");
        String[] str2 = v2.split("\\.");

        for (int i=0; i<str1.length || i<str2.length;) {
            int n1 = i<str1.length ? Integer.valueOf(str1[i]) : 0;
            int n2 = i<str2.length ? Integer.valueOf(str2[i]) : 0;
            if (n1 > n2) return 1;
            else if (n1 < n2) return -1;
            else i++;
        }
        return 0;
    }
}
