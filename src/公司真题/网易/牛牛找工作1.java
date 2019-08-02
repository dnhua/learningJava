package 公司真题.网易;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class 牛牛找工作1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int M = in.nextInt();
        Map<Integer, Integer> work = new TreeMap<>();
        for (int i = 0; i < N; i++) {
            int k = in.nextInt();
            int v = in.nextInt();
            if (!work.containsKey(k)) {
                work.put(k, v);
            } else if (work.get(k) < v) {
                work.put(k, v);
            }
        }
        int[] a = new int[M];
        for (int i = 0; i < M; i++) {
            a[i] = in.nextInt();
            if (!work.containsKey(a[i])) work.put(a[i], 0);
        }
        int tmp = 0;
        for (Map.Entry<Integer, Integer> ent: work.entrySet()) {
            int v = ent.getValue();
            if (v < tmp) {
                ent.setValue(tmp);
            } else {
                tmp = v;
            }
        }
        for (int i = 0; i < M; i++) {
            System.out.println(work.get(a[i]));
        }
    }
}
