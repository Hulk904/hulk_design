package algorithms.multithread;

/**
 * Created by yangyuan on 2020/4/13.
 */
public class Singleton {

    //静态内部类
    private static class Holder{
        private static final Singleton instance = new Singleton();
    }

    private Singleton(){}

    public static Singleton getInstance(){
        return Holder.instance;
    }

    private static volatile  Singleton instance;


    //双重检测
    public static Singleton getInstance2(){
        if (instance == null){
            synchronized(Singleton.class){
                if (instance == null){
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
