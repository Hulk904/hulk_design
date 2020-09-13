package algorithms.graph;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by yangyuan on 2020/4/1.
 */
public class Broker {

    private LinkedList<Integer> queue = new  LinkedList ();

    public Broker(int capacity){
        this.capacity = capacity;
    }

    int capacity;

    Lock lock = new ReentrantLock();

    Condition notEmpty = lock.newCondition();

    Condition notFull = lock.newCondition();



    public Integer consume() throws InterruptedException {
        lock.lock();
        try{
            while (queue.isEmpty()){
                notEmpty.await();
            }
            int res = queue.removeFirst();
            capacity--;
            notFull.signalAll();
            return res;
        } finally {
            lock.unlock();
        }
    }

    public void provider(Integer item) throws InterruptedException {
        lock.lock();
        try {
            while (queue.size() >= capacity){
                notFull.wait();
            }
            queue.addLast(item);
            capacity++;
            notEmpty.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public int size(){
        lock.lock();
        try {
            return queue.size();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Broker broker = new Broker(100);
        broker.provider(123);
        System.out.println(broker.consume());
    }

}
