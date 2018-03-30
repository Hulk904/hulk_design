package pattern_design.state;


/**
 * Created by yangyuan on 2018/3/30.
 */
public class CloseState extends LifeState{


    public void open() {
        context.setLifeState(Context.openState);
        context.getLifeState().open();
    }

    public void close() {
        System.out.println("电梯关门");
    }

    public void start() {
        context.setLifeState(Context.startState);
        context.getLifeState().start();
    }

    public void stop() {
    }
}
