package math;

import java.util.ArrayList;
import java.util.List;

/**
 * 生成素数序列
 * https://leetcode.com/problems/count-primes/description/
 * 204. Count Primes (Easy)
 * 埃拉托斯特尼筛法在每次找到一个素数时，将能被素数整除的数排除掉。
 */
public class Solution204 {
    //超时了
    public int countPrimes(int n) {
        List<Integer> res = new ArrayList<>();
        forout:
        for (int i=2; i<n; i++) {
            if (i <= 3) {
                res.add(i);
                continue;
            }
            for (int num : res) {
                if (i % num == 0)
                    continue forout;
            }
            res.add(i);
        }
        return res.size();
    }

    //通过去除法来做
    public int countPrimes2(int n) {
        boolean[] notPrimes = new boolean[n];
        int cnt = 0;
        for (int i=2; i<n; i++) {
            if (notPrimes[i])
                continue;
            cnt++;
            //内部循环去非素数
            for (long j=(long)i*i; j<n; j += i) {
                notPrimes[(int)j] = true;
            }
        }
        return cnt;
    }
}
