package solution.部分leetcode二刷;

import java.util.Scanner;

public class 最长公共子序列 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();

        String[] sv1 = s1.split(" ");
        String[] sv2 = s2.split(" ");
        int[] nums1 = new int[sv1.length];
        int[] nums2 = new int[sv2.length];

        for (int i=0; i<nums1.length; i++) {
            nums1[i] = Integer.valueOf(sv1[i]);
        }

        for (int i=0; i<nums2.length; i++) {
            nums2[i] = Integer.valueOf(sv2[i]);
        }

        System.out.println(lengthOfLCS(nums1, nums2));
    }

    public static int lengthOfLCS(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0)
            return 0;
        int n1 = nums1.length, n2 = nums2.length;
        int[][] dp = new int[n1+1][n2+1];
        for (int i=1; i<n1+1; i++) {
            for (int j=1; j<n2+1; j++) {
                if (nums1[i-1] == nums2[j-1]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[n1][n2];
    }
}
