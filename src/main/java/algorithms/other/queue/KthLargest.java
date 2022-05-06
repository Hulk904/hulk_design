package algorithms.other.queue;

import java.util.PriorityQueue;

/**
 * Created by yangyuan on 2021/3/14.
 * 703. 数据流中的第 K 大元素
 * 设计一个找到数据流中第 k 大元素的类（class）。注意是排序后的第 k 大元素，不是第 k 个不同的元素。

 请实现 KthLargest 类：

 KthLargest(int k, int[] nums) 使用整数 k 和整数流 nums 初始化对象。
 int add(int val) 将

 注意弄清题意， 建立一个小顶堆
 */
public class KthLargest {

    PriorityQueue<Integer> queue = new PriorityQueue<>();
    int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        for (int i:nums){
            queue.add(i);
            if (queue.size() > k){
                queue.poll();
            }
        }
    }

    public int add(int val) {
        queue.add(val);
        if (queue.size() > k){
            queue.poll();
        }
        return queue.peek();
    }
}
