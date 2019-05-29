package solution.search;

import java.util.ArrayList;
import java.util.List;

/**
 * IP 地址划分
 * https://leetcode.com/problems/restore-ip-addresses/
 */
class Solution93 {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() == 0)
            return res;
        doRestore(0, new StringBuilder(), res, s);
        return res;
    }

    private void doRestore (int num, StringBuilder sbAddress, List<String> addresses, String s) {
        if (num == 4 || s.length() == 0) {
            if (num == 4 && s.length() == 0)
                addresses.add(sbAddress.toString());
            return;
        }

        for (int i=0; i<s.length() && i<=2; i++) {
            if (i != 0 && s.charAt(0) == '0')
                break;
            String part = s.substring(0, i+1);
            if (Integer.valueOf(part) <= 255) {
                if (sbAddress.length() != 0) {
                    part = "." + part;
                }
                sbAddress.append(part);
                doRestore(num+1, sbAddress, addresses, s.substring(i+1));
                sbAddress.delete(sbAddress.length()-part.length(), sbAddress.length());
            }
        }
    }

    public static void main(String[] args) {
        String s = "010010";
        Solution93 solution93 = new Solution93();
        solution93.restoreIpAddresses(s);
    }
}