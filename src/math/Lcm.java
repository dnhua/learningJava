package math;

/**
 * 最小公倍数
 * 最小公倍数为两数的乘积除以最大公约数。
 */
public class Lcm {
    int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
