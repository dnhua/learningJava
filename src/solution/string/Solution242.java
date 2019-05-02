package solution.string;

/**
 * 两个字符串包含的字符是否完全相同
 * 242. Valid Anagram (Easy)
 * s = "anagram", t = "nagaram", return true.
 * s = "rat", t = "car", return false.
 * 可以用 HashMap 来映射字符与出现次数，然后比较两个字符串出现的字符数量是否相同。
 *
 * 由于本题的字符串只包含 26 个小写字符，因此可以使用长度为 26 的整型数组对字符串出现的字符进行统计，不再使用 HashMap。
 */
public class Solution242 {
    public boolean isAnagram(String s, String t) {
        int[] cnts = new int[26];
        for (char c : s.toCharArray()) {
            cnts[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            cnts[c - 'a']--;
        }
        for (int cnt : cnts) {
            if (cnt != 0) {
                return false;
            }
        }
        return true;
    }
}
