package algorithms.multithread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by yangyuan on 2022/3/27.
 */
public class ReentrantLockTest {


    public static void main(String[] args) {

        ReentrantLock reentrantLock = new ReentrantLock();

        Thread thread = new Thread(() -> {
            reentrantLock.lock();
            try {
                System.out.println("thread1 get lock");
                TimeUnit.SECONDS.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                reentrantLock.unlock();;
            }

        });
        thread.setName("yy-1");
        thread.start();
        Thread thread2 = new Thread(() -> {
            reentrantLock.lock();
            try {
                System.out.println("thread2 get lock");
                TimeUnit.SECONDS.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                reentrantLock.unlock();
            }
            });
        thread2.setName("yy-2");
        thread2.start();

    }


}
