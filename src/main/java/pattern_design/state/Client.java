package pattern_design.state;

/**
 * Created by yangyuan on 2018/3/30.
 * 1 context 的setLifeState 方法除了设置lifestate还要同时设置他的state的context为this
 * 2 对具体方法的响应：比如 在open状态需要在自己open方法中实现对应的逻辑，对应相关的响应则委派给context的state去执行
 * 3 先设置状态后执行相关方法的逻辑
 */
public class Client {
    public static void main(String[] args) {
        Context context = new Context();
        context.setLifeState(new StopState());//初始状态不一样运行结果不同
        context.open();
        context.close();
        context.start();
        context.stop();
    }
}
