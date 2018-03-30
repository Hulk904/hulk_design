package pattern_design.observer;

import java.util.Observable;

/**
 * Created by yangyuan on 2018/3/25.
 */
public class HanFeiZi extends Observable implements  IHanFeizi{

    public void haveLunch() {
        System.out.println("在吃饭");
        super.setChanged();
        super.notifyObservers("韩非子在吃饭");
    }

    public void haveFun() {
        System.out.println("在娱乐");
        super.setChanged();
        super.notifyObservers("韩非子在娱乐");
    }
}
