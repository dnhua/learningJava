package solution.top100;

import java.util.Arrays;

/**
 * 621. Task Scheduler
 * Given a char array representing tasks CPU need to do. It contains capital letters A to Z where
 * different letters represent different tasks. Tasks could be done without original order. Each
 * task could be done in one interval. For each interval, CPU could finish one task or just be idle.
 *
 * However, there is a non-negative cooling interval n that means between two same tasks, there
 * must be at least n intervals that CPU are doing different tasks or just be idle.
 *
 * You need to return the least number of intervals the CPU will take to finish all the given tasks.
 *
 *
 *
 * Example:
 *
 * Input: tasks = ["A","A","A","B","B","B"], n = 2
 * Output: 8
 * Explanation: A -> B -> idle -> A -> B -> idle -> A -> B.
 */
public class Solution621 {
    public int leastInterval(char[] tasks, int n) {
        //思路：从答案里看来的解法，可以说是非常巧妙了。第一步计算idle的总数，idle总数加上任务执行的intervals就是答案了
        int[] map = new int[26];
        //统计tasks的次数
        for (char c: tasks)
            map[c - 'A']++;
        Arrays.sort(map);
        //计算idle的总数，附上原文讲解https://leetcode.com/articles/task-scheduler/#
        int maxTime = map[25] - 1, idlesTotal = n * maxTime;
        for (int i=0; i<25; i++) {
            idlesTotal -= Math.min(maxTime, map[i]);
        }
        return idlesTotal > 0 ? idlesTotal + tasks.length : tasks.length;
    }
}
