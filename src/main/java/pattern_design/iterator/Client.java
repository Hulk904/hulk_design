package pattern_design.iterator;

import java.util.Vector;

/**
 * Created by yangyuan on 2018/3/23.
 * 迭代器模式设计两种角色  容器角色 和 迭代器角色
 * 容器角色会生成一个迭代器，迭代器 遍历数据
 * 就像jdk提供的迭代器
 * ArrayList实现了 Iterable接口，它只有一个方法  iterator（）返回Iterator对象
 */
public class Client {
    public static void main(String[] args) {
        Aggregate aggregate = new ConcreteAggregate(new Vector());
        aggregate.add("abc");
        aggregate.add("efg");
        aggregate.add("efeif");
        Iterator iterator = aggregate.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
