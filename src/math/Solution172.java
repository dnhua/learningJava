package math;

/**
 * 统计阶乘尾部有多少个 0
 * 172. Factorial Trailing Zeroes (Easy)
 * https://leetcode.com/problems/factorial-trailing-zeroes/description/
 * 尾部的 0 由 2 * 5 得来，2 的数量明显多于 5 的数量，因此只要统计有多少个 5 即可。
 *
 * 对于一个数 N，它所包含 5 的个数为：N/5 + N/52 + N/53 + ...，其中 N/5 表示不大于
 * N 的数中 5 的倍数贡献一个 5，N/52 表示不大于 N 的数中 52 的倍数再贡献一个 5 ...。
 *
 * public int trailingZeroes(int n) {
 *     return n == 0 ? 0 : n / 5 + trailingZeroes(n / 5);
 * }
 *
 * 如果统计的是 N! 的二进制表示中最低位 1 的位置，只要统计有多少个 2 即可，该题目出自
 * 编程之美：2.2 。和求解有多少个 5 一样，2 的个数为 N/2 + N/22 + N/23 + ...
 */
public class Solution172 {
    public int trailingZeroes(int n) {
        return n == 0 ? 0 : n / 5 + trailingZeroes(n / 5);
    }
}
