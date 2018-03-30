package pattern_design.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by yangyuan on 2018/3/25.
 */
public class LiSi implements Observer{
    public void update(Observable o, Object arg) {
        System.out.println("李斯：观察到韩非子活动");
        reportToQinShiHuang(arg.toString());
        System.out.println("汇报完毕。");
    }
    private void reportToQinShiHuang(String context){
        System.out.println("报告秦老板 ：" + context);
    }
}
