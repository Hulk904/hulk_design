package algorithms.multithread;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by yangyuan on 2020/3/21.
 * 1188. 设计有限阻塞队列
 *
 */
public class BoundedBlockingQueue {

    private Lock lock = new ReentrantLock();

    private Condition notFull = lock.newCondition();

    private Condition notEmpty = lock.newCondition();

    int capacity;

    Deque<Integer> dequeue;

    public BoundedBlockingQueue(int capacity) {
        this.capacity = capacity;
        this.dequeue = new ArrayDeque();
    }

    public void enqueue(int element) throws InterruptedException {
        lock.lock();
        try{
            while (dequeue.size() == capacity){
                notFull.await();
            }
            dequeue.addLast(element);
            notEmpty.signal();
        }finally{
            lock.unlock();
        }
    }

    public int dequeue() throws InterruptedException {
        lock.lock();
        try {
            while (dequeue.size() == 0){
                notEmpty.await();
            }
            int i = dequeue.removeFirst();
            notFull.signal();
            return i;
        }finally{
            lock.unlock();
        }
    }

    public int size() {
        lock.lock();
        try{
            return dequeue.size();
        } finally {
            lock.unlock();
        }
    }
}
