import java.util.concurrent.*;

/**
 * Created by yangyuan on 2020/2/19.
 */
public class DivTask implements Runnable{

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadPoolExecutor pools = new ThreadPoolExecutor(0,
                Integer.MAX_VALUE, 0L, TimeUnit.SECONDS,
                new SynchronousQueue<>());
        for (int i = 0; i < 5; i++){
            Future future = pools.submit(new DivTask(100,i));//不会抛出异常
            //pools.execute 如果有异常可以抛出
            System.out.println(future.get());//可以捕获到异常
        }
    }

    int a,b;

    public DivTask(int a, int b){
        this.a = a;
        this.b = b;
    }

    @Override
    public void run() {
        double re = a/b;
        System.out.println(re);
    }
}
