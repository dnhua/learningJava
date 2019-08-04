package 公司真题.大疆提前批;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String string1 = sc.nextLine();
        String string2 = sc.nextLine();
        char[] str1 = string1.toCharArray();
        char[] str2 = string2.toCharArray();
        int[][] dp = new int[str1.length][str2.length];
        for(int i = 0;i < str1.length;i++){
            if(str1[i] == str2[0]){
                dp[i][0] = 1;
            }
        }
        for(int j = 1;j < str2.length;j++){
            if(str2[j] == str1[0]){
                dp[0][j] = 1;
            }
        }
        int max = 0;
        int idx = 0;
        for(int i = 1;i < str1.length;i++){
            for(int j = 1;j < str2.length;j++){
                if(str1[i] == str2[j]){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                if (dp[i][j] > max) {
                    idx = i;
                    max = dp[i][j];
                }
            }
        }
        String s = string1.substring(idx - max + 1, idx + 1);
        System.out.println(s);
    }
}