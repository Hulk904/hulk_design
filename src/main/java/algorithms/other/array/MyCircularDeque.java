package algorithms.other.array;

/**
 * Created by yangyuan on 2020/12/26.
 *
 * 641. 设计循环双端队列
 *
 * 设计实现双端队列。
 你的实现需要支持以下操作：

 MyCircularDeque(k)：构造函数,双端队列的大小为k。
 insertFront()：将一个元素添加到双端队列头部。 如果操作成功返回 true。
 insertLast()：将一个元素添加到双端队列尾部。如果操作成功返回 true。
 deleteFront()：从双端队列头部删除一个元素。 如果操作成功返回 true。
 deleteLast()：从双端队列尾部删除一个元素。如果操作成功返回 true。
 getFront()：从双端队列头部获得一个元素。如果双端队列为空，返回 -1。
 getRear()：获得双端队列的最后一个元素。 如果双端队列为空，返回 -1。
 isEmpty()：检查双端队列是否为空。
 isFull()：检查双端队列是否满了。

 */
public class MyCircularDeque {

    int t = 0;
    int h = 0;
    int[] q;

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        q = new int[k + 1];
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if (isFull()) return false;
        h = get(h + 1);
        q[h] = value;
        return true;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (isFull()) return false;
        q[t--] = value;//t指向的地方不放元素。 所以先放元素，然后再++
        t = get(t);
        return true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (isEmpty()) return false;
        h = get(h - 1);
        return true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (isEmpty()) return false;
        t = get(t + 1);
        return true;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        if (isEmpty()) return  -1;
        return q[h];
    }

    /** Get the last item from the deque. */
    public int getRear() {
        if (isEmpty()) return -1;
        return q[get(t + 1)];
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return t == h;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return t == get(h + 1);
    }

    private int get(int x){
        return (x + q.length)%(q.length);
    }
}
