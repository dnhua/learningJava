package newcode;

import java.util.ArrayList;

/**
 * 和为s的连续正数序列
 * 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。
 * 但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。没多久,
 * 他就得到另一组连续正数和为100的序列:18,19,20,21,22。现在把问题交给你,你能不能也很快的
 * 找出所有和为S的连续正数序列? Good Luck!
 */
public class Solution61 {
    public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int l = 1;
        int r = 2;
        int curSum = 3;
        while (r < sum) {
            //找到一个解
            if (curSum == sum) {
                ArrayList<Integer> list = new ArrayList<>();
                for (int i=l; i<=r; i++) {
                    list.add(i);
                }
                res.add(list);
                curSum -= l;
                l++;
                r++;
                curSum += r;
            } else if (curSum < sum) {
                r++;
                curSum += r;
            } else {
                curSum -= l;
                l++;
            }
        }
        return res;
    }
}
