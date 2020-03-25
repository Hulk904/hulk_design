package algorithms.multithread;

import java.util.concurrent.CyclicBarrier;

/**
 * Created by yangyuan on 2020/3/20.
 * 通过cyclicbarrier实现
 * 每轮只产生一个数
 */
public class FizzBuzz2 {

    CyclicBarrier c = new CyclicBarrier(4);

    private int n;

    public FizzBuzz2(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz". 3
    public void fizz(Runnable printFizz) throws InterruptedException {
        for (int i = 1;  i <= n; i++){
            if (i%3 == 0 && i%5 != 0){
                printFizz.run();
            }
            try {
                c.await();
            }catch (Exception ex){

            }
        }
    }

    // printBuzz.run() outputs "buzz". 5
    public void buzz(Runnable printBuzz) throws InterruptedException {
        for (int i = 1;  i <= n; i++){
            if (i%3 != 0 && i%5 == 0){
                printBuzz.run();
            }
            try{
                c.await();
            }catch(Exception w){}
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz". 15
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        for (int i = 1;  i <= n; i++){
            if (i%3 == 0 && i%5 == 0){
                printFizzBuzz.run();
            }
            try {
                c.await();
            }catch (Exception e){}
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1;  i <= n; i++){
            if (i%3 != 0 && i%5 != 0){
                printNumber.accept(i);
            }
            try {
                c.await();
            }catch (Exception e){}
        }
    }
}
