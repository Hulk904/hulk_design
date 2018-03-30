package pattern_design.state;

/**
 * Created by yangyuan on 2018/3/30.
 */
public class StopState extends LifeState{

    public void open() {

    }

    public void close() {

    }

    public void start() {
        context.setLifeState(Context.startState);
        context.getLifeState().start();
    }

    public void stop() {
        System.out.println("电梯停止");
    }
}
