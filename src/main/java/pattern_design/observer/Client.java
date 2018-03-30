package pattern_design.observer;

import java.util.Observer;

/**
 * Created by yangyuan on 2018/3/25.
 * java本身对观察者模式的支持
 * Observerble 被观察者为一个实现类，子类只用关心具体的业务就行了，添加观察者的方法实现
 * 又Observerble来实现了
 * 但是在客户端使用被观察者时只能使用实现类来定义了。
 *
 */
public class Client {
    public static void main(String[] args) {
        HanFeiZi observable = new HanFeiZi();
        Observer lisi = new LiSi();
        observable.addObserver(lisi);
        Observer yangsi  = new YangSi();
        observable.addObserver(yangsi);
        observable.haveFun();
        observable.haveLunch();

    }
}
