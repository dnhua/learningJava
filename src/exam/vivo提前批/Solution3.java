package exam.vivo提前批;

/**
 * vivo2019提前批笔试第三题：
 * 小v负责一次活动礼品采购，每一款礼品的受欢迎程度(热度值)各不相同，现给出总金额以及各个礼品的单价
 * 和热度值，且每个礼品只购买一个，如何购买可以使得所有礼品的总热度值最高。
 * 输入：
 * 第一行是一个正整数，表示总金额(不大于1000)
 * 第二行是一个长度为n的正整数数组，表示礼品单价(n不大于100)
 * 第三行是一个长度为n的正整数数组，表示对应礼品的热度值
 * 输出：
 * 一个正整数，表示可以获得的最高总热度值
 *
 * 样例输入：1000
 *           200 600 100 180 300 450
 *           6 10 3 4 5 8
 * 样例输出：21
 */
public class Solution3 {
    public static int soulution(int money, int[] value, int[] hot) {
        if (money <= 0)
            return 0;
        int[][] dp = new int[value.length+1][money+1];

        for (int i=1; i<value.length+1; i++) {
            int v = value[i-1], h = hot[i-1];
            for (int j=1; j<money+1; j++) {
                if (v > j) {
                    dp[i][j] = dp[i-1][j];
                } else {
//                    int temp1 = dp[i-1][j-v]+h;
//                    int temp2 = dp[i-1][j];
//                    dp[i][j] = temp1 > temp2 ? temp1 : temp2;
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-v] + h);
                }
            }
        }
        return dp[value.length][money];
    }

    public static void main(String[] args) {
        int money = 1000;
        int[] value = new int[]{200, 600, 100, 180, 300, 450};
        int[] hot = new int[]{6, 10, 3, 4, 5, 8};
        System.out.println(soulution(money, value, hot));
    }
}
