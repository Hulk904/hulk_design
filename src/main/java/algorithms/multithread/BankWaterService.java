package algorithms.multithread;

import java.util.Map;
import java.util.concurrent.*;

/**
 * Created by yangyuan on 2020/3/20.
 * CyclicBarrier 工作方式。如果初始值为4，那么会每四个一组进行放行处理，期间是不需要任何重置操作的。。。
 */
public class BankWaterService implements Runnable{
    private CyclicBarrier c = new CyclicBarrier(4, this);

    private Executor executor = Executors.newFixedThreadPool(4);

    private ConcurrentHashMap<String, Integer> sheetBankWaterCount = new ConcurrentHashMap<>();

    private  void count (){
        for (int i = 0 ; i < 8; i++){//并发编程艺术上面写的是4  ，主要是为了讲解CyclicBarrier的使用
            executor.execute(() -> {
                sheetBankWaterCount.put(Thread.currentThread().getName(), 1);
                try {
                    c.await();
                } catch (InterruptedException | BrokenBarrierException exc){
                    exc.printStackTrace();
                }
            });
        }
    }

    @Override
    public void run() {
        int result = 0;
        System.out.println(result);
        for (Map.Entry<String, Integer> sheet : sheetBankWaterCount.entrySet()){
            System.out.println(sheet.getValue() + "====>" + sheet.getKey());
            result += sheet.getValue();
        }
        sheetBankWaterCount.put("result", result);
        System.out.println(result);
    }

    public static void main(String[] args) {
        BankWaterService bankWaterService = new BankWaterService();
        bankWaterService.count();
    }
}
