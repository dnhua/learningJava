package math;

/**
 * 最大公约数
 */
public class Gcd {
    int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
