package solution.华为笔试练习;

import java.util.Scanner;

public class 购物单 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int money = sc.nextInt();
        int N = sc.nextInt();
        int[] v = new int[N];   //价格
        int[] p = new int[N];   //重要程度
        int[] q = new int[N];   //主键编号
        //数据读取
        for (int i=0; i<N; i++) {
            v[i] = sc.nextInt();
            p[i] = sc.nextInt() * v[i];
            q[i] = sc.nextInt();
        }

        //0-1背包
        int[][] dp = new int[N+1][money+1];
        for (int i=1; i<=N; i++) {
            int value = v[i-1], pp = p[i-1];
            for (int j=1; j<=money; j++) {
                if (q[i-1] == 0) {    //主键
                    if (j >= value)
                        dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-value] + pp);
                } else {
                    if (j >= value + p[q[i-1]-1]) {
                        dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-value] + pp);
                    }
                }
            }
        }

        System.out.println(dp[N][money]);
    }
}
