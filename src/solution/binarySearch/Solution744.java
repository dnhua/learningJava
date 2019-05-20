package solution.binarySearch;

/**
 * 大于给定元素的最小元素
 * 744. Find Smallest Letter Greater Than Target (Easy)
 *
 * Input:
 * letters = ["c", "f", "j"]
 * target = "d"
 * Output: "f"
 *
 * Input:
 * letters = ["c", "f", "j"]
 * target = "k"
 * Output: "c"
 *
 * 题目描述：给定一个有序的字符数组 letters 和一个字符 target，要求找出 letters 中大于
 * target 的最小字符，如果找不到就返回第 1 个字符。
 */
public class Solution744 {
    public char nextGreatestLetter(char[] letters, char target) {
        int l = 0, r = letters.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (letters[mid] <= target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l < letters.length ? letters[l] : letters[0];
    }
}
