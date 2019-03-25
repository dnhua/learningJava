package newcode;

import java.util.PriorityQueue;

/**
 * 数据流中的中位数
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，
 * 那么中位数就是所有数值排序之后位于中间的数值。如果从数据
 * 流中读出偶数个数值，那么中位数就是所有数值排序之后中间两
 * 个数的平均值。我们使用Insert()方法读取数据流，使用GetMe-
 * dian()方法获取当前读取数据的中位数。
 */
public class Solution42 {
    PriorityQueue<Integer> left = new PriorityQueue<>((o1, o2) -> o2 - o1);
    PriorityQueue<Integer> right = new PriorityQueue<>();
    int N = 0;

    public void Insert(Integer num) {
        // 1.偶数，放到大顶堆
        if ((N & 1) == 0) {
            // 1.1.先放到小顶堆里，然后从小顶堆里拿最大的到大顶堆里
            right.add(num);
            left.add(right.poll());
        } else {
            // 2.奇数，放到小顶堆
            left.add(num);
            right.add(left.poll());
        }
        N++;
    }

    public Double GetMedian() {
        if ((N & 1) == 0)
            return (left.peek() + right.peek()) / 2.0;
        else
            return left.peek() * 1.0;
    }
}
