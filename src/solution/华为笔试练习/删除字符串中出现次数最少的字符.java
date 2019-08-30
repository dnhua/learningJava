package solution.华为笔试练习;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 删除字符串中出现次数最少的字符 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String s = sc.nextLine();
            //HashMap统计次数
            Map<Character, Integer> map = new HashMap<>();
            for (Character c : s.toCharArray()) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }

            //找到最小的次数
            int minTimes = Integer.MAX_VALUE;
            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                if (entry.getValue() < minTimes)
                    minTimes = entry.getValue();
            }

            //去字符串
            StringBuilder sb = new StringBuilder();
            for (int i=0; i<s.length(); i++) {
                if (map.get(s.charAt(i)) != minTimes) {
                    sb.append(s.charAt(i));
                }
            }

            System.out.println(sb.toString());
        }

    }
}
