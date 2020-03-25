package algorithms.multithread;

import java.util.concurrent.Semaphore;

/**
 * Created by yangyuan on 2020/1/13.
 * 1116. 打印零与奇偶数
 *
 * 相同的一个 ZeroEvenOdd 类实例将会传递给三个不同的线程：

 线程 A 将调用 zero()，它只输出 0 。
 线程 B 将调用 even()，它只输出偶数。
 线程 C 将调用 odd()，它只输出奇数。
 每个线程都有一个 printNumber 方法来输出一个整数。请修改给出的代码以输出整数序列 010203040506... ，其中序列的长度必须为 2n。
 跟FizzBuzz不同的是， 这个知道目标是谁，所以可以有目标的传递信息。

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