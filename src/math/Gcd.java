package math;

import java.util.Scanner;

/**
 * 最大公约数
 */
public class Gcd {
    int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        int j = sc.nextInt();
        Gcd g = new Gcd();
        System.out.println(g.gcd(i,j));
    }
}
