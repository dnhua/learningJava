package math;

import java.util.Scanner;

/**
 * 最大公约数
 */
public class Gcd {
    int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public int gcd2(int a, int b) {
        if (a < b) {
            return gcd(b, a);
        }
        if (b == 0) {
            return a;
        }
        boolean isAEven = isEven(a), isBEven = isEven(b);
        if (isAEven && isBEven) {
            return 2 * gcd(a >> 1, b >> 1);
        } else if (isAEven && !isBEven) {
            return gcd(a >> 1, b);
        } else if (!isAEven && isBEven) {
            return gcd(a, b >> 1);
        } else {
            return gcd(b, a - b);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        int j = sc.nextInt();
        Gcd g = new Gcd();
        System.out.println(g.gcd(i,j));
    }
}
