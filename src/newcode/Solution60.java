package newcode;

import java.util.ArrayList;

/**
 * 和为s的两个数字
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，
 * 如果有多对数字的和等于S，输出两个数的乘积最小的。
 */
public class Solution60 {
    public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        int l = 0, r = array.length-1;
        int minMult = Integer.MAX_VALUE;
        ArrayList<Integer> res = new ArrayList(2);
        while (l < r) {
            //找到一个解
            if (array[l] + array[r] == sum) {
                //判断是否是乘积最小的
                if (array[l]*array[r] < minMult) {
                    //更新答案
                    if (res.size()==0) {
                        res.add(array[l]);
                        res.add(array[r]);
                    }
                    res.set(0, array[l]);
                    res.set(1, array[r]);
                    minMult = array[l]*array[r];
                }
                l++;
                r--;
            } else if (array[l] + array[r] > sum) {
                r--;
            } else {
                l++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution60 s = new Solution60();
        ArrayList<Integer> integers = s.FindNumbersWithSum(new int[]{1, 2, 3, 4, 5, 6, 7}, 3);
        System.out.println(integers);
    }
}
