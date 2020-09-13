package algorithms.other;

import java.util.LinkedList;
import java.util.Objects;

/**
 * Created by yangyuan on 2020/4/18.
 * 面试题59 - II. 队列的最大值
 *
 * 请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。

 若队列为空，pop_front 和 max_value 需要返回 -1

 */
public class MaxQueue {

    LinkedList<Integer> data;

    LinkedList<Integer> max;

    public MaxQueue() {
        this.data = new LinkedList();
        this.max = new LinkedList();
    }
    //递减队列
    public int max_value() {
        if (max.isEmpty()){
            return -1;
        }
        return max.peekFirst();
    }

    public void push_back(int value) {
        while (!max.isEmpty() && max.peekLast() < value) max.removeLast();
        max.addLast(value);
        data.addLast(value);
    }

    public int pop_front() {
        //需要注意的一点是 下面不能用   max.peekFirst() == data.peekFirst() 来判断，不然max.removeFirst()不会被调用的。。。
        if (!max.isEmpty() && Objects.equals(max.peekFirst(), data.peekFirst())) max.removeFirst();
        if (data.isEmpty()){
            return -1;
        }
        return data.removeFirst();
    }

    public static void main(String[] args) {
        MaxQueue maxQueue = new MaxQueue();
        maxQueue.push_back(868);
        maxQueue.pop_front();
        maxQueue.pop_front();
        maxQueue.pop_front();
        maxQueue.push_back(525);
        maxQueue.pop_front();
        maxQueue.max_value();
    }
}
