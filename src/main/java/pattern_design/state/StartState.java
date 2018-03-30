package pattern_design.state;

/**
 * Created by yangyuan on 2018/3/30.
 */
public class StartState extends LifeState{
    public void open() {

    }

    public void close() {

    }

    public void start() {
        System.out.println("电梯上下运行");
    }

    public void stop() {
        context.setLifeState(Context.stopState);
        context.getLifeState().stop();
    }
}
