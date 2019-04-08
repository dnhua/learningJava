package newcode;

/**
 * 数组中只出现一次的数字
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次，找出这两个数。
 */
//num1,num2分别为长度为1的数组。传出参数
//将num1[0],num2[0]设置为返回结果
import java.util.*;
public class Solution59 {
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        //最简单的方式是用hashmap统计出现的次数,时间复杂度o(n)
        Map<Integer, Integer> tMap = new HashMap();
        int cnt = 0;
        for (int i=0; i<array.length; i++) {
            if (tMap.get(array[i]) == null)
                tMap.put(array[i], 1);
            else
                tMap.put(array[i], 2);
        }
        for (int i=0; i<array.length; i++) {
            if (tMap.get(array[i]) == 1 && cnt == 0) {
                num1[0] = array[i];
                cnt++;
            }
            if (tMap.get(array[i]) == 1 && cnt == 1) {
                num2[0] = array[i];
            }
        }
    }
}

