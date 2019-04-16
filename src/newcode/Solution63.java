package newcode;

import java.util.Arrays;

/**
 * 扑克牌顺子
 * 五张牌，其中大小鬼为癞子，牌面大小为 0。判断这五张牌是否能组成顺子。
 */
public class Solution63 {
    public boolean isContinuous(int [] numbers) {
        //0.如果牌的数量小于5，则返回false
        if (numbers.length < 5)
            return false;
        int cnt = 0;
        //1.统计癞子的数量
        for (int num : numbers) {
            if (num == 0)
                cnt++;
        }

        Arrays.sort(numbers);

        //2.尝试组成顺子，用癞子来填空
        for (int i=cnt+1; i<numbers.length; i++) {
            //如果当前的值与上一个值相同，则不可以组成顺子
            if (numbers[i] == numbers[i-1])
                return false;
            cnt -= numbers[i] - numbers[i-1] - 1;
        }
        return cnt >= 0;
    }
}
