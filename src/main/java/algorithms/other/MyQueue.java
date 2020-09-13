package algorithms.other;

import java.util.Stack;

/**
 * Created by yangyuan on 2020/8/22.
 * 232. 用栈实现队列
 *
 * 使用栈实现队列的下列操作：

 push(x) -- 将一个元素放入队列的尾部。
 pop() -- 从队列首部移除元素。
 peek() -- 返回队列首部的元素。
 empty() -- 返回队列是否为空。

 */
public class MyQueue {
    Stack<Integer> data;
    Stack<Integer> cache;

    /** Initialize your data structure here. */
    public MyQueue() {
        data = new Stack();
        cache = new Stack();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        cache.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (data.isEmpty()){
            while(!cache.isEmpty()){
                data.push(cache.pop());
            }
        }
        return data.pop();
    }

    /** Get the front element. */
    public int peek() {
        if (data.isEmpty()){
            while(!cache.isEmpty()){
                data.push(cache.pop());
            }
        }
        return data.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return data.isEmpty() && cache.isEmpty();
    }
}
