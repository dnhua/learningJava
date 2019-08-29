package solution.华为笔试练习;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class 合并表记录 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] data = new int[N][2];
        //数据准备
        for (int i=0; i<N; i++) {
            data[i][0] = sc.nextInt();
            data[i][1] = sc.nextInt();
        }

        //TreeMap处理数据
        Map<Integer, Integer> map = new TreeMap<>();
        for (int i=0; i<N; i++) {
            map.put(data[i][0], map.getOrDefault(data[i][0], 0) + data[i][1]);
        }

        //输出
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey()+" "+entry.getValue());
        }
    }
}
