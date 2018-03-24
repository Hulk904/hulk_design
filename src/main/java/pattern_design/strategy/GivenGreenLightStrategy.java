package pattern_design.strategy;

/**
 * Created by yangyuan on 2018/3/22.
 */
public class GivenGreenLightStrategy implements  Strategy {

    public void operate() {
        System.out.println("策略2");
    }
}
