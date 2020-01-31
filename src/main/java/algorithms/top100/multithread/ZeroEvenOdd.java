package algorithms.top100.multithread;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * Created by yangyuan on 2020/1/13.
 */
public class ZeroEvenOdd {

    private Semaphore zero = new Semaphore(1);

    private Semaphore even = new Semaphore(0);

    private Semaphore odd = new Semaphore(0);

    private int n;

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 0; i <= n; i++) {
            if (i%2==0) {
                zero.acquire();
                printNumber.accept(0);
                odd.release(1);
            }else {
                zero.acquire();
                printNumber.accept(0);
                even.release(1);
            }
        }
    }

    //偶数
    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <=n; i++) {//注意第一个值
            if (i%2==0) {
                even.acquire();
                printNumber.accept(i);
                zero.release();
            }
        }

    }

    //奇数
    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i =0; i<=n; i++) {
            if (i%2==1) {
                odd.acquire();
                printNumber.accept(i);
                zero.release();
            }
        }
    }

    public static void main(String[] args) {
        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(5);
        Thread thread = new Thread(new TaskZero(zeroEvenOdd));
        thread.start();
        Thread thread1 = new Thread(new TaskEven(zeroEvenOdd));
        thread1.start();
        Thread thread2 = new Thread(new TaskOdd(zeroEvenOdd));
        thread2.start();

    }
}

class TaskZero implements Runnable{

    ZeroEvenOdd zeroEvenOdd;

    public TaskZero (ZeroEvenOdd zeroEvenOdd){
        this.zeroEvenOdd = zeroEvenOdd;
    }

    @Override
    public void run() {
        try {
            zeroEvenOdd.zero(new IntConsumer());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class TaskEven implements Runnable{

    ZeroEvenOdd zeroEvenOdd;

    public TaskEven (ZeroEvenOdd zeroEvenOdd){
        this.zeroEvenOdd = zeroEvenOdd;
    }

    @Override
    public void run() {
        try {
            zeroEvenOdd.even(new IntConsumer());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class TaskOdd implements Runnable{

    ZeroEvenOdd zeroEvenOdd;

    public TaskOdd (ZeroEvenOdd zeroEvenOdd){
        this.zeroEvenOdd = zeroEvenOdd;
    }

    @Override
    public void run() {
        try {
            zeroEvenOdd.odd(new IntConsumer());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class IntConsumer{

    void accept(int x){
        System.out.println(x);
    }
}