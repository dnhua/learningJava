package 公司真题.东方财富;

import java.util.Scanner;

public class Solution1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] sArray = s.split(" ");
        String s1 = sArray[0];
        String s2 = sArray[1];
        String s3 = sArray[2];

        //begin
//        int l1 = 0, l2 = 0, l3 = 0;
//        boolean flag = true;
//        while (l1 < s1.length() && l2 < s2.length() && l3 < s3.length()) {
//            if (s3.charAt(l3) == s.charAt(l1)) {
//                l1++;
//                l3++;
//                continue;
//            } else if(s3.charAt(l3) == s.charAt(l2)){
//                l2++;
//                l3++;
//            } else {
//                flag = false;
//                break;
//            }
//        }
        boolean flag = help(s1, s2, s3);
        if (flag) {
            System.out.println("TRUE");
        } else {
            System.out.println("FALSE");
        }
    }

    public static boolean help(String a, String b, String c) {
        if (c.length()!=(a.length()+b.length()))
            return false;
        if (c.length() == 0)
            return true;
        if (a.length() == 0)
            return b.equals(c);
        if (b.length() == 0)
            return a.equals(c);
        if (c.charAt(0) == a.charAt(0) && c.charAt(0) != b.charAt(0)) {
            c = c.substring(1, c.length());
            a = a.substring(1, a.length());
            return help(a, b, c);
        }else if (c.charAt(0) == b.charAt(0) && c.charAt(0) != a.charAt(0)) {
            c = c.substring(1, c.length());
            b = b.substring(1, b.length());
            return help(a, b, c);
        }else if (c.charAt(0) == b.charAt(0) && c.charAt(0) == a.charAt(0)) {
            c = c.substring(1, c.length());
            String temp_a = a;
            String temp_b = b;
            a = a.substring(1, a.length());
            b = b.substring(1, b.length());
            return help(a, temp_b, c) || help(temp_a, b, c);
        } else {
            return false;
        }
    }

    public static boolean getFlag(String s1, String s2, String s3) {
        if (s1.length() == 0 && s2.length() == 0 && s3.length() == 0)
            return true;
        if (s1.length() == 0 && s2.length() == 0 && s3.length() != 0)
            return false;
        if (s3.length() == 0 && (s1.length() != 0 || s2.length() != 0))
            return false;

        if (s3.charAt(0) == s1.charAt(0) && s3.charAt(0) == s3.charAt(0)) {
            return getFlag(s1.substring(1, s1.length()), s2, s3) ||
                    getFlag(s1, s2.substring(1, s2.length()), s3);
        }

        if (s3.charAt(0) == s1.charAt(0))
            return getFlag(s1.substring(1, s1.length()), s2, s3);

        if (s3.charAt(0) == s2.charAt(0))
            return getFlag(s1, s2.substring(1, s2.length()), s3);

        return false;
    }

}
