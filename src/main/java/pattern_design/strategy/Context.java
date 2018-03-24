package pattern_design.strategy;

/**
 * Created by yangyuan on 2018/3/22.
 */
public class Context {
    private Strategy strategy;
    public Context (Strategy strategy){
        this.strategy = strategy;
    }
    public void operate(){
        strategy.operate();
    }
}
