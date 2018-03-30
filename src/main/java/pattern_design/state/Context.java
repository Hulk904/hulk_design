package pattern_design.state;

/**
 * Created by yangyuan on 2018/3/30.
 */
public class Context {

    private LifeState lifeState;

    public static  LifeState startState = new StartState();

    public static LifeState stopState = new StopState();

    public static  LifeState closeState = new CloseState();

    public static  LifeState openState = new OpenState();



    public void  setLifeState(LifeState lifeState){
        lifeState.setContext(this);
        this.lifeState = lifeState;
    }

    public LifeState getLifeState(){
        return this.lifeState;
    }

    public void start(){
        lifeState.start();

    }

    public void stop(){
        lifeState.stop();
    }

    public void close(){
        lifeState.close();
    }

    public void open(){
        lifeState.open();
    }
}
