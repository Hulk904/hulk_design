package pattern_design.state;

/**
 * Created by yangyuan on 2018/3/30.
 */
public abstract class LifeState {

    protected Context context;

    public void setContext(Context context){
        this.context = context;
    }

    public Context getContext(){
        return this.context;
    }

    public abstract void open();
    public abstract void close();
    public abstract void start();
    public abstract void stop();
}
