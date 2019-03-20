package newcode;

/**
 * 数组中出现次数超过一半的数字
 * 如果有符合条件的数字，则它出现的次数比其他所有数字出现的次数和还要多。
 * 在遍历数组时保存两个值：一是数组中一个数字，一是次数。遍历下一个数字
 * 时，若它与之前保存的数字相同，则次数加1，否则次数减1；若次数为0，则
 * 保存下一个数字，并将次数置为1。遍历结束后，所保存的数字即为所求。然
 * 后再判断它是否符合条件即可。
 */
public class Solution40 {
    public int MoreThanHalfNum_Solution(int [] array) {
        int res = array[0];
        int cnt = 1;
        for (int i=0; i<array.length; i++) {
            if (cnt == 0) {
                res = array[i];
                cnt = 1;
            }
            cnt = res == array[i] ? cnt+1 : cnt-1;
        }
        cnt = 0;
        for (int i=0; i<array.length; i++) {
            if (array[i] == res)
                cnt++;
        }
        return cnt > array.length / 2 ? res : 0;
    }
}
