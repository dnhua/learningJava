package solution.top100;

/**
 * 461. Hamming Distance
 * The Hamming distance between two integers is the number of positions at which the
 * corresponding bits are different.
 * Given two integers x and y, calculate the Hamming distance.
 * Note:
 * 0 ≤ x, y < 231.
 * Example:
 * Input: x = 1, y = 4
 * Output: 2
 * Explanation:
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 *        ↑   ↑
 */
public class Solution461 {
    public int hammingDistance(int x, int y) {
        //1.将两个数异或，得到的结果中1的个数就是我们要求的答案
        int xor = x ^ y;
        int cnt = 0;
        //2.统计1的个数
        while (xor != 0) {
            xor = xor & (xor-1);
            cnt++;
        }
        return cnt;
    }
}
