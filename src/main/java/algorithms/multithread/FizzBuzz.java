package algorithms.multithread;

import java.util.concurrent.Semaphore;

/**
 * Created by yangyuan on 2020/3/20.
 * 1195. 交替打印字符串
 *编写一个可以从 1 到 n 输出代表这个数字的字符串的程序，但是：

 如果这个数字可以被 3 整除，输出 "fizz"。
 如果这个数字可以被 5 整除，输出 "buzz"。
 如果这个数字可以同时被 3 和 5 整除，输出 "fizzbuzz"。
 例如，当 n = 15，输出： 1, 2, fizz, 4, buzz, fizz, 7, 8, fizz, buzz, 11, fizz, 13, 14, fizzbuzz
 semaphore 实现
 会存在空执行的问题
 四个方法同时竞争资源，如果不是目标方法获得到资源了，会执行空操作（不输出）
 只有目标方法获取到资源了，才会输出数据。然后将curNum自增 传递给别的目标
 */
public class FizzBuzz {

    Semaphore s = new Semaphore(1);

    private int n;

    private int curNum = 1;

    public FizzBuzz(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz". 3
    public void fizz(Runnable printFizz) throws InterruptedException {
        for(;;){
            s.acquire(1);
            try {
                if (curNum > n) return;
                if (curNum%3 == 0 && curNum %5!= 0){
                    printFizz.run();
                    curNum++;
                }
            }finally{
                s.release();
            }
        }
    }

    // printBuzz.run() outputs "buzz". 5
    public void buzz(Runnable printBuzz) throws InterruptedException {
        for(;;){
            s.acquire(1);
            try {
                if (curNum > n) return;
                if (curNum%3 != 0 && curNum%5 == 0){
                    printBuzz.run() ;
                    curNum++;
                }
            }finally{
                s.release();
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz". 15
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        for (;;){
            s.acquire(1);
            try {
                if (curNum > n) return;
                if (curNum%3 == 0 && curNum%5 == 0){
                    printFizzBuzz.run();
                    curNum++;
                }
            }finally{
                s.release();
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        for (;;){
            s.acquire(1);
            try {
                if (curNum > n) return;
                if (curNum%3 != 0 && curNum%5 != 0){
                    printNumber.accept(curNum);
                    curNum++;
                }
            }finally{
                s.release();
            }
        }
    }

}
