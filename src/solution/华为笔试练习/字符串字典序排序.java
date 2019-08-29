package solution.华为笔试练习;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class 字符串字典序排序 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.valueOf(sc.nextLine());
        ArrayList<String> sArray = new ArrayList<>();
        //数据准备
        for (int i=0; i<N; i++) {
            sArray.add(sc.nextLine());
        }
        Collections.sort(sArray);
        for (String s : sArray) {
            System.out.println(s);
        }
    }
}
