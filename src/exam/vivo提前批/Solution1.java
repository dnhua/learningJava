package exam.vivo提前批;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * vivo2019提前批笔试第一题：
 * 将array1中在array2中的数字去掉。
 */
public class Solution1 {
    public static void solution(int[] array1, int[] array2) {
        Set<Integer> set2 = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        for (int j : array2)
            set2.add(j);
        for (int i : array1) {
            if (!set2.contains(i))
                list.add(i);
        }
        for (int i=0; i<list.size(); i++)
            System.out.print(list.get(i)+" ");
    }

    public static void main(String[] args) {
        //测试
    }
}
