package solution.binarySearch;

/**
 * 第一个错误的版本
 * 278. First Bad Version (Easy)
 *
 * 题目描述：给定一个元素 n 代表有 [1, 2, ..., n] 版本，在第 x 位置开始出现错误版本，导致后面的版本都错误。可以调用 isBadVersion(int x) 知道某个版本是否错误，要求找到第一个错误的版本。
 *
 * 如果第 m 个版本出错，则表示第一个错误的版本在 [l, m] 之间，令 h = m；否则第一个错误的版本在 [m + 1, h] 之间，令 l = m + 1。
 *
 * 因为 h 的赋值表达式为 h = m，因此循环条件为 l < h。
 */
public class Solution278 {
    public int firstBadVersion(int n) {
        int l = 1, h = n;
        while (l < h) {
            int mid = l + (h - l) / 2;
            if (isBadVersion(mid)) {
                h = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    public boolean isBadVersion(int num) {
        //some logic here
        return true;
    }
}
