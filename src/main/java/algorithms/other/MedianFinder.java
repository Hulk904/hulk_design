package algorithms.other;

import java.util.PriorityQueue;

/**
 * Created by yangyuan on 2020/3/23.
 *
 * 295. 数据流的中位数
 *
 * 中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。
 */
public class MedianFinder {

    int count;
    PriorityQueue<Integer> minQueue ;
    PriorityQueue<Integer> maxQueue ;

    /** initialize your data structure here. */
    public MedianFinder() {
        count = 0;
        minQueue = new PriorityQueue<>();
        maxQueue = new PriorityQueue<>((a,b) -> b - a);
    }

    public void addNum(int num) {
        count++;
        minQueue.add(num);
        maxQueue.add(minQueue.poll());
        if (minQueue.size() < maxQueue.size()){
            minQueue.add(maxQueue.poll());
        }
    }

    public double findMedian() {
        if ((count & 1) == 1){//
            return minQueue.peek();
        }
        return (minQueue.peek() + maxQueue.peek())/2.0;
    }
}
