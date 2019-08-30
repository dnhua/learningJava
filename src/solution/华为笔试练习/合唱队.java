package solution.华为笔试练习;

import java.util.*;

public class 合唱队 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int N = Integer.valueOf(sc.nextLine());
            List<Integer> nums = new ArrayList<>();
            String[] s = sc.nextLine().split(" ");
            for (int i=0; i<N; i++) {
                nums.add(Integer.valueOf(s[i]));
            }
            int[] lis1 = lis(nums);
            Collections.reverse(nums);
            int[] lis2 = lis(nums);

            int[] lis = new int[N];
            int ret = Integer.MIN_VALUE;
            for (int i=0; i<N; i++) {
                lis[i] = lis1[i] + lis2[N-i-1];
                ret = Math.max(ret, lis[i]);
            }

            System.out.println(N - ret + 1);
        }
    }

    public static int[] lis(List<Integer> nums) {
        int n = nums.size();
        int[] dp = new int[n];
        for (int i=0; i<n; i++) {
            int max = 1;
            for (int j=0; j<i; j++) {
                if (nums.get(i) > nums.get(j))
                    max = Math.max(max, dp[j] + 1);
            }
            dp[i] = max;
        }

        return dp;
    }
}
