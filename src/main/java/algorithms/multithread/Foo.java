package algorithms.multithread;

import java.util.concurrent.CountDownLatch;

/**
 * Created by yangyuan on 2020/1/13.
 * 1114. 按序打印
 */
public class Foo {

    CountDownLatch c2;
    CountDownLatch c3 ;

    public Foo() {
        c2 = new CountDownLatch(1);
        c3 = new CountDownLatch(1);
    }

    public void first(Runnable printFirst) throws InterruptedException {
        printFirst.run();
        c2.countDown();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        c2.await();
        printSecond.run();
        c3.countDown();
    }

    public void third(Runnable printThird) throws InterruptedException {
        c3.await();
        printThird.run();
    }
}
