package pattern_design.state;

/**
 * Created by yangyuan on 2018/3/30.
 */
public class OpenState extends LifeState{

    public void open() {
        System.out.println("电梯开门");

    }

    public void close() {
        context.setLifeState(Context.closeState);
        context.getLifeState().close();
    }

    public void start() {

    }

    public void stop() {

    }
}
