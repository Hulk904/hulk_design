package pattern_design.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by yangyuan on 2018/3/25.
 */
public class YangSi implements Observer{
    public void update(Observable o, Object arg) {
        System.out.println("观察到韩非子活动");
        happy(arg.toString());

    }
    private void happy(String context){
        System.out.println(context);
    }
}
