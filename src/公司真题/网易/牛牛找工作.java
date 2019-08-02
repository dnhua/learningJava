package 公司真题.网易;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * 尴尬，只能通过40%
 */
public class 牛牛找工作 {
    public static void main(String[] args) {
        //1.数据处理
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String[] sArr1 = s1.split(" ");
        int N = Integer.valueOf(sArr1[0]);
        int M = Integer.valueOf(sArr1[1]);
        Integer[][] jobs = new Integer[N][2];
        //1.1 jobs
        for (int i=0; i<N; i++) {
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();
            jobs[i][0] = Integer.valueOf(n1);
            jobs[i][1] = Integer.valueOf(n2);
        }
        //1.2 A
        int[] A = new int[M];
        for (int i=0; i<M; i++) {
            int n = sc.nextInt();
            A[i] = n;
        }

        //2.解答
        Arrays.sort(jobs, (o1, o2)->(o1[1].compareTo(o2[1])));
        int[] ret = new int[M];
        for (int i=0; i<M; i++) {
            ret[i] = getJob(jobs, A[i]);
        }
        for (int num : ret)
            System.out.println(num);

    }

    public static int getJob(Integer[][] jobs, int attr) {
        for (int i=jobs.length-1; i>=0; i--) {
            if (attr >= jobs[i][0])
                return jobs[i][1];
        }
        return -1;
    }
}
