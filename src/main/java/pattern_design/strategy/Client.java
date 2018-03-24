package pattern_design.strategy;

/**
 * Created by yangyuan on 2018/3/22.
 * Context作为使用场景
 * 缺点：策略类增多，所有的策略都需要对外暴露（策略多于四个的时候要考虑使用混合模式了）
 */
public class Client {
    public static void main(String[] args) {
        Strategy strategy = new BackDoorStrategy();
        Context  context = new Context(strategy);
        context.operate();
        strategy = new BlockEnemyStrategy();
        context = new Context(strategy);
        context.operate();
    }
}
